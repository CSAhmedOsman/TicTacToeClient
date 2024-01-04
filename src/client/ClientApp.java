/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import utils.PlayerStorage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.SplashScreenUI;
import utils.Util;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

    public static Stage stage;
    public static Pane curDisplayedScreen;
    public static SoundManager soundManager;
    public static int playerId;

    @Override
    public void start(Stage stage) throws Exception {

        playerId = -1;
        soundManager = SoundManager.getInstance();
        soundManager.playBackgroundMusic();
        ClientApp.stage = stage;

        Parent splashScreen = new SplashScreenUI();
        //Hide top bar of the stage
        stage.initStyle(StageStyle.UNDECORATED);

        Util.displayScreen(splashScreen);
/*
        int savedUserId = PlayerStorage.loadUserId();
        playerId = savedUserId;
*/
    }
    
    public static void close() {
        Client.getClient().closeConnection();
        Platform.exit();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
