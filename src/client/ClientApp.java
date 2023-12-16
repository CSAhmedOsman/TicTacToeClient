/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.GameBoard;

/**
 *
 * @author w
 */
public class ClientApp extends Application {

    public static Stage stage;
    @Override
    public void start(Stage s) throws Exception {
        stage = s;
        Parent root = new GameBoard();
        stage.initStyle(StageStyle.UNDECORATED); //Hide bar of the stage
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
