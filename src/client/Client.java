/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Player;
import data.GameInfo;
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
import ui.LobbyScreenUI;
import ui.GameBoard;
import ui.LocalGame;
import ui.LoginScreenUI;
import ui.ModesScreenUI;
import ui.OnlineGame;
import ui.UserProfileUI;
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
            thread.destroy();
            thread = null;
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
                while (mySocket != null && !(mySocket.isClosed())) {
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
            case Constants.BROADCAST_MESSAGE:
                recieveBroadcastMessage();
                break;
            case Constants.SENDMESSAGE:
                recieveMessage();
                break;
            case Constants.SENDINVITE:
                recieveInvit();
                break;
            case Constants.ACCEPTGAME:
                startGame();
                break;
            case Constants.SENDMOVE:
                handleMove();
                break;
            case Constants.EXIT_PLAYER_GAME:
                handleExit();
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
            case Constants.SETDATAOFPLAYER:
                getDataOfPlayer();
                break;
        }
    }

    private void getDataOfPlayer() {
        String name = (String) responceData.get(1);
        String email = (String) responceData.get(2);
        String pass = (String) responceData.get(3);

        Player player = new Player(name, email, pass);

        System.out.println(name + " " + email + " " + pass);
        UserProfileUI userProfileUI = (UserProfileUI) ClientApp.curDisplayedScreen;
        Platform.runLater(() -> {
            userProfileUI.setData(player);
        });
    }

    private void register() {
        boolean registerStatus = (boolean) responceData.get(1);

        if (registerStatus) {
            Parent loginScreen = new LoginScreenUI();
            Util.displayScreen(loginScreen);
        } else {
            // Maybe Throw
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "SomeThing Wrong Happen. Check For The Network.");
            });
        }
    }

    private void login() {

        double playerId = (double) responceData.get(1);
        if (playerId >= 0) {
            Parent lobbyScreen = new LobbyScreenUI((int) playerId);

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

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;
        Platform.runLater(()->{
            lobbyScreen.displayAvailablePlayers(getAvailablePlayers);        
        });
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
        System.out.println("RecieveBroadCastMessage");
        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;
        lobbyScreen.displayMessage(srcPlayerName, message);
    }

    private void recieveMessage() {
        String message = (String) responceData.get(1);
        String sourceplayerName = (String) responceData.get(2);

        OnlineGame onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
        onlineGame.displayMessage(sourceplayerName, message);
    }
//---------------------------Abdelrhman------------------------------

    private void recieveInvit() {
        Gson gson = new Gson();
        String jsonString = (String) responceData.get(1);
        GameInfo info = gson.fromJson(jsonString, GameInfo.class);
        double type = (double) responceData.get(2);
        if ((int) type == 2) {
            Platform.runLater(() -> {
                Util.invitationAlert(Alert.AlertType.CONFIRMATION, info, "New Game", 2);
            });
        } else if ((int) type == 1) {
            Platform.runLater(() -> {
                Util.invitationAlert(Alert.AlertType.CONFIRMATION, info, "Invitation To play", 1);
            });
        } else {
            Platform.runLater(() -> {
                Util.invitationAlert(Alert.AlertType.CONFIRMATION, info, "Exit Game", 3);
            });
        }

    }

    private void startGame() {
        Gson gson = new Gson();
        String jsonString = (String) responceData.get(1);
        GameInfo info = gson.fromJson(jsonString, GameInfo.class);

        boolean myTurn = (boolean) responceData.get(2);
        double type = (double) responceData.get(3);
        if ((int) type == 2) {
            OnlineGame game = (OnlineGame) ClientApp.curDisplayedScreen;
            Platform.runLater(() -> game.startGame());

        } else if ((int) type == 1) {
            Parent onlineGame = new OnlineGame(info, myTurn);
            Util.displayScreen(onlineGame);
        } else {
            OnlineGame game = (OnlineGame) ClientApp.curDisplayedScreen;
            Platform.runLater(() -> game.exitGame());
        }

    }

    private void handleMove() {
        String playable = (String) responceData.get(1);
        double x = (double) responceData.get(2);
        double y = (double) responceData.get(3);
        System.out.println("playable=" + playable + "x=" + x + "y=" + y);
        Platform.runLater(() -> {
            OnlineGame onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
            onlineGame.setMove(playable, (int) x, (int) y);
        });

    }

    private void handleExit() {
        OnlineGame game = (OnlineGame) ClientApp.curDisplayedScreen;
        Platform.runLater(() -> game.exitGame());
    }

    private void addFriend() {
        boolean isFriend = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;

        if (isFriend) {
            lobbyScreen.addFriend();
        }
    }

    private void removeFriend() {
        boolean isNotFriend = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;

        if (isNotFriend) {
            lobbyScreen.removeFriend();
        }
    }

    private void blockPlayer() {
        boolean isBlockedPlayer = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;

        if (isBlockedPlayer) {
            lobbyScreen.blockPlayer();
        }
    }

    private void unBlockPlayer() {
        boolean isUnBlocked = (boolean) responceData.get(1);

        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.curDisplayedScreen;

        if (isUnBlocked) {
            lobbyScreen.unBlockPlayer();
        }
    }

}
