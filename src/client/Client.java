/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Player;
import utils.PlayerStorage;
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
import ui.lobby.LobbyView;
import ui.GameBoard;
import ui.login.LoginView;
import utils.Constants;
import utils.Util;

/**
 *
 * @author w
 */
public class Client {
    
    private Thread thread;

    private Socket mySocket;
    private DataInputStream in;
    private PrintStream out;
    private ArrayList responceData;
    private boolean isConnected;

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
            isConnected= false;
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

    private void startListening() {
        thread = new Thread(() -> {
            try {
                while (isConnected&& mySocket != null && !(mySocket.isClosed())) {
                    String gsonResponse = in.readLine();
                    if (!gsonResponse.isEmpty()) {
                        handleResponse(gsonResponse);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        thread.start();
    }

    private void handleResponse(String gsonResponce) {

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
            case Constants.GET_AVAILIABLE_PLAYERS:
                getAvailablePlayers();
                break;
            case Constants.REQUEST:
                request();
                break;
            case 5:
                //TODO accept();
                break;
            case 6:
                //TODO updateBoard();
                break;
            case 7:
                //TODO logout();
                break;
            case 8:
                // TODO save();
                break;
            case 9:
                //TODO finish();
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
            Parent loginScreen = new LoginView();
            Util.displayScreen(loginScreen);
        } else {
            // Maybe Throw
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "This Email is Already Login");
            });
        }
    }

    private void login() {

        double playerId = (double) responceData.get(1);
        if (playerId >= 0) {
            Parent lobbyScreen = new LobbyView((int) playerId);

            Util.displayScreen(lobbyScreen);
            PlayerStorage.saveUserId((int) playerId);
        } else if (playerId == -1) {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Or Password is Incorrect.");
            });
        } else {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Is Already Login");
            });
        }
    }

    private void getAvailablePlayers() {
        System.out.println("getAvailablePlayers in client");
        ArrayList<Player> getAvailablePlayers = new ArrayList<>();
        Player player;
        double id, score;
        String name;

        for (int i = 1; i < responceData.size(); i += 3) {
            id = (double) responceData.get(i);
            name = (String) responceData.get(i + 1);
            score = (double) responceData.get(i + 2);
            player = new Player((int) id, name, (int) score);
            getAvailablePlayers.add(player);
            System.out.println("player Data :" + player.getId() + " " + player.getName() + " " + player.getScore());
        }

        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;
        lobbyScreen.displayAvailablePlayers(getAvailablePlayers);
    }

    private void request() {
        double senderId = (double) responceData.get(1);
        String sendername = (String) responceData.get(2);
        double senderScore = (double) responceData.get(3);

        if (sendername != null) {
            System.out.println("Request handled successfully");
        } else {
            System.out.println("Failed to handle the request");

        }
    }

    private void recieveBroadcastMessage() {
        String srcPlayerName = (String) responceData.get(1);
        String message = (String) responceData.get(2);
        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;
        lobbyScreen.displayMessage(srcPlayerName, message);
    }

    private void recieveMessage() {
        String message = (String) responceData.get(1);
        String sourceplayerName = (String) responceData.get(2);

        GameBoard gameBoard = (GameBoard) ClientApp.currentScreen;
        gameBoard.displayMessage(sourceplayerName, message);
    }

    private void addFriend() {
        boolean isFriend = (boolean) responceData.get(1);

        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;

        if (isFriend) {
            lobbyScreen.addFriend();
        }
    }

    private void removeFriend() {
        boolean isNotFriend = (boolean) responceData.get(1);

        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;

        if (isNotFriend) {
            lobbyScreen.removeFriend();
        }
    }

    private void blockPlayer() {
        boolean isBlockedPlayer = (boolean) responceData.get(1);

        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;

        if (isBlockedPlayer) {
            lobbyScreen.blockPlayer();
        }
    }

    private void unBlockPlayer() {
        boolean isUnBlocked = (boolean) responceData.get(1);

        LobbyView lobbyScreen = (LobbyView) ClientApp.currentScreen;

        if (isUnBlocked) {
            lobbyScreen.unBlockPlayer();
        }
    }
}
