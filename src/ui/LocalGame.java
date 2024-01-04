/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import client.ClientApp;
import javafx.scene.control.Alert;
import utils.Util;

/**
 *
 * @author Ahmed PC
 */
public class LocalGame extends GameBoard {

    public LocalGame(int boardSize) {
        super(boardSize);
        ClientApp.curDisplayedScreen = this;
        pane.getChildren().add(win);
        addHandlers();
        startGame();
    }

    @Override
    public void startGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position[i][j].setText("");
                position[i][j].setDisable(false);
                position[i][j].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
            }
        }

        //---------------ahmed work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;
        isRecord = false;
        btnRecordeGame.setDisable(false);

        //------------Handlers------
        //----------Game Limits countDownLimit thread
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
                    isRunning = false;
                    Util.showAlertDialog(Alert.AlertType.ERROR, "CountDown Error", "Error While Draw CountDown");
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
        } else {
             for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        position[i][j].setDisable(true);
                    }
                }
            if (winIndexes[boardSize - 1][1] != -1) {
                winner(winIndexes);
                playVideo("win");
                
            } else {
                drawer();
                playVideo("draw");
            }
            // save file if recorded ---
            recordedGame += isXTurn ? "X" : "O";
            if (isRecord) {
                saveRecordFile();
            }
        }
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
                    recordedGame += (isXTurn ? (player1Name + ", X") : (player2Name + ", O")) + ", cell: " + indexi + ", " + indexj + "\n";
                    playedKey++;
                    nextTern();
                });
            }
        }
    }

}
