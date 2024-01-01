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
import ui.login.LoginView;
import utils.Util;

/**
 *
 * @author w
 */
public class RegisterCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public RegisterCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        register();
    }
    
    private void register() {
        boolean registerStatus = Boolean.valueOf(responseData.get(1));

        if (registerStatus) {
            Parent loginScreen = new LoginView();
            Util.displayScreen(loginScreen);
        } else {
            // Maybe Throw
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "SomeThing Wrong Happen. Check For The Network.");
            });
        }
    }
}
