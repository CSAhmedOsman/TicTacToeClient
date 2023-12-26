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
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.GET_AVAILIABLE_PLAYERS);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void sendMessageToAll(int sourceId, String broadcastMessage) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BROADCAST_MESSAGE);
        jsonRequest.add(sourceId);
        jsonRequest.add(broadcastMessage);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addFriend(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.ADD_FRIEND);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void removeFriend(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.REMOVE_FRIEND);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void blockPlayer(int playerId, int blockedId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(blockedId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void unBlockPlayer(int playerId, int blockedId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.UN_BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(blockedId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void makePlayerOnline(int playerId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.PLAYER_ONLINE);
        jsonRequest.add(playerId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
