package client;

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
import ui.lobby.LobbyView;
import utils.JsonHandler;
import ui.login.LoginView;
import ui.OnlineGame;
import ui.UserProfileUI;
import utils.Constants;
import utils.Util;

/**
 *
 * @author w
 */
public class Client {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 5005;

    private Thread thread;

    private Socket mySocket;
    private DataInputStream in;
    private PrintStream out;
    private ArrayList<String> responceData;
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
            mySocket = new Socket(IP_ADDRESS, PORT);
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
            isConnected = false;
            thread.stop();
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
                while (isConnected && mySocket != null && !(mySocket.isClosed())) {
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
        responceData = JsonHandler.deserializeArray(gsonResponce, listType);

        int action = Integer.valueOf(responceData.get(0));

        switch (action) {
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
            case Constants.SEND_INVITE:
                recieveInvit();
                break;
            case Constants.ACCEPTGAME:
                startGame();
                break;
            case Constants.SEND_MOVE:
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
            case Constants.SET_DATA_OF_PLAYER:
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
        boolean registerStatus = Boolean.valueOf(responceData.get(1));

        if (registerStatus) {
            Parent loginScreen = new LoginView();
            Util.displayScreen(loginScreen);
        } else {
            // Maybe Throw
            Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Register Error", "SomeThing Wrong Happen. Check For The Network.");
            });
        }
    }

    private void login() {
        int playerId = Integer.valueOf(responceData.get(1));
        if (playerId >= 0) {
            Parent lobbyScreen = new LobbyView(playerId);

            Util.displayScreen(lobbyScreen);
            PlayerStorage.saveUserId(playerId);
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
        Type playersType = new TypeToken<ArrayList<Player>>() {}.getType();
        ArrayList<Player> getAvailablePlayers = JsonHandler.deserializeArray(responceData.get(1), playersType);
        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;
        lobbyScreen.displayAvailablePlayers(getAvailablePlayers);
    }

    private void request() {
        int senderId = Integer.valueOf(responceData.get(1));
        String sendername = responceData.get(2);
        int senderScore = Integer.valueOf(responceData.get(3));

        if (sendername != null) {
            System.out.println("Request handled successfully");
        } else {
            System.out.println("Failed to handle the request");
        }
    }

    private void recieveBroadcastMessage() {
        String srcPlayerName = responceData.get(1);
        String message = responceData.get(2);
        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;
        lobbyScreen.displayMessage(srcPlayerName, message);
    }

    private void recieveMessage() {
        String message = responceData.get(1);
        String sourceplayerName = responceData.get(2);

        OnlineGame onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
        onlineGame.displayMessage(sourceplayerName, message);
    }

    private void recieveInvit() {
        Type gameType = new TypeToken<GameInfo>() {
        }.getType();
        GameInfo game = JsonHandler.deserializeArray(responceData.get(1), gameType);
        int type = Integer.valueOf(responceData.get(2));
        switch (type) {
            case 1:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "Invitation To play", 1);
                });
                break;
            case 2:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "New Game", 2);
                });
                break;
            default:
                Platform.runLater(() -> {
                    Util.invitationAlert(Alert.AlertType.CONFIRMATION, game, "Exit Game", 3);
                });
                break;
        }

    }

    private void startGame() {
        Type gameType = new TypeToken<GameInfo>() {
        }.getType();
        GameInfo info = JsonHandler.deserializeArray(responceData.get(1), gameType);

        boolean myTurn = Boolean.valueOf(responceData.get(2));
        int type = Integer.valueOf(responceData.get(3));
        OnlineGame onlineGame;
        switch (type) {
            case 1:
                onlineGame = new OnlineGame(info, myTurn);
                Util.displayScreen(onlineGame);
                break;
            case 2:
                onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
                Platform.runLater(() -> onlineGame.startGame());
                break;
            default:
                onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
                Platform.runLater(() -> onlineGame.exitGame());
                break;
        }
    }

    private void handleMove() {
        String playable = responceData.get(1);
        int x = Integer.valueOf(responceData.get(2));
        int y = Integer.valueOf(responceData.get(3));
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
        boolean isFriend = Boolean.valueOf(responceData.get(1));
        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;

        if (isFriend) {
            lobbyScreen.addFriend();
        }
    }

    private void removeFriend() {
        boolean isNotFriend = Boolean.valueOf(responceData.get(1));

        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;

        if (isNotFriend) {
            lobbyScreen.removeFriend();
        }
    }

    private void blockPlayer() {
        boolean isBlockedPlayer = Boolean.valueOf(responceData.get(1));

        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;

        if (isBlockedPlayer) {
            lobbyScreen.blockPlayer();
        }
    }

    private void unBlockPlayer() {
        boolean isUnBlocked = Boolean.valueOf(responceData.get(1));

        LobbyView lobbyScreen = (LobbyView) ClientApp.curDisplayedScreen;

        if (isUnBlocked) {
            lobbyScreen.unBlockPlayer();
        }
    }
}
