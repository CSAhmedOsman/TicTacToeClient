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
public class RemoveFriendCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public RemoveFriendCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        removeFriend();
    }
    
    private void removeFriend() {
        boolean isNotFriend = Boolean.valueOf(responseData.get(1));

        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;

        if (isNotFriend) {
            lobbyScreen.removeFriend();
        }
    }
}
