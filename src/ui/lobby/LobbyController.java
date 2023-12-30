/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.lobby;

import client.Client;
import client.ClientApp;
import exception.NotConnectedException;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import utils.JsonHandler;
import ui.ModesScreenUI;
import utils.Constants;
import utils.Util;

/**
 *
 * @author w
 */
public class LobbyController {

    private final LobbyView lobbyView;

    public LobbyController(LobbyView lobbyView) {
        this.lobbyView = lobbyView;

        setListeners();
    }

    private void setListeners() {
        lobbyView.setCloseBtnListener(this::onCloseBtnClicked);
        lobbyView.setMinBtnListener(this::onMinBtnClicked);
        lobbyView.setBackBtnListener(this::onBackBtnClicked);
        lobbyView.setSendBtnListener(this::onSendBtnClicked);
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
        String broadcastMessage = lobbyView.getMessageText();
        if (broadcastMessage.trim().isEmpty())
            return;
        sendMessageToAll(lobbyView.getPlayerId(), broadcastMessage);
        lobbyView.clearMessageText();
    }

    public void getAvailablePlayers() {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.GET_AVAILIABLE_PLAYERS));
        sendRequest(gsonRequest);
    }
    
    public void sendMessageToAll(int sourceId, String broadcastMessage) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.BROADCAST_MESSAGE), 
                String.valueOf(sourceId), broadcastMessage);
        
        sendRequest(gsonRequest);
    }

    public void addFriend(int playerId, int friendId) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.ADD_FRIEND), 
                String.valueOf(playerId), String.valueOf(friendId));
        
        sendRequest(gsonRequest);
    }

    public void removeFriend(int playerId, int friendId) {
        
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.REMOVE_FRIEND), String.valueOf(playerId), String.valueOf(friendId));
        
        sendRequest(gsonRequest);
    }

    public void blockPlayer(int playerId, int blockedId) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.BLOCK_PLAYER), String.valueOf(playerId), String.valueOf(blockedId));
        
        sendRequest(gsonRequest);
    }

    public void unBlockPlayer(int playerId, int blockedId) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.UN_BLOCK_PLAYER), String.valueOf(playerId), String.valueOf(blockedId));
        
        sendRequest(gsonRequest);
    }

    public void makePlayerOnline(int playerId) {
        String gsonRequest = JsonHandler.serializeJson(String.valueOf(Constants.ONLINE), String.valueOf(playerId));
        
        sendRequest(gsonRequest);
    }
    
    private void sendRequest(String gsonRequest) {
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}