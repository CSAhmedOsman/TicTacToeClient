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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.util.Duration;

public class Animation {

    private static final Duration ANIMATION_DURATION = Duration.seconds(1);

    public static void setAnimatedRootIn(Parent root) {

        // Set up TranslateTransition for sliding in
        TranslateTransition translateIn = new TranslateTransition(ANIMATION_DURATION, root);
        translateIn.setFromX(ClientApp.stage.getWidth());
        translateIn.setToX(0);

        // Set up FadeTransition for fading in
        FadeTransition fadeIn = new FadeTransition(ANIMATION_DURATION, root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Play the animation for appearing
        translateIn.play();
        fadeIn.play();
        ClientApp.stage.show();
    }

    public static void setAnimatedRootOut(Parent root) {
        // Set up TranslateTransition for sliding out
        TranslateTransition translateOut = new TranslateTransition(ANIMATION_DURATION, root);
        translateOut.setFromX(0);
        translateOut.setToX(ClientApp.stage.getWidth());

        // Set up FadeTransition for fading out
        FadeTransition fadeOut = new FadeTransition(ANIMATION_DURATION, root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        // Play the animation for disappearing after a delay (you can adjust the delay as needed)
        translateOut.play();
        fadeOut.play();
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
}