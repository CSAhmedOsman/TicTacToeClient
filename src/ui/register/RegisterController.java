/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.register;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import data.Player;
import exception.NotConnectedException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import utils.Constants;
import utils.PasswordEncryptor;
import utils.Util;

/**
 *
 * @author w
 */
public class RegisterController {

    private final RegisterView view;

    public RegisterController(RegisterView view) {
        this.view = view;

        view.setRegisterButtonAction(this::handleRegister);
        view.setCloseButtonAction(this::handleClose);
        view.setMinimizeButtonAction(this::handleMinimize);
    }

    private void handleRegister(ActionEvent event) {
        Player player = view.makeNewPlayer();

        if(player== null)
            return;
        
        player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));
        
        Gson gson= new Gson();
        ArrayList jsonArr= new ArrayList();
        jsonArr.add(Constants.REGISTER);
        jsonArr.add(player);
        
        String gsonRequest = gson.toJson(jsonArr);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed");
        }
    }

    private void handleClose(ActionEvent event) {
        Client.getClient().closeConnection();
        ClientApp.stage.close();
    }

    private void handleMinimize(ActionEvent event) {
        ClientApp.stage.setIconified(true);
    }
}