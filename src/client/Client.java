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
import exception.NotConnectedException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ui.LobbyScreenUI;
import ui.GameBoard;
import ui.LocalGame;
import ui.LoginScreenUI;
import ui.ModesScreenUI;
import ui.OnlineGame;
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
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
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

    private void startListening() {
        new Thread(() -> {
            try {
                while (mySocket != null && !(mySocket.isClosed())) {
                    System.out.println("Call To StartListening");
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
                // accept();
                break;
            case 6:
                //TODO
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
            case Constants.SENDINVITE:
                recieveInvit();
                break;
            case Constants.BROADCAST_MESSAGE:
                recieveBroadcastMessage();
                break;
            case Constants.ACCEPTGAME:
                startGame();
                break;
            case Constants.SENDMOVE:
                handleMove();
                break;
            case 15:
                //todo
                break;
            case Constants.EXIT_PLAYER_GAME:
                handleExit();
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
            Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "SomeThing Wrong Happen. Check For The Network.");
        }
    }

    private void login() {
        double userId = (double) responceData.get(1);
        Platform.runLater(() -> {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", userId + " ");
        });
        if (userId >= 0) {
            Parent modesScreen = new LobbyScreenUI((int) userId);
            Util.displayScreen(modesScreen);
        } else {
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", "Your Email Or Password is Incorrect.");
            });
        }
    }

    private void getAvailablePlayers() {
        ArrayList<Player> getAvailablePlayers = (ArrayList) responceData.get(1);

        // LobbyScreenUI.setPlayers(getAvailablePlayers);
        //Parent AvailablePlayersScreen = new LobbyScreenUI(getAvailablePlayersStatus);
        //Util.displayScreen(AvailablePlayersScreen);
    }

    private void request() {
        boolean isRequestHandled = (boolean) responceData.get(1);
        if (isRequestHandled) {
            System.out.println("Request handled successfully");
        } else {
            System.out.println("Failed to handle the request");
            //Parent root = new LobbyScreenUI(responceData);
            //Util.displayScreen(root);

        }
    }

    private void recieveBroadcastMessage() {
        String srcPlayerName = (String) responceData.get(1);
        String message = (String) responceData.get(2);
        System.out.println("RecieveBroadCastMessage");
        LobbyScreenUI lobbyScreen = (LobbyScreenUI) ClientApp.currentScreen;
        lobbyScreen.desplayMessage(srcPlayerName, message);
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

}
