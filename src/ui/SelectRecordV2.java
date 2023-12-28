/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 *
 * @author Ahmed PC
 */
public class SelectRecordV2 extends GameBoard {

    private final ListView<Button> recordsListView;
    private boolean playerXTurn = true;
    private int playerXScore = 0;
    private int playerOScore = 0;
    private StringBuilder movesRecord = new StringBuilder();
    private int gameCounter = 1;
    private List<Button> gameRecords = new ArrayList<>(); // List to store game records
    private int currentMoveIndex = 0;
    private Timeline timeline;
    final long numberOfSeconds = 1L;
    private Button[][] buttons = new Button[3][3];
    private Thread simulationThread;

    public SelectRecordV2() {
        recordsListView = new ListView<>();
                String directoryPath = "C:\\files";
        recordsListView.setLayoutX(379.0);
        recordsListView.setLayoutY(155.0);
        recordsListView.setOpacity(0.68);
        recordsListView.setPrefHeight(415.0);
        recordsListView.setPrefWidth(300.0);
        recordsListView.setStyle("-fx-font-size: 24; -fx-background-radius: 30; -fx-background-color: #43115b;");

        dropShadow0.setColor(Color.valueOf("#757575"));
        dropShadow0.setSpread(0.82);
        recordsListView.setEffect(dropShadow0);

        paneGame.setLayoutX(25.0);
        paneGame.setLayoutY(128.0);

        btnExitGame.setLayoutX(266.0);
        btnExitGame.setLayoutY(542.0);

        btnNewGame.setDisable(true);
        btnNewGame.setOpacity(0.0);

        btnRecordeGame.setDisable(true);
        btnRecordeGame.setOpacity(0.0);

        pane.getChildren().add(recordsListView);
    }

    @Override
    protected void startGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position[i][j].setText("");
                position[i][j].setDisable(true);
                position[i][j].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
            }
        }
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);

        countThread = new Thread(() -> {
            while (isRunning && (winIndex()[boardSize - 1][1] == -1)) {
                try {
                    if (countDownLimit > 1) {
                        drawCount();
                    } else {
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

    }

    @Override
    protected void addHandlers() {

    }

}
