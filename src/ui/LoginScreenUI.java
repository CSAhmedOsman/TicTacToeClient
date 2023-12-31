package ui;

import client.Client;
import client.ClientApp;
import data.Player;
import com.google.gson.Gson;
import exception.NotConnectedException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.*;

public class LoginScreenUI extends Pane {

    protected final Ellipse ellipse;
    protected final Ellipse ellipse0;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final TextField tfEmail;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Ellipse ellipse1;
    protected final PasswordField pfPassword;
    protected final Button btnLogin;
    protected final Button btnClose;
    protected final DropShadow dropShadow;
    protected final Button btnMinimize;
    protected final DropShadow dropShadow0;
    protected final Button btnBack;
    protected final ImageView imageView;
    protected final Pane pane;

    public LoginScreenUI() {

        ellipse = new Ellipse();
        ellipse0 = new Ellipse();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        tfEmail = new TextField();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        ellipse1 = new Ellipse();
        pfPassword = new PasswordField();
        btnLogin = new Button();
        btnClose = new Button();
        dropShadow = new DropShadow();
        btnMinimize = new Button();
        dropShadow0 = new DropShadow();
        btnBack = new Button();
        imageView = new ImageView();
        pane = new Pane();

        pane.setPrefHeight(45.0);
        pane.setPrefWidth(51.0);

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

        text.setFill(javafx.scene.paint.Color.valueOf("#43115b"));
        text.setLayoutX(119.0);
        text.setLayoutY(112.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic");
        text.setFont(new Font("Arial Rounded MT Bold", 76.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#f5f5f5"));
        text0.setLayoutX(233.0);
        text0.setLayoutY(112.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("-T");
        text0.setFont(new Font("Arial Rounded MT Bold", 76.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#772ca6"));
        text1.setLayoutX(297.0);
        text1.setLayoutY(112.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("ac-T");
        text1.setFont(new Font("Arial Rounded MT Bold", 76.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#f2edf5"));
        text2.setLayoutX(450.0);
        text2.setLayoutY(112.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("oe");
        text2.setFont(new Font("Arial Rounded MT Bold", 76.0));

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

        btnLogin.setLayoutX(200.0);
        btnLogin.setLayoutY(368.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setOpacity(0.72);
        btnLogin.setStyle("-fx-background-radius: 50;");
        btnLogin.setText("Login");
        btnLogin.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnLogin.setFont(new Font("Arial Rounded MT Bold", 47.0));

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

        btnBack.setLayoutX(14.0);
        btnBack.setLayoutY(12.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(45.0);
        btnBack.setPrefWidth(51.0);
        btnBack.setStyle("-fx-background-color: #ffbdbd;");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#da0a0a"));

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(40.0);
        imageView.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));
        btnBack.setGraphic(pane);

        getChildren().add(btnBack);
        getChildren().add(ellipse);
        getChildren().add(ellipse0);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(tfEmail);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(ellipse1);
        getChildren().add(pfPassword);
        getChildren().add(btnLogin);
        getChildren().add(btnClose);
        getChildren().add(btnMinimize);
        pane.getChildren().add(imageView);

        //______________My Work_______________
        setListeners();

        Animation.setButtonHoverFunctionality(btnLogin);

        Animation.setAnimatedNodeIn(btnLogin);
        Animation.setAnimatedNodeIn(btnClose);
        Animation.setAnimatedNodeIn(btnMinimize);

        ClientApp.curDisplayedScreen = this;
        tfEmail.setText("a@gmail.com");
        pfPassword.setText("Aa#123456");
    }

    private void setListeners() {
        btnBack.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            Parent root = new HomeScreenUI();
            Util.displayScreen(root);
        });
        btnLogin.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            Player player = getCurrentPlayer();
            if (player == null) {
                return;
            }
            player.setPassword(PasswordEncryptor.encryptPassword(player.getPassword()));
            Gson gson = new Gson();
            ArrayList jsonRequest = new ArrayList();
            jsonRequest.add(Constants.LOGIN);
            jsonRequest.add((String) gson.toJson(player));
            String gsonRequest = gson.toJson(jsonRequest);
            try {
                Client.getClient().sendRequest(gsonRequest);
            } catch (NotConnectedException ex) {
                Util.showAlertDialog(Alert.AlertType.ERROR, "Server", "The Server is Closed\n" + ex.getMessage());
            }
        });

        btnClose.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            ClientApp.stage.close();
        });

        btnMinimize.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            ClientApp.stage.setIconified(true);
        });
    }

    private Player getCurrentPlayer() {
        String email = tfEmail.getText();
        String password = pfPassword.getText();

        Player player = null;

        if (!Validating.validateLogin(email, password)) {
            return player;
        }

        player = new Player(email, password);

        return player;
    }
}
