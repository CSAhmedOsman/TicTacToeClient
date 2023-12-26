/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import utils.PlayerStorage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import ui.LobbyScreenUI;
import ui.LoginScreenUI;
import ui.SplashScreenUI;
import utils.Util;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

    public static Stage stage;
    public static Pane currentScreen;

    @Override
    public void start(Stage stage) throws Exception {
        
        ClientApp.stage = stage;
        ClientApp.stage.initStyle(StageStyle.UNDECORATED);
        ClientApp.stage.setOnCloseRequest((WindowEvent event) -> {
            Client.getClient().closeConnection();
        });
        
        int savedUserId = PlayerStorage.loadUserId();

        if (savedUserId == -1) {
            Parent login = new LoginScreenUI();
            Util.displayScreen(login);
        } else {
            Parent lobby = new LobbyScreenUI((int) savedUserId);
            Util.displayScreen(lobby);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
