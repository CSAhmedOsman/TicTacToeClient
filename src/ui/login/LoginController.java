/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.login;

/**
 *
 * @author w
 */
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

public class LoginController {

    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;

        setListeners(loginView);
    }

    private void setListeners(LoginView loginView) {
        loginView.setLoginBtnAction(this::onLoginBtnClicked);
        loginView.setCloseBtnAction(this::handleClose);
        loginView.setMinimizeBtnAction(this::handleMinimize);
    }

    private void onLoginBtnClicked(ActionEvent event) {

        Player player = getCurrentPlayer();
        if (player == null)
            return;

        player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));

        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.LOGIN), 
                JsonHandler.serelizeObject(player));
        
        sendRequest(gsonRequest);
    }

    public Player getCurrentPlayer() {
        String email = loginView.getEmail();
        String password = loginView.getPassword();

        if (!Validating.validateLogin(email, password)) {
            return null;
        }

        
        Player player = new Player(email, password);

        return player;
    }
    
    public void sendRequest(String gsonRequest) {
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed\n" + ex.getMessage());
        }
    }
    
    private void handleClose(ActionEvent event) {
        ClientApp.stage.close();
        Client.getClient().closeConnection();
    }

    private void handleMinimize(ActionEvent event) {
        ClientApp.stage.setIconified(true);
    }
}