/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.register;

import client.Client;
import client.ClientApp;
import data.Player;
import exception.NotConnectedException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import utils.JsonHandler;
import utils.Constants;
import utils.PasswordEncryptor;
import utils.Util;
import utils.Validating;

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
        Player player = makeNewPlayer();

        if(player== null)
            return;
        
        player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));
        
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.REGISTER), 
                JsonHandler.serelizeObject(player));
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed");
        }
    }

    public Player makeNewPlayer() {
        String username= view.getUsername();
        String email= view.getEmail();
        String password= view.getPassword();
        String confirmPassword= view.getConfirmPassword();
        
        Player player= null;
        
        if(!Validating.validateRegister(username, email, password, confirmPassword)) 
            return player;
        
        player = new Player(username, email, password);
        
        return player;
    }
    
    private void handleClose(ActionEvent event) {
        Client.getClient().closeConnection();
        ClientApp.stage.close();
    }

    private void handleMinimize(ActionEvent event) {
        ClientApp.stage.setIconified(true);
    }
}