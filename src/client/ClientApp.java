/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import data.Player;
import java.io.File;
import java.util.ArrayList;
import utils.PlayerStorage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import ui.HomeScreenUI;
import ui.SplashScreenUI;
import ui.lobby.LobbyView;
import ui.login.LoginView;
import utils.Util;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

    public static Stage stage;
    public static Pane curDisplayedScreen;
    public SoundManager soundManager;

    @Override
    public void start(Stage stage) throws Exception {

        ClientApp.stage = stage;
        ClientApp.stage.initStyle(StageStyle.UNDECORATED);
        ClientApp.stage.setOnCloseRequest((WindowEvent event) -> {
            Client.getClient().closeConnection();
        });

        //For Testing
        PlayerStorage.saveUserId(-1);

        soundManager = new SoundManager();
        soundManager.playSound();

        Parent splashScreen = new SplashScreenUI();
        Util.displayScreen(splashScreen);

        int savedUserId = PlayerStorage.loadUserId();
        if (savedUserId == -1) {
            Parent home = new HomeScreenUI();
            Util.displayScreen(home);
        } else {
            Parent lobby = new LobbyView((int) savedUserId);
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
