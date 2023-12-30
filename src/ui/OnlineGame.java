/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import client.ClientApp;
import client.Client;
import data.GameInfo;
import exception.NotConnectedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import utils.Constants;
import utils.JsonHandler;
import utils.Util;

/**
 *
 * @author Ahmed PC
 */
public class OnlineGame extends GameBoard {

    protected final Pane paneMessage;
    protected final BorderPane borderMessage;
    protected final TextArea taMessage;
    protected final FlowPane flowPane;
    protected final TextField tfMessage;
    protected final Button btnSendMessage;
    int myId;
    int destPlayerId;
    boolean myTurn;
    protected GameInfo info;

    public OnlineGame(GameInfo info, boolean myTurn) {
        super(info.getSrcPlayerName(), info.getDestPlayerName());
        ClientApp.curDisplayedScreen = this;
        this.info = info;
        paneMessage = new Pane();
        borderMessage = new BorderPane();
        taMessage = new TextArea();
        flowPane = new FlowPane();
        tfMessage = new TextField();
        btnSendMessage = new Button();

        paneMessage.setLayoutX(411.0);
        paneMessage.setLayoutY(93.0);

        borderMessage.setMaxHeight(USE_PREF_SIZE);
        borderMessage.setMaxWidth(USE_PREF_SIZE);
        borderMessage.setMinHeight(USE_PREF_SIZE);
        borderMessage.setMinWidth(USE_PREF_SIZE);
        borderMessage.setPrefHeight(415.0);
        borderMessage.setPrefWidth(265.0);
        borderMessage.setStyle("-fx-background-radius: 20;");

        BorderPane.setAlignment(taMessage, javafx.geometry.Pos.CENTER);
        taMessage.setDisable(true);
        taMessage.setPrefWidth(0.0);
        taMessage.setStyle("-fx-textColor: black; -fx-background-radius: 10;");
        borderMessage.setCenter(taMessage);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);

        tfMessage.setPrefHeight(50.0);
        tfMessage.setPrefWidth(180.0);
        tfMessage.setStyle("-fx-background-radius: 10;");

        btnSendMessage.setMnemonicParsing(false);
        btnSendMessage.setPrefHeight(50.0);
        btnSendMessage.setPrefWidth(85.0);
        btnSendMessage.setStyle("-fx-background-color: #FD6D84; -fx-background-radius: 10;");
        btnSendMessage.setText("Send");
        btnSendMessage.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
        btnSendMessage.setFont(new Font(23.0));
        borderMessage.setBottom(flowPane);

        pane0.setLayoutX(46.0);
        pane0.setLayoutY(75.0);

        btnNewGame.setLayoutX(90.0);
        btnNewGame.setLayoutY(542.0);

        btnRecordeGame.setLayoutX(266.0);
        btnRecordeGame.setLayoutY(542.0);

        btnExitGame.setLayoutX(476.0);
        btnExitGame.setLayoutY(542.0);

        labelPlayerX.setText(player1Name);
        labelPlayerO.setText(player2Name);

        flowPane.getChildren().add(tfMessage);
        flowPane.getChildren().add(btnSendMessage);
        paneMessage.getChildren().add(borderMessage);
        pane.getChildren().add(paneMessage);
        pane.getChildren().add(win);
        pane.getChildren().add(lose);
        myId = info.getSrcPlayerId();
        destPlayerId = info.getDestPlayerId();

        this.myTurn = myTurn;

