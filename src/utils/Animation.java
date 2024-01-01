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
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Animation {

    private static final Duration ANIMATION_DURATION = Duration.seconds(1);

    public static void setAnimatedRootIn(Parent root) {

        // Set up FadeTransition for fading in
        FadeTransition fadeIn = new FadeTransition(ANIMATION_DURATION, root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Play the animation for appearing
        fadeIn.play();
        ClientApp.stage.show();
    }

    public static void setAnimatedRootOut(Parent source, Parent destination) {

        // Set up FadeTransition for fading out
        FadeTransition fadeOut = new FadeTransition(ANIMATION_DURATION, source);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        // Play the animation for disappearing after a delay (you can adjust the delay as needed)
        fadeOut.play();
        fadeOut.setOnFinished((ActionEvent event) -> {
            Util.displayScreen(destination);
        });
    }

    public static void setAnimatedNodeIn(Node node) {
        // Set up TranslateTransition for sliding in
        TranslateTransition translateIn = new TranslateTransition(ANIMATION_DURATION, node);
        translateIn.setFromX(ClientApp.stage.getWidth());
        translateIn.setToX(0);

        // Set up FadeTransition for fading in
        FadeTransition fadeIn = new FadeTransition(ANIMATION_DURATION, node);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Play the animation for appearing
        translateIn.play();
        fadeIn.play();
    }

    public static void setAnimatedNodeOut(Node node) {
        // Set up TranslateTransition for sliding out
        TranslateTransition translateOut = new TranslateTransition(ANIMATION_DURATION, node);
        translateOut.setFromX(0);
        translateOut.setToX(ClientApp.stage.getWidth());

        // Set up FadeTransition for fading out
        FadeTransition fadeOut = new FadeTransition(ANIMATION_DURATION, node);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        // Play the animation for disappearing after a delay
        translateOut.play();
        fadeOut.play();
    }

    private void setDefaultButtonStyle(Button button) {
        button.setStyle("-fx-background-color: #43115b;");
    }

    public static void setButtonHoverFunctionality(Button button) {
        // Set initial size
        double initialWidth = 270;
        double initialHeight = 40;
        button.setPrefSize(initialWidth, initialHeight);

        // Create fade-in and fade-out transitions
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), button);
        fadeIn.setToValue(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), button);
        fadeOut.setToValue(0.5);

        button.setOnMouseEntered(e -> {
            // Increase the size based on the current size
            double scaleFactor = 1.15;
            double newWidth = initialWidth * scaleFactor;
            double newHeight = initialHeight * scaleFactor;

            // Calculate the new translation properties to keep the center fixed
            double translateX = button.getTranslateX() - (newWidth - initialWidth) / 2;
            double translateY = button.getTranslateY() - (newHeight - initialHeight) / 2;

            button.setPrefSize(newWidth, newHeight);
            button.setTranslateX(translateX);
            button.setTranslateY(translateY);

            // Play fade-in animation
            fadeIn.play();
        });

        button.setOnMouseExited(e -> {
            // Restore the original size and color when the mouse exits
            button.setPrefSize(initialWidth, initialHeight);
            button.setTranslateX(0); // Reset translation
            button.setTranslateY(0);

            // Play fade-out animation
            fadeOut.play();
        });
    }
}
