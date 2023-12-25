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
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author w
 */
public class Util {

    private static double xOffset;
    private static double yOffset;

    public static void showAlertDialog(Alert.AlertType alertType, String title, String message) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        // Customize the appearance of the dialog
        VBox dialogPane = new VBox();
        dialogPane.setBackground(new Background(new BackgroundFill(Color.web("#ffbdbd"), new CornerRadii(10), Insets.EMPTY)));
        dialogPane.setStyle("-fx-text-fill: white;");
        dialogPane.setSpacing(10);
        dialogPane.setPadding(new Insets(10));

        // Add content to the dialog
        javafx.scene.control.Label titleLabel = new javafx.scene.control.Label(title);
        titleLabel.setStyle("-fx-font-weight: bold;");
        
        javafx.scene.control.Label messageLabel = new javafx.scene.control.Label(message);
        Button okButton = new Button("OK");
        okButton.setOnAction(event -> dismissDialog(dialogStage));

        dialogPane.getChildren().addAll(
                titleLabel,
                messageLabel,
                okButton
        );

        // Make the dialog draggable
        dialogPane.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        dialogPane.setOnMouseDragged((MouseEvent event) -> {
            dialogStage.setX(event.getScreenX() - xOffset);
            dialogStage.setY(event.getScreenY() - yOffset);
        });

        dialogPane.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        dialogPane.setOnMouseDragged((MouseEvent event) -> {
            dialogStage.setX(event.getScreenX() - xOffset);
            dialogStage.setY(event.getScreenY() - yOffset);
        });
        
        // Apply fade-in animation
        dialogPane.setOpacity(0.0);
        dialogStage.setWidth(300);
        dialogStage.setHeight(150);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), dialogPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        fadeIn.play();
        dialogStage.setScene(new Scene(dialogPane));
        dialogStage.initStyle(StageStyle.UNDECORATED); // Hide top bar
        dialogStage.showAndWait();
    }

    private static void dismissDialog(Stage dialogStage) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), dialogStage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(event -> dialogStage.close());
        fadeOut.play();
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
