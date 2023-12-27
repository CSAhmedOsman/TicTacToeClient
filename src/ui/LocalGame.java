/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Ahmed PC
 */
public class LocalGame extends GameBoard {

    public LocalGame() {
          pane.getChildren().add(win);
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
        addHandlers();

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
        } else {
            if (winIndexes[boardSize - 1][1] != -1) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        position[i][j].setDisable(true);
                    }
                }
                winner(winIndexes);
                playWinVideo();
            } else {
                drawer();
                playLoseVideo();
            }
            // save file if recorded ---
            recordedGame +=isXTurn ? "X" : "O";
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
                    recordedGame += (isXTurn ? (player1Name + ", X,") : (player2Name + ", O,")) + " cell: " + indexi + ", " + indexj + "\n";
                    playedKey++;
                    nextTern();
                });
            }
        }
    }

}
