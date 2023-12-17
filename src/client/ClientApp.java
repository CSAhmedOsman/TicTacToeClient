/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.SelectPlayMode;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
