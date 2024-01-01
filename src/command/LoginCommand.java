/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import ui.lobby.LobbyView;
import utils.PlayerStorage;
import utils.Util;

/**
 *
 * @author w
 */
public class LoginCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public LoginCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        login();
    }
    
    private void login() {
        int playerId = Integer.valueOf(responseData.get(1));
        if (playerId >= 0) {
            Parent lobbyScreen = new LobbyView(playerId);

            Util.displayScreen(lobbyScreen);
            PlayerStorage.saveUserId(playerId);
        } else if (playerId == -1) {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Or Password is Incorrect.");
            });
        } else {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Is Already Login");
            });
        }
    }
}
