/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import java.util.ArrayList;
import javafx.application.Platform;
import ui.OnlineGame;

/**
 *
 * @author w
 */
public class SendMoveCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public SendMoveCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        handleMove();
    }
    
    private void handleMove() {
        String playable = responseData.get(1);
        int x = Integer.valueOf(responseData.get(2));
        int y = Integer.valueOf(responseData.get(3));
        System.out.println("playable=" + playable + "x=" + x + "y=" + y);
        Platform.runLater(() -> {
            OnlineGame onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
            onlineGame.setMove(playable, (int) x, (int) y);
        });
    }
}
