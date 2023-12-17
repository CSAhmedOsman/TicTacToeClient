/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import client.ClientApp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Ahmed PC
 */
public class LocalGame extends GameBoard {

    public LocalGame() {
        startGame();
    }

    @Override
    public void startGame() {
        for (int i = 0; i < 9; i++) {
            position[i].setText("");
            position[i].setDisable(false);
            position[i].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
        }

        //---------------ahmed work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;

        //------------Handlers------
        addEventHandlers();
        addHandlers();

        //----------Game Limits countDownLimit thread
        new Thread(() -> {
            while (isRunning && winIndex()[0] == -1) {
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
        }).start();
    }

    @Override
    protected void nextTern() {
        int[] winIndexes = winIndex();
        if (playedKey < 9 && winIndexes[0] == -1) {
            changeTern();
        } else if (winIndexes[0] != -1) {
            for (int i = 0; i < 9; i++) {
                position[i].setDisable(true);
            }
            winner(winIndexes);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RobotGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            playWinVideo();
        } else {
            drawer();
        }
    }

    @Override
    protected void addHandlers() {
        //X-O-Draws
        for (int i = 0; i < 9; i++) {
            final int index = i;
            position[i].setOnAction((e) -> {
                position[index].setText(isXTurn ? "X" : "O");
                position[index].setDisable(true);
                playedKey++;
                nextTern();
            });
        }
    }

}
