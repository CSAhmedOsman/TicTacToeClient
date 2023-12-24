/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Player;
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
import ui.LoginScreenUI;
import ui.ModesScreenUI;
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

    public void connect() {
        try {
            mySocket = new Socket(Constants.IP_ADDRESS, Constants.PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
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

    public void sendRequest(String gson) {
        out.println(gson);
    }

    private void startListening() {
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
            case 10:
                //TODO updateScore();
                break;
            case 11:
                // TODO sendMessage();
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
                Util.showAlertDialog(Alert.AlertType.ERROR, "Login Error", userId+" ");
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
        
        LobbyScreenUI.setPlayers(getAvailablePlayers);
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
}
