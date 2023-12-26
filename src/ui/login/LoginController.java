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
import com.google.gson.Gson;
import data.Player;
import exception.NotConnectedException;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import utils.Constants;
import utils.PasswordEncryptor;
import utils.Util;
import utils.Validating;

public class LoginController {

    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;

        setListeners(view);
    }

    private void setListeners(LoginView view1) {
        view1.setLoginButtonAction(this::onLoginBtnClicked);
        view1.setCloseButtonAction(this::handleClose);
        view1.setMinimizeButtonAction(this::handleMinimize);
    }

    private void onLoginBtnClicked(ActionEvent event) {
        Player player = getCurrentPlayer();
        if (player == null)
            return;

        player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));

        Gson gson = new Gson();
        ArrayList<Object> jsonRequest = new ArrayList<>();
        jsonRequest.add(Constants.LOGIN);
        jsonRequest.add(player);
        String gsonRequest = gson.toJson(jsonRequest);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed\n" + ex.getMessage());
        }
    }

    public Player getCurrentPlayer() {
        String email = view.getEmail();
        String password = view.getPassword();

        Player player = null;

        if (!Validating.validateLogin(email, password)) {
            return player;
        }

        player = new Player(email, password);

        return player;
    }
    
    private void handleClose(ActionEvent event) {
        ClientApp.stage.close();
        Client.getClient().closeConnection();
    }

    private void handleMinimize(ActionEvent event) {
        ClientApp.stage.setIconified(true);
    }
}