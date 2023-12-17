/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Button;

/**
 *
 * @author Ahmed PC
 */
public class RobotGame extends GameBoard {

    protected int level;

    public RobotGame(int level) {
        super("Robot");
        this.level = level;
        startGame();
    }

    private int findBestMove() {
        System.out.println("Finding best move for the robot");
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE, score;

        List<Integer> availableMoves = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (position[i].getText().equals("")) {
                availableMoves.add(i);
            }
        }

        Collections.shuffle(availableMoves);

        for (int i : availableMoves) {
            position[i].setText("O");
            score = minimax(position, 1, false);
            position[i].setText("");

            if (score == 1) {
                return i;
            } else if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }
        return bestMove;
    }

    private int minimax(Button[] board, int depth, boolean isMaximizing) {
        int result = evaluate(board);

        if (result != 0) {
            return result;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i].getText().equals("")) {
                    board[i].setText("O");
                    if (level == 1) {
                        bestScore = Math.min(bestScore, minimax(board, 0, false)); // low
                    } else if (level == 2) {
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, true)); // mid
                    } else {
                        bestScore = Math.max(bestScore, minimax(board, 0, true)); // high
                    }
                    board[i].setText("");
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i].getText().equals("")) {
                    board[i].setText("X");
                    if (level == 1) {
                        bestScore = Math.max(bestScore, minimax(board, 0, false)); // low
                    } else if (level == 2) {
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, true)); // mid
                    } else {
                        bestScore = Math.min(bestScore, minimax(board, 0, false)); // high
                    }
                    board[i].setText("");
                }
            }
            return bestScore;
        }
    }

    private int evaluate(Button[] board) {
        int[] winIndexes = winIndex();
        if (winIndexes[0] != -1) {

            if (board[winIndexes[0]].getText().equals("O")) {
                return 1;
            } else if (board[winIndexes[0]].getText().equals("X")) {
                return -1;
            }
        }

        return 0;
    }

    public void startGame() {
        for (int i = 0; i < 9; i++) {
            position[i].setText("");
            position[i].setDisable(false);
            position[i].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
        }
        //---------------Elham work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;

        //------------Handlers------
        addEventHandlers();
        addHandlers();

        //----------Game Limits counter thread
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
                    Logger.getLogger(GameBoard.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    protected void nextTern() {
        int[] winIndexes = winIndex();
        if (playedKey < 9 && winIndexes[0] == -1) {
            if (!isXTurn) {
                int robotMove = findBestMove();
                if (robotMove != -1) {
                    Platform.runLater(() -> {
                        try {
                            Thread.sleep(2000);
                            position[robotMove].setText("O");
                            position[robotMove].setDisable(true);
                            nextTern();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RobotGame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
            changeTern();
        } else if (winIndexes[0] != -1) {
            for (int i = 0; i < 9; i++) {
                position[i].setDisable(true);
            }
            winner(winIndexes);
            if (isXTurn) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RobotGame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                playWinVideo();
            }
        } else {
            drawer();
        }
    }

    @Override
    protected void addHandlers() {
        // X-O-Draws With Robot
        for (int i = 0; i < 9; i++) {
            final int index = i;
            position[i].setOnAction((e) -> {
                position[index].setText("X");
                position[index].setDisable(true);
                playedKey++;
                changeTern();
                nextTern();
            });
        }
    }
}
