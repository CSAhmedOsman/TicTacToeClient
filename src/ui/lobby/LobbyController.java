/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.lobby;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import exception.NotConnectedException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import ui.JsonHandler;
import ui.ModesScreenUI;
import utils.Constants;
import utils.Util;

/**
 *
 * @author w
 */
public class LobbyController {

    private final LobbyView view;

    public LobbyController(LobbyView view) {
        this.view = view;

        setListeners(view);

    }

    private void setListeners(LobbyView view1) {
        view1.setCloseButtonAction(this::onCloseBtnClicked);
        view1.setMinimizeButtonAction(this::onMinBtnClicked);
        view1.setBackButtonAction(this::onBackBtnClicked);
        view1.setSendButtonAction(this::onSendBtnClicked);
    }

    private void onCloseBtnClicked(ActionEvent event) {
        ClientApp.stage.close();
    }

    private void onMinBtnClicked(ActionEvent event) {
        ClientApp.stage.setIconified(true);
    }

    private void onBackBtnClicked(ActionEvent event) {
        Parent root = new ModesScreenUI();
        Util.displayScreen(root);
    }

    public void onSendBtnClicked(ActionEvent event) {
        String broadcastMessage = view.getMessageText();
        if (broadcastMessage.trim().isEmpty()) {
            return;
        }
        sendMessageToAll(view.getPlayerId(), broadcastMessage);
        view.clearMessageText();
    }

    public void getAvailablePlayers() {
        String gsonRequest = JsonHandler.serializeJson(Constants.GET_AVAILIABLE_PLAYERS);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void sendMessageToAll(int sourceId, String broadcastMessage) {
        
        String gsonRequest = JsonHandler.serializeJson(Constants.BROADCAST_MESSAGE, 
                sourceId, broadcastMessage);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addFriend(int playerId, int friendId) {
        String gsonRequest = JsonHandler.serializeJson(Constants.ADD_FRIEND, playerId, friendId);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void removeFriend(int playerId, int friendId) {
        
        String gsonRequest = JsonHandler.serializeJson(Constants.REMOVE_FRIEND, playerId, friendId);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void blockPlayer(int playerId, int blockedId) {
        String gsonRequest = JsonHandler.serializeJson(Constants.BLOCK_PLAYER, playerId, blockedId);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed\n" + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void unBlockPlayer(int playerId, int blockedId) {
        String gsonRequest = JsonHandler.serializeJson(Constants.UN_BLOCK_PLAYER, playerId, blockedId);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed\n" + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void makePlayerOnline(int playerId) {
        String gsonRequest = JsonHandler.serializeJson(Constants.UN_BLOCK_PLAYER, playerId);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
