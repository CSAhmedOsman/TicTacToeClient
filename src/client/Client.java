/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exception.NotConnectedException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import ui.LobbyScreenUI;
import ui.GameBoard;
import ui.LoginScreenUI;
import utils.Constants;
import utils.Util;

/**
 *
 * @author w
 */
public class Client {

    Socket mySocket;
    DataInputStream in;
    PrintStream out;
    ArrayList responceData;
    boolean isConnected;

    private static Client singletonClient;

    private Client() {
    }

    public static Client getClient() {
        if (singletonClient == null) {
            singletonClient = new Client();
            singletonClient.connect();
        }
        return singletonClient;
    }

    public void connect() {
        try {
            mySocket = new Socket(Constants.IP_ADDRESS, Constants.PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
            isConnected = true;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        startListening();
    }

    public void closeConnection() {
        try {
            in.close();
            out.close();
            mySocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendRequest(String gson) throws NotConnectedException {
        if (!isConnected) {
            throw new NotConnectedException("Client is not connected to the server");
        }
        out.println(gson);
    }

    public void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed())) {
                    String gsonResponse = in.readLine();
                    if (!gsonResponse.isEmpty()) {
                        handleResponse(gsonResponse);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    public void handleResponse(String gsonResponce) {

        Type listType = new TypeToken<ArrayList<Object>>() {
        }.getType();
        Gson gson = new Gson();
        responceData = gson.fromJson(gsonResponce, listType);
        double action = (double) responceData.get(0);

        switch ((int) action) {
            case Constants.REGISTER:
                register();
                break;
            case Constants.LOGIN:
                login();
                break;
            case 3:
                //TODO request();
                break;
            case 4:
                //TODO accept();
                break;
            case 5:
                //TODO updateBoard();
                break;
            case 6:
                //TODO logout();
                break;
            case 7:
                // TODO save();
                break;
            case 8:
                //TODO finish();
                break;
            case 9:
                //TODO updateScore();
                break;
            case Constants.SENDMESSAGE:
                recieveMessage();
                break;
            case 11:
                //TODO getAvailablePlayer();
                break;
            case Constants.BROADCAST_MESSAGE:
                recieveBroadcastMessage();
                break;
            case Constants.ADD_FRIEND:
                addFriend();
                break;
            case Constants.REMOVE_FRIEND:
                removeFriend();
                break;
            case Constants.BLOCK_PLAYER:
                blockPlayer();
                break;
            case Constants.UN_BLOCK_PLAYER:
                unBlockPlayer();
                break;
        }
    }

    private void register() {
        boolean registerStatus = (boolean) responceData.get(1);

        if (registerStatus) {
            Parent loginScreen = new LoginScreenUI();
            Util.displayScreen(loginScreen);
        } else {
            // Maybe Throw
            Platform.runLater(()-> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "This Email is Already Login");
            });
        }
    }

    private void login() {
        double userId = (double) responceData.get(1);
        if (userId >= 0) {
            Parent lobbyScreen = new LobbyScreenUI((int) userId);
            Util.displayScreen(lobbyScreen);
        } else {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Or Password is Incorrect.");
            });
        }
    }

    private void recieveBroadcastMessage() {
        String srcPlayerName = (String) responceData.get(1);
        String message = (String) responceData.get(2);
        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;
        lobbyScreen.desplayMessage(srcPlayerName, message);
    }

    private void recieveMessage() {
        String message = (String) responceData.get(1);
        String sourceplayerName = (String) responceData.get(2);

        GameBoard gameBoard = (GameBoard) ClientApp.currentScreen;
        gameBoard.displayMessage(sourceplayerName, message);
    }

    private void addFriend() {
        boolean isFriend = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;

        if (isFriend) {
            lobbyScreen.addFriend();
        }
    }

    private void removeFriend() {
        boolean isNotFriend = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;

        if (isNotFriend) {
            lobbyScreen.removeFriend();
        }
    }
    
    private void blockPlayer() {
        boolean isBlockedPlayer = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;

        if (isBlockedPlayer) {
            lobbyScreen.blockPlayer();
        }
    }

    private void unBlockPlayer() {
        boolean isUnBlocked = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;

        if (isUnBlocked) {
            lobbyScreen.unBlockPlayer();
        }
    }
}
