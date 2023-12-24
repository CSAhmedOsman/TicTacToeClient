package ui;

import client.Client;
import client.ClientApp;
import data.Player;
import com.google.gson.Gson;
import exception.NotConnectedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Constants;
import utils.PasswordEncryptor;
import utils.Util;
import utils.Validating;

public class RegisterScreenUI extends Pane {

    protected final Ellipse ellipse;
    protected final Ellipse ellipse0;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Text text;
    protected final TextField tfEmail;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Ellipse ellipse1;
    protected final PasswordField pfPassword;
    protected final Button btnRegister;
    protected final TextField tfUsername;
    protected final PasswordField pfConfirmPassword;
    protected final Button btnClose;
    protected final DropShadow dropShadow;
    protected final Button btnMinimize;
    protected final DropShadow dropShadow0;
    
    // Button Click Behaviour
    int initWidth= 230;
    int initHeight= 60;
    double sizeIncreasePercentage = 20;
    
    // UI Servese Repo DB
    public RegisterScreenUI() {

        ellipse = new Ellipse();
        ellipse0 = new Ellipse();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        text = new Text();
        tfEmail = new TextField();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        ellipse1 = new Ellipse();
        pfPassword = new PasswordField();
        btnRegister = new Button();
        tfUsername = new TextField();
        pfConfirmPassword = new PasswordField();
        btnClose = new Button();
        dropShadow = new DropShadow();
        btnMinimize = new Button();
        dropShadow0 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: F1AAAA;");

        ellipse.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        ellipse.setLayoutX(673.0);
        ellipse.setLayoutY(48.0);
        ellipse.setOpacity(0.25);
        ellipse.setRadiusX(100.0);
        ellipse.setRadiusY(80.0);
        ellipse.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        ellipse.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        ellipse.setStyle("-fx-blend-mode: F1AAAA;");

        ellipse0.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        ellipse0.setLayoutX(-22.0);
        ellipse0.setLayoutY(535.0);
        ellipse0.setOpacity(0.25);
        ellipse0.setRadiusX(100.0);
        ellipse0.setRadiusY(80.0);
        ellipse0.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        ellipse0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle.setHeight(200.0);
        rectangle.setLayoutX(633.0);
        rectangle.setLayoutY(-61.0);
        rectangle.setOpacity(0.25);
        rectangle.setRotate(125.5);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(20.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle0.setHeight(200.0);
        rectangle0.setLayoutX(643.0);
        rectangle0.setLayoutY(-61.0);
        rectangle0.setOpacity(0.24);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(20.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#66188d"));
        text.setLayoutX(49.0);
        text.setLayoutY(100.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Hello! Register to get Started");
        text.setFont(new Font("Arial Rounded MT Bold", 41.0));

        tfEmail.setLayoutX(191.0);
        tfEmail.setLayoutY(202.0);
        tfEmail.setPrefHeight(42.0);
        tfEmail.setPrefWidth(296.0);
        tfEmail.setPromptText("Email");
        tfEmail.setStyle("-fx-background-radius: 50;");
        tfEmail.setFont(new Font(23.0));

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle1.setHeight(200.0);
        rectangle1.setLayoutX(26.0);
        rectangle1.setLayoutY(441.0);
        rectangle1.setOpacity(0.24);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(20.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle2.setHeight(200.0);
        rectangle2.setLayoutX(16.0);
        rectangle2.setLayoutY(435.0);
        rectangle2.setOpacity(0.25);
        rectangle2.setRotate(45.0);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(20.0);

        ellipse1.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        ellipse1.setLayoutX(65.0);
        ellipse1.setLayoutY(600.0);
        ellipse1.setOpacity(0.25);
        ellipse1.setRadiusX(100.0);
        ellipse1.setRadiusY(80.0);
        ellipse1.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        ellipse1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        ellipse1.setStyle("-fx-blend-mode: CDC9C9;");

        pfPassword.setLayoutX(191.0);
        pfPassword.setLayoutY(273.0);
        pfPassword.setPrefHeight(42.0);
        pfPassword.setPrefWidth(296.0);
        pfPassword.setPromptText("Password");
        pfPassword.setStyle("-fx-background-radius: 50;");
        pfPassword.setFont(new Font(23.0));

        btnRegister.setLayoutX(201.0);
        btnRegister.setLayoutY(441.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setOpacity(0.72);
        btnRegister.setPrefHeight(initHeight);
        btnRegister.setPrefWidth(initWidth);
        btnRegister.setStyle("-fx-background-radius: 50;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnRegister.setFont(new Font("Arial Rounded MT Bold", 31.0));

        tfUsername.setLayoutX(191.0);
        tfUsername.setLayoutY(128.0);
        tfUsername.setPrefHeight(42.0);
        tfUsername.setPrefWidth(296.0);
        tfUsername.setPromptText("Username");
        tfUsername.setStyle("-fx-background-radius: 50;");
        tfUsername.setFont(new Font(23.0));

        pfConfirmPassword.setLayoutX(191.0);
        pfConfirmPassword.setLayoutY(354.0);
        pfConfirmPassword.setPrefHeight(42.0);
        pfConfirmPassword.setPrefWidth(296.0);
        pfConfirmPassword.setPromptText("Confirm Password");
        pfConfirmPassword.setStyle("-fx-background-radius: 50;");
        pfConfirmPassword.setFont(new Font(23.0));
        pfConfirmPassword.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.V && event.isShortcutDown()) {
                event.consume();
            }
        });

        btnClose.setLayoutX(616.0);
        btnClose.setLayoutY(23.0);
        btnClose.setMinHeight(USE_PREF_SIZE);
        btnClose.setMinWidth(50.0);
        btnClose.setMnemonicParsing(false);
        btnClose.setPrefHeight(40.0);
        btnClose.setPrefWidth(20.0);
        btnClose.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnClose.setText("X");
        btnClose.setTextFill(javafx.scene.paint.Color.WHITE);
        btnClose.setFont(new Font("Franklin Gothic Demi Cond", 43.0));
        btnClose.setCursor(Cursor.HAND);

        btnClose.setEffect(dropShadow);

        btnMinimize.setLayoutX(547.0);
        btnMinimize.setLayoutY(23.0);
        btnMinimize.setMinHeight(USE_PREF_SIZE);
        btnMinimize.setMinWidth(50.0);
        btnMinimize.setMnemonicParsing(false);
        btnMinimize.setPrefHeight(40.0);
        btnMinimize.setPrefWidth(20.0);
        btnMinimize.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnMinimize.setText("-");
        btnMinimize.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnMinimize.setTextFill(javafx.scene.paint.Color.WHITE);
        btnMinimize.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btnMinimize.setFont(new Font("Franklin Gothic Demi Cond", 43.0));
        btnMinimize.setCursor(Cursor.HAND);

        btnMinimize.setEffect(dropShadow0);

        getChildren().add(ellipse);
        getChildren().add(ellipse0);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(text);
        getChildren().add(tfUsername);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(ellipse1);
        getChildren().add(tfEmail);
        getChildren().add(btnRegister);
        getChildren().add(pfPassword);
        getChildren().add(pfConfirmPassword);
        getChildren().add(btnClose);
        getChildren().add(btnMinimize);
        
        setListeners(ClientApp.stage);
        
        ClientApp.currentScreen= this;
    }
    
    private void setListeners(Stage stage) {
        
        btnRegister.setOnAction((ActionEvent event) -> {
            register();
        });
        
        btnClose.setOnAction((ActionEvent event) -> {
            stage.close();
        });
        
        btnMinimize.setOnAction((ActionEvent event) -> {
            stage.setIconified(true);
        });
    }

    private void register() {
        
        Player player= makeNewPlayer();
        
        if(player== null)
            return;
        
        player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));
        
        Gson gson= new Gson();
        ArrayList jsonArr= new ArrayList();
        jsonArr.add(Constants.REGISTER);
        jsonArr.add(player);
        
        String gsonRequest = gson.toJson(jsonArr);
        
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed");
        }
    }
    
    private Player makeNewPlayer() {
        String username= tfUsername.getText();
        String email= tfEmail.getText();
        String password= pfPassword.getText();
        String confirmPassword= pfConfirmPassword.getText();
        
        Player player= null;
        
        if(!Validating.validateRegister(username, email, password, confirmPassword)) 
            return player;
        
        player = new Player(username, email, password);
        
        return player;
    }
}