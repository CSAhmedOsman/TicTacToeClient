/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import data.Player;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.LobbyScreenUI;
import ui.SplashScreenUI;
import utils.Util;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

    public static Stage stage;
    public static Pane currentScreen;
    public static Client client;

    @Override
    public void start(Stage stage) throws Exception {
        ClientApp.stage = stage;
      
        Parent splashScreen = new SplashScreenUI();

        //Hide top bar of the stage
        stage.initStyle(StageStyle.UNDECORATED);

        Util.displayScreen(splashScreen);
        ClientApp.client = new Client();
        client.connect();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
