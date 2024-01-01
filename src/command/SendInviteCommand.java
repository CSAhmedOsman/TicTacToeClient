/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import com.google.gson.reflect.TypeToken;
import data.GameInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import utils.JsonHandler;
import utils.Util;

/**
 *
 * @author w
 */
public class SendInviteCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public SendInviteCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        recieveInvit();
    }
    
    private void recieveInvit() {
        Type gameType = new TypeToken<GameInfo>() {
        }.getType();
        GameInfo game = JsonHandler.deserializeArray(responseData.get(1), gameType);
        int type = Integer.valueOf(responseData.get(2));
        switch (type) {
            case 1:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "Invitation To play", 1);
                });
                break;
            case 2:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "New Game", 2);
                });
                break;
            default:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "Exit Game", 3);
                });
                break;
        }

    }
}
