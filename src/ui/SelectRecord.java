/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import client.ClientApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import utils.Util;

/**
 *
 * @author Ahmed PC
 */
public class SelectRecord extends GameBoard {

    private final ListView<Button> recordsListView;

    public SelectRecord() {

        recordsListView = new ListView<>();

        recordsListView.setLayoutX(385.0);
        recordsListView.setLayoutY(100.0);
        recordsListView.setPrefHeight(420.0);
        recordsListView.setPrefWidth(300.0);
        recordsListView.setStyle("-fx-font-size: 24; -fx-background-radius: 30; -fx-background-color: #43115b;");

        dropShadow0.setColor(Color.valueOf("#757575"));
        dropShadow0.setSpread(0.82);
        recordsListView.setEffect(dropShadow0);

        pane0.setLayoutX(15.0);
        pane0.setLayoutY(70.0);

        btnExitGame.setLayoutX(242.0);
        btnExitGame.setLayoutY(542.0);
        btnExitGame.setText("Exit");

        btnNewGame.setDisable(true);
        btnNewGame.setOpacity(0.0);

        btnRecordeGame.setDisable(true);
        btnRecordeGame.setOpacity(0.0);

        labelCountNum.setText("");

        pane.getChildren().add(recordsListView);

        String directoryPath = "C:\\files";
        addTextFilesToListView(directoryPath);

        ClientApp.curDisplayedScreen = this;
        startGame();
    }

    @Override
    protected void startGame() {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position.length; j++) {
                paneGame.getChildren().remove(position[i][j]);
            }
        }

        position = new Button[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position[i][j] = new Button();
                position[i][j].setAlignment(javafx.geometry.Pos.CENTER);
                position[i][j].setMnemonicParsing(false);
                position[i][j].setPrefHeight(250 / boardSize);
                position[i][j].setPrefWidth(250 / boardSize);
                position[i][j].setText("");
                position[i][j].setDisable(true);
                position[i][j].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
                position[i][j].setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
                position[i][j].setFont(new Font("Arial Rounded MT Bold", (100 / boardSize)));
                position[i][j].setLayoutY((50 / (boardSize + 1)) + (i * ((250 / (boardSize)) + (50 / (boardSize + 1)))));
                position[i][j].setLayoutX((50 / (boardSize + 1)) + (j * ((250 / (boardSize)) + (50 / (boardSize + 1)))));
                paneGame.getChildren().add(position[i][j]);
            }
        }

        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);

    }

    @Override
    protected void nextTern() {

    }

    @Override
    protected void addHandlers() {

    }

    private void addTextFilesToListView(String path) {
        File directory = new File(path);

        if (!(directory.exists() && directory.isDirectory())) {
            directory.mkdirs();
        }
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".bin"));
        if (files != null) {
            for (File file : files) {
                String fileNameWithExtension = file.getName();
                int lastDotIndex = fileNameWithExtension.lastIndexOf('.');
                String fileNameWithoutExtension;
                if (lastDotIndex > 0) {
                    fileNameWithoutExtension = fileNameWithExtension.substring(0, lastDotIndex);
                } else {
                    fileNameWithoutExtension = fileNameWithExtension;
                }
                Button button = new Button(fileNameWithoutExtension);
                button.setStyle("-fx-background-radius: 100; -fx-background-color: #EAD3D7;");
                button.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
                button.setFont(new Font("Franklin Gothic Demi Cond", 18.0));
                button.setCursor(Cursor.HAND);
                button.setOnAction((event) -> {
                    displayFileContent(file.getAbsolutePath());
                    int index = recordsListView.getItems().indexOf(button);
                    recordsListView.getSelectionModel().select(index);
                });
                recordsListView.getItems().add(button);
            }
        }
    }

    @Override
    protected void winner(int[][] winIndexes) {
        isRunning = false;
        if (winIndexes[boardSize - 1][1] != -1) {
            for (int i = 0; i < boardSize; i++) {
                position[winIndexes[i][0]][winIndexes[i][1]].setStyle("-fx-background-radius: 10; -fx-background-color: #0A8AE0;");
                position[winIndexes[i][0]][winIndexes[i][1]].setEffect(dropShadow1);
            }
            if (position[winIndexes[boardSize - 1][0]][winIndexes[boardSize - 1][1]].getText() == "X") {
                labelPlayerXNum.setText("" + (Integer.valueOf(labelPlayerXNum.getText()) + 1));
            } else if (position[winIndexes[boardSize - 1][0]][winIndexes[boardSize - 1][1]].getText() == "O") {
                labelPlayerONum.setText("" + (Integer.valueOf(labelPlayerONum.getText()) + 1));
            }
        }//To change body of generated methods, choose Tools | Templates.
    }

    private void displayFileContent(String filePath) {
        recordsListView.setDisable(true);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            simulateMovesFromRecord(content.toString());
        } catch (IOException e) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Show Record Error", "Error While reading Record file");
        }
    }

    private void simulateMovesFromRecord(String record) {
        String[] board = record.split("::\n");
        boardSize = Integer.valueOf(board[0]);
        startGame(); // Clear the board before simulating moves
        String[] moves = board[1].split("\n");
        //startGame();
        //String[] moves = record.split("\n");
        String turn = moves[moves.length - 1];

        countThread = new Thread(() -> {
            for (int i = 0; i < moves.length - 1; i++) {
                String[] player = moves[i].split(", ");
                String[] moveDetails = moves[i].split(": ");
                String[] coordinates = moveDetails[1].split(", ");
                int rowIndex = Integer.parseInt(coordinates[0]);
                int columnIndex = Integer.parseInt(coordinates[1]);
                Platform.runLater(() -> {
                    labelCount.setText("Turn: " + player[0] + " " + player[1]);
                });
                Platform.runLater(() -> {
                    position[rowIndex][columnIndex].setText(player[1]);
                });

                try {
                    Thread.sleep(1000); // Sleep for 2 seconds between moves
                } catch (InterruptedException e) {
                    Platform.runLater(() -> recordsListView.setDisable(false));
                    Util.showAlertDialog(Alert.AlertType.ERROR, "Show Record Error", "Error While reading Record file");
                    countThread.stop();
                }
            }
            Platform.runLater(() -> {
                String type;
                type = checkWin();
                if (type.equals("Draw")) {
                    labelCount.setText("You Draw");
                } else if (type.equals(turn)) {
                    labelCount.setText("You Win");
                } else {
                    labelCount.setText("You Lose");
                    int[][] winIndexes = winIndex();
                    if (winIndexes[boardSize - 1][1] != -1) {
                        for (int i = 0; i < boardSize; i++) {
                            position[winIndexes[i][0]][winIndexes[i][1]].setStyle("-fx-background-radius: 10; -fx-background-color: #E00205;");
                        }
                    }
                }
            });
            Platform.runLater(() -> recordsListView.setDisable(false));
        });
        countThread.start();
    }

    private String checkWin() {
        String type = "Draw";
        int[][] winIndexes = winIndex();
        if (winIndexes[boardSize - 1][1] != -1) {
            type = position[winIndexes[0][0]][winIndexes[0][1]].getText();
            winner(winIndexes);

        }
        return type;
    }
}
