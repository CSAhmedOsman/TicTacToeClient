/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
<<<<<<< HEAD
import ui.SplashScreenUI;
import utils.Util;
=======
import ui.SelectPlayMode;
>>>>>>> MergedGameBoard

/**
 *
 * @author w
 */
public class ClientApp extends Application {
<<<<<<< HEAD
    
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        ClientApp.stage = stage;
        Parent splashScreen = new SplashScreenUI();

        //Hide top bar of the stage
        stage.initStyle(StageStyle.UNDECORATED);
        
        Util.displayScreen(splashScreen);

=======

    private double xOffset;
    private double yOffset;
    public static Stage stage;

    @Override
    public void start(Stage s) throws Exception {
        stage = s;

        stage.initStyle(StageStyle.UNDECORATED); //Hide bar of the stage
        Parent root = new SelectPlayMode();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
>>>>>>> MergedGameBoard
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
