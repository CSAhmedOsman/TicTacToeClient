package ui;

import client.Client;
import client.ClientApp;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Animation;
import utils.Util;

public class HomeScreenUI extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Circle circle;
    protected final Button btnLogin;
    protected final DropShadow dropShadow0;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle btnLogin0;
    protected final Circle circle0;
    protected final Button btnSignUp;
    protected final DropShadow dropShadow1;
    protected final Button btnOffLine;
    protected final DropShadow dropShadow2;
    protected final Button btnBack;
    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button btnClose;
    protected final DropShadow dropShadow3;
    protected final Button btnMinimize;
    protected final DropShadow dropShadow4;

    public HomeScreenUI() {

        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        circle = new Circle();
        btnLogin = new Button();
        dropShadow0 = new DropShadow();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        btnLogin0 = new Rectangle();
        circle0 = new Circle();
        btnSignUp = new Button();
        dropShadow1 = new DropShadow();
        btnOffLine = new Button();
        dropShadow2 = new DropShadow();
        btnBack = new Button();
        pane = new Pane();
        imageView = new ImageView();
        btnClose = new Button();
        dropShadow3 = new DropShadow();
        btnMinimize = new Button();
        dropShadow4 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#ffbdbd"));
        rectangle.setHeight(607.0);
        rectangle.setLayoutX(-8.0);
        rectangle.setLayoutY(-3.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(708.0);

        label.setLayoutX(164.0);
        label.setLayoutY(73.0);
        label.setText("Tic-Tac-Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 96.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.98);
        label.setEffect(dropShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(48.0);
        circle.setLayoutY(72.0);
        circle.setOpacity(0.2);
        circle.setRadius(111.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        btnLogin.setLayoutX(206.0);
        btnLogin.setLayoutY(208.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(82.0);
        btnLogin.setPrefWidth(305.0);
        btnLogin.setStyle("-fx-background-radius: 100; -fx-background-color: #BC5FEA; -fx-font: Ferdoka One;");
        btnLogin.setText("Login");
        btnLogin.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnLogin.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnLogin.setCursor(Cursor.HAND);

        dropShadow0.setHeight(35.83);
        dropShadow0.setRadius(17.415);
        dropShadow0.setWidth(35.83);
        btnLogin.setEffect(dropShadow0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle0.setHeight(188.0);
        rectangle0.setLayoutX(66.0);
        rectangle0.setLayoutY(492.0);
        rectangle0.setOpacity(0.2);
        rectangle0.setRotate(-35.5);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(29.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle1.setHeight(188.0);
        rectangle1.setLayoutX(66.0);
        rectangle1.setLayoutY(492.0);
        rectangle1.setOpacity(0.2);
        rectangle1.setRotate(-126.9);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(29.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle2.setHeight(188.0);
        rectangle2.setLayoutX(626.0);
        rectangle2.setLayoutY(169.0);
        rectangle2.setOpacity(0.2);
        rectangle2.setRotate(-50.2);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(29.0);

        btnLogin0.setArcHeight(5.0);
        btnLogin0.setArcWidth(5.0);
        btnLogin0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        btnLogin0.setHeight(188.0);
        btnLogin0.setLayoutX(626.0);
        btnLogin0.setLayoutY(169.0);
        btnLogin0.setOpacity(0.2);
        btnLogin0.setRotate(-138.0);
        btnLogin0.setStroke(javafx.scene.paint.Color.BLACK);
        btnLogin0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        btnLogin0.setWidth(29.0);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(662.0);
        circle0.setLayoutY(548.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(71.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        btnSignUp.setLayoutX(206.0);
        btnSignUp.setLayoutY(310.0);
        btnSignUp.setMnemonicParsing(false);
        btnSignUp.setPrefHeight(82.0);
        btnSignUp.setPrefWidth(305.0);
        btnSignUp.setStyle("-fx-background-radius: 100; -fx-background-color: #EAD3D7;");
        btnSignUp.setText("Sign UP");
        btnSignUp.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnSignUp.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnSignUp.setCursor(Cursor.HAND);

        dropShadow1.setHeight(35.83);
        dropShadow1.setRadius(17.415);
        dropShadow1.setWidth(35.83);
        btnSignUp.setEffect(dropShadow1);

        btnOffLine.setLayoutX(206.0);
        btnOffLine.setLayoutY(419.0);
        btnOffLine.setMnemonicParsing(false);
        btnOffLine.setPrefHeight(82.0);
        btnOffLine.setPrefWidth(305.0);
        btnOffLine.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine.setText("Play Offline");
        btnOffLine.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnOffLine.setCursor(Cursor.HAND);

        dropShadow2.setHeight(35.83);
        dropShadow2.setRadius(17.415);
        dropShadow2.setWidth(35.83);
        btnOffLine.setEffect(dropShadow2);

        btnBack.setLayoutX(28.0);
        btnBack.setLayoutY(50.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(45.0);
        btnBack.setPrefWidth(51.0);
        btnBack.setStyle("-fx-background-color: #ffbdbd;");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#da0a0a"));

        pane.setPrefHeight(45.0);
        pane.setPrefWidth(51.0);

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(40.0);
        imageView.setLayoutX(1.0);
        imageView.setLayoutY(-4.0);
        imageView.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));
        btnBack.setGraphic(pane);

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

        dropShadow3.setColor(Color.valueOf("#fff7f7"));
        dropShadow3.setSpread(0.69);
        btnClose.setEffect(dropShadow3);

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

        dropShadow4.setColor(Color.valueOf("#fff7f7"));
        dropShadow4.setSpread(0.69);
        btnMinimize.setEffect(dropShadow4);

        ObservableList<Node> nodes = getChildren();

        nodes.add(rectangle);
        nodes.add(label);
        nodes.add(circle);
        nodes.add(btnLogin);
        nodes.add(rectangle0);
        nodes.add(rectangle1);
        nodes.add(rectangle2);
        nodes.add(btnLogin0);
        nodes.add(circle0);
        nodes.add(btnSignUp);
        nodes.add(btnOffLine);
        pane.getChildren().add(imageView);
        nodes.add(btnBack);
        nodes.add(btnClose);
        nodes.add(btnMinimize);

        //______________My Work_______________
        setListeners(ClientApp.stage);

        Animation.setButtonHoverFunctionality(btnLogin);
        Animation.setButtonHoverFunctionality(btnSignUp);
        Animation.setButtonHoverFunctionality(btnOffLine);

        animateIn();
    }

    private void setListeners(Stage stage) {

        btnLogin.setOnAction((ActionEvent event) -> {
            Parent loginScreen = new LoginScreenUI();
            Util.displayScreen(loginScreen);
        });

        btnSignUp.setOnAction((ActionEvent event) -> {
            Parent registerScreen = new RegisterScreenUI();
            animateOut(registerScreen);
        });

        btnOffLine.setOnAction((ActionEvent event) -> {
            Parent modesScreen = new ModesScreenUI();
            animateOut(modesScreen);
        });

        btnBack.setOnAction((ActionEvent event) -> {
            Parent splashScreen = new SplashScreenUI();
            animateOut(splashScreen);
        });

        btnClose.setOnAction((ActionEvent event) -> {
            stage.close();
        });

        btnMinimize.setOnAction((ActionEvent event) -> {
            stage.setIconified(true);
        });
    }

    private void animateIn() {
        Animation.setAnimatedNodeIn(btnLogin);
        Animation.setAnimatedNodeIn(btnClose);
        Animation.setAnimatedNodeIn(btnMinimize);
        Animation.setAnimatedNodeIn(btnSignUp);
        Animation.setAnimatedNodeIn(btnOffLine);
    }

    private void animateOut(Parent destination) {

        Animation.setAnimatedNodeOut(btnLogin);
        Animation.setAnimatedNodeOut(btnClose);
        Animation.setAnimatedNodeOut(btnMinimize);
        Animation.setAnimatedNodeOut(btnSignUp);
        Animation.setAnimatedNodeOut(btnOffLine);

        Animation.setAnimatedRootOut(this, destination);
    }
}
