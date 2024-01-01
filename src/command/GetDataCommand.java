/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import data.Player;
import java.util.ArrayList;
import ui.UserProfileUI;

/**
 *
 * @author w
 */
public class GetDataCommand implements ResponceCommand {

    private ArrayList<String> responseData;

    public GetDataCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        getDataOfPlayer();
    }

    private void getDataOfPlayer() {
        String name = responseData.get(1);
        String email = responseData.get(2);
        String pass = responseData.get(3);

        Player player = new Player(name, email, pass);

        UserProfileUI userProfileUI = (UserProfileUI) ClientApp.curDisplayedScreen;
        userProfileUI.setData(player);
    }
}
