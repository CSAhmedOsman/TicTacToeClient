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
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 *
 * @author Ahmed PC
 */
public class RobotGame extends GameBoard {

    protected int level;

    public RobotGame(int level) {
        super("Robot");
        pane.getChildren().add(win);
        pane.getChildren().add(lose);
        this.level = level;
        startGame();
    }

    private int findBestMove() {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE, score;

        List<Integer> availableMoves = new ArrayList<>();

        for (int i = 0; i < (boardSize * boardSize); i++) {
            if (position[i / boardSize][i % boardSize].getText().equals("")) {
                availableMoves.add(i);
            }
        }

        Collections.shuffle(availableMoves);

        for (int i : availableMoves) {
            position[i / boardSize][i % boardSize].setText("O");
            score = minimax(position, 1, false);
            position[i / boardSize][i % boardSize].setText("");

            if (score == 1) {
                return i;
            } else if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }
        return bestMove;
    }

    private int minimax(Button[][] board, int depth, boolean isMaximizing) {
        int result = evaluate(board);

        if (result != 0) {
            return result;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText("O");
                        if (level == 1) {
                            bestScore = Math.min(bestScore, minimax(board, 0, false)); // low
                        } else if (level == 2) {
                            bestScore = Math.max(bestScore, minimax(board, depth + 1, true)); // mid
                        } else {
                            bestScore = Math.max(bestScore, minimax(board, depth + 3, true)); // high
                        }
                        board[i][j].setText("");
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText("X");
                        if (level == 1) {
                            bestScore = Math.max(bestScore, minimax(board, 0, false)); // low
                        } else if (level == 2) {
                            bestScore = Math.max(bestScore, minimax(board, depth + 1, true)); // mid
                        } else {
                            bestScore = Math.min(bestScore, minimax(board, depth + 3, true)); // high
                        }
                        board[i][j].setText("");
                    }
                }
            }
            return bestScore;
        }
    }

    private int evaluate(Button[][] board) {
        int[][] winIndexes = winIndex();
        if (winIndexes[boardSize - 1][1] != -1) {

            if (board[winIndexes[boardSize - 1][0]][winIndexes[boardSize - 1][1]].getText().equals("O")) {
                return 1;
            } else if (board[winIndexes[boardSize - 1][0]][winIndexes[boardSize - 1][1]].getText().equals("X")) {
                return -1;
            }
        }
        return 0;
    }

    public void startGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position[i][j].setText("");
                position[i][j].setDisable(false);
                position[i][j].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
            }
        }

        //---------------Elham work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;
        isRecord = false;
        btnRecordeGame.setDisable(false);

        //------------Handlers------
        addEventHandlers();
        addHandlers();

        //----------Game Limits counter thread
        countThread = new Thread(() -> {
            while (isRunning && winIndex()[boardSize - 1][1] == -1) {
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
        });
        countThread.start();
    }

    @Override
    protected void nextTern() {
        int[][] winIndexes = winIndex();
        if ((playedKey < boardSize * boardSize) && winIndexes[boardSize - 1][1] == -1) {
            changeTern();
            if (!isXTurn) {
                robotTern();
            }
        } else {
            if (winIndexes[boardSize - 1][1] != -1) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        position[i][j].setDisable(true);
                    }
                }
                winner(winIndexes);
                if (isXTurn) {
                    playWinVideo();
                } else {
                    playLoseVideo();
                }
            } else {
                drawer();
            }
            recordedGame += isXTurn ? "X" : "O";
            if (isRecord) {
            saveRecordFile();
            }
        }
    }

    @Override
    protected void addHandlers() {
        // X-O-Draws With Robot
        for (int i = 0; i < boardSize; i++) {
            final int indexi = i;
            for (int j = 0; j < boardSize; j++) {
                final int indexj = j;
                position[i][j].setOnAction((e) -> {
                    if (isXTurn && position[indexi][indexj].getText().equals("")) {
                        position[indexi][indexj].setText("X");
                        position[indexi][indexj].setDisable(true);
                        recordedGame += (isXTurn ? (player1Name + ", X,") : (player2Name + ", O,")) + " cell: " + indexi + ", " + indexj + "\n";
                        playedKey++;
                        nextTern();
                    }
                });
            }
        }
    }

    protected void robotTern() {
        int[][] winIndexes = winIndex();
        if ((playedKey < boardSize * boardSize) && winIndexes[boardSize - 1][1] == -1) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                int robotMove = findBestMove();
                if (robotMove != -1) {
                    position[robotMove / boardSize][robotMove % boardSize].setText("O");
                    position[robotMove / boardSize][robotMove % boardSize].setDisable(true);
                    recordedGame += player2Name + " O" + " cell: " + (robotMove / 3) + ", " + (robotMove % 3) + "\n";
                    playedKey++;
                    nextTern();
                }
            });
            pause.play();
        }
    }
}
