/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import client.ClientApp;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.util.Duration;

/**
 *
 * @author w
 */
public class Util {

    private static double xOffset;
    private static double yOffset;

    public static void showDialog(Alert.AlertType type, String title, String content) {
        Platform.runLater(() -> {
            Alert a = new Alert(type);
            a.setTitle(title);
            a.setHeaderText(title);
            a.setResizable(true);
            a.setContentText(content);
            a.showAndWait();
        });
    }

    public static void displayScreen(Parent root) {

        Scene scene = new Scene(root);
        Platform.runLater(() -> {
            ClientApp.stage.setScene(scene);
            ClientApp.stage.show();
            Animation.setAnimatedRootIn(root);
        });
        
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            ClientApp.stage.setX(event.getScreenX() - xOffset);
            ClientApp.stage.setY(event.getScreenY() - yOffset);
        });

    }
}
