/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import java.util.ArrayList;
import ui.OnlineGame;

/**
 *
 * @author w
 */
public class SendMessageCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public SendMessageCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        recieveMessage();
    }
    
    private void recieveMessage() {
        String message = responseData.get(1);
        String sourceplayerName = responseData.get(2);

        OnlineGame onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
        onlineGame.displayMessage(sourceplayerName, message);
    }
}