        startGame();

    }

    @Override
    public void startGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position[i][j].setText("");
                position[i][j].setDisable(!myTurn);
                position[i][j].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
            }

        }
        System.out.println("myId=" + myId + "x=" + destPlayerId + "y=" + myTurn);
        //---------------ahmed work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;
        isRecord = false;
        btnRecordeGame.setDisable(false);
        recordedGame = "";

        //----------Game Limits countDownLimit thread
        if (countThread != null) {
            countThread.stop();
        }
        countThread = new Thread(() -> {
            while (isRunning && (winIndex()[boardSize - 1][1] == -1)) {
                try {
                    if (countDownLimit > 1) {
                        drawCount();
                    } else {
                        sendMove((isXTurn ? "X" : "O"), -1, -1);
                        nextTern();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        countThread.start();
    }

    @Override
    protected void nextTern() {

        int[][] winIndexes = winIndex();
        if ((playedKey < boardSize * boardSize) && winIndexes[boardSize - 1][1] == -1) {
            changeTern();
            myTurn = !myTurn;
        } else {
            if (winIndexes[boardSize - 1][1] != -1) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        position[i][j].setDisable(true);
                    }
                }
                winner(winIndexes);
                if (myTurn) {
                    playWinVideo();
                    updateMyScore(1);
                } else {
                    playLoseVideo();
                }

            } else {
                drawer();
                updateMyScore(2);

            }
            // save file if recorded ---
            recordedGame += myTurn && isXTurn ? "X" : "O";
            if (isRecord) {
                saveRecordFile();
            }
            recordedGame = "";
        }
        changeBtnSatus();
    }

    @Override
    protected void addHandlers() {
        //X-O-Draws
        for (int i = 0; i < boardSize; i++) {
            final int indexi = i;
            for (int j = 0; j < boardSize; j++) {
                final int indexj = j;
                position[i][j].setOnAction((e) -> {
                    position[indexi][indexj].setText(isXTurn ? "X" : "O");
                    position[indexi][indexj].setDisable(true);
                    sendMove((isXTurn ? "X" : "O"), indexi, indexj);
                    recordedGame += (isXTurn ? (player1Name + ", X,") : (player2Name + ", O,")) + " cell: " + indexi + ", " + indexj + "\n";
                    playedKey++;
                    nextTern();
                });
            }
        }
        btnNewGame.setOnAction((e) -> {
            isRunning = false;
            countThread.stop();
            recordedGame = "";
            isRecord = false;
            newGameAlert(2);
        });
        btnExitGame.setOnAction((e) -> {
            isRunning = false;
            exitGameAlert(3);
        });
    }

    private void sendMove(String playable, int indexi, int indexj) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.SEND_MOVE), playable, 
                String.valueOf(indexi), String.valueOf(indexj), String.valueOf(destPlayerId));

        sendRequest(gsonRequest);
    }

    public void setMove(String current_player, int x, int y) {
        if (x != -1 && y != -1) {
            position[x][y].setText(current_player.equals("X") ? "X" : "O");
            position[x][y].setDisable(true);
            recordedGame += (isXTurn ? (player1Name + ", X,") : (player2Name + ", O,")) + " cell: " + x + ", " + y + "\n";
            playedKey++;
        }
        nextTern();
    }

    public void changeBtnSatus() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (position[i][j].getText() == "") {
                    position[i][j].setDisable(!myTurn);
                }
            }
        }
    }

    @Override
    protected void winner(int[][] winIndexes) {
        isRunning = false;
        if (winIndexes[boardSize - 1][1] != -1) {
            for (int i = 0; i < boardSize; i++) {
                position[winIndexes[i][0]][winIndexes[i][1]].setStyle("-fx-background-radius: 10; -fx-background-color: #FD6D84;");
                position[winIndexes[i][0]][winIndexes[i][1]].setEffect(dropShadow1);
            }
            paneCount.setOpacity(0.0);
            if (myTurn) {
                labelPlayerXNum.setText("" + (Integer.valueOf(labelPlayerXNum.getText()) + 1));
            } else {
                labelPlayerONum.setText("" + (Integer.valueOf(labelPlayerONum.getText()) + 1));
            }
        }
    }

    private void sendMessage(String message, int destination) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.SENDMESSAGE), 
                message, String.valueOf(destination));
        sendRequest(gsonRequest);
    }

    public void sendRequest(String gsonRequest) {
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayMessage(String srcPlayerName, String message) {
        Platform.runLater(() -> {
            Util.showAlertDialog(Alert.AlertType.CONFIRMATION, srcPlayerName, message);
        });
    }

    public void newGameAlert(int type) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.SEND_INVITE), 
                JsonHandler.serelizeObject(info), String.valueOf(type));
        sendRequest(gsonRequest);
    }

    public void exitGameAlert(int type) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.SEND_INVITE), 
                JsonHandler.serelizeObject(info), String.valueOf(type));
        sendRequest(gsonRequest);
    }

    public void exitGame() {
        isRunning = false;
        countThread.stop();
        Parent root = new ModesScreenUI();
        Util.displayScreen(root);
    }

    public void updateMyScore(int type) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.UPDATE_SCORE),
                JsonHandler.serelizeObject(info), String.valueOf(type));
        sendRequest(gsonRequest);
    }
}