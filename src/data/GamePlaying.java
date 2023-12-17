/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author w
 */
public class GamePlaying {
    private final int playerId;
    private final int gameId;
    private int score;

    public GamePlaying(int playerId, int gameId, int score) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.score = score;
    }

    public GamePlaying(int playerId, int gameId) {
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}