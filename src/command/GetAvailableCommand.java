/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import com.google.gson.reflect.TypeToken;
import data.Player;
import java.lang.reflect.Type;
import java.util.ArrayList;
import ui.lobby.LobbyView;
import utils.JsonHandler;

/**
 *
 * @author w
 */
public class GetAvailableCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public GetAvailableCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        getAvailablePlayers();
    }
    
    private void getAvailablePlayers() {
        Type playersType = new TypeToken<ArrayList<Player>>() {}.getType();
        ArrayList<Player> getAvailablePlayers = JsonHandler.deserializeArray(responseData.get(1), playersType);
        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;
        lobbyScreen.displayAvailablePlayers(getAvailablePlayers);
    }
}
