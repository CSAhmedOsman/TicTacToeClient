/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author w
 */
import client.ClientApp;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animation {

    private static final Duration ANIMATION_DURATION = Duration.seconds(1);

    public static void setAnimatedRootIn(Parent root) {

        TranslateTransition translateIn = new TranslateTransition(ANIMATION_DURATION, root);
        translateIn.setFromX(ClientApp.stage.getWidth());
        translateIn.setToX(0);

        FadeTransition fadeIn = new FadeTransition(ANIMATION_DURATION, root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        translateIn.play();
        fadeIn.play();
        ClientApp.stage.show();
    }

    public static void setAnimatedRootOut(Parent source, Parent destination) {
        TranslateTransition translateOut = new TranslateTransition(ANIMATION_DURATION, source);
        translateOut.setFromX(0);
        translateOut.setToX(ClientApp.stage.getWidth());

        FadeTransition fadeOut = new FadeTransition(ANIMATION_DURATION, source);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        translateOut.play();
        fadeOut.play();
        fadeOut.setOnFinished((ActionEvent event) -> {
            Util.displayScreen(destination);
        });
    }

    public static void setAnimatedNodeIn(Node node) {
        TranslateTransition translateIn = new TranslateTransition(ANIMATION_DURATION, node);
        translateIn.setFromX(ClientApp.stage.getWidth());
        translateIn.setToX(0);

        FadeTransition fadeIn = new FadeTransition(ANIMATION_DURATION, node);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        translateIn.play();
        fadeIn.play();
    }

    public static void setAnimatedNodeOut(Node node) {
        TranslateTransition translateOut = new TranslateTransition(ANIMATION_DURATION, node);
        translateOut.setFromX(0);
        translateOut.setToX(ClientApp.stage.getWidth());

        FadeTransition fadeOut = new FadeTransition(ANIMATION_DURATION, node);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        translateOut.play();
        fadeOut.play();
    }

    private void setDefaultButtonStyle(Button button) {
        button.setStyle("-fx-background-color: #43115b;");
    }

    
    public static void setButtonHoverFunctionality(Button button) {
        double initialWidth = 300;
        double initialHeight = 40;
        button.setPrefSize(initialWidth, initialHeight);
        
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), button);
        fadeIn.setToValue(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), button);
        fadeOut.setToValue(0.5);

        button.setOnMouseEntered(e -> {
            double scaleFactor = 1.15;
            double newWidth = initialWidth * scaleFactor;
            double newHeight = initialHeight * scaleFactor;

            double translateX = button.getTranslateX() - (newWidth - initialWidth) / 2;
            double translateY = button.getTranslateY() - (newHeight - initialHeight) / 2;

            button.setPrefSize(newWidth, newHeight);
            button.setTranslateX(translateX);
            button.setTranslateY(translateY);
            
            fadeIn.play();
        });

        button.setOnMouseExited(e -> {
            button.setPrefSize(initialWidth, initialHeight);
            button.setTranslateX(0); // Reset translation
            button.setTranslateY(0);
            
            fadeOut.play();
        });
    }
}