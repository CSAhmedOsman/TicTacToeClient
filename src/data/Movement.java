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
public class Movement {
    private final int ID;
    private final int GAME_ID;
    private MovementType type;
    private int position;//Maybe short
    private int order;//Maybe short

    public Movement(int id, int gameId, MovementType type, int position, int order) {
        this.ID = id;
        this.GAME_ID = gameId;
        this.type = type;
        this.position = position;
        this.order = order;
    }
    
    public int getID() {
        return ID;
    }

    public int getGAME_ID() {
        return GAME_ID;
    }
    
    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}