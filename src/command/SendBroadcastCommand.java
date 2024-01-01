/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import java.util.ArrayList;
import ui.lobby.LobbyView;

/**
 *
 * @author w
 */
public class SendBroadcastCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public SendBroadcastCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        recieveBroadcastMessage();
    }
    
    private void recieveBroadcastMessage() {
        String srcPlayerName = responseData.get(1);
        String message = responseData.get(2);
        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;
        lobbyScreen.displayMessage(srcPlayerName, message);
    }
}
