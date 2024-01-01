package ui;

import client.ClientApp;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Animation;
import utils.Util;

public class SplashScreenUI extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Circle circle;
    protected final Button btnNext;
    protected final DropShadow dropShadow0;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle rectangle3;
    protected final Circle circle0;
    protected final ImageView imageView;
    protected final DropShadow dropShadow1;
    protected final Button btnClose;
    protected final DropShadow dropShadow2;
    protected final Button btnMinimize;
    protected final DropShadow dropShadow3;

    public SplashScreenUI() {

        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        circle = new Circle();
        btnNext = new Button();
        dropShadow0 = new DropShadow();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        rectangle3 = new Rectangle();
        circle0 = new Circle();
        imageView = new ImageView();
        dropShadow1 = new DropShadow();
        btnClose = new Button();
        dropShadow2 = new DropShadow();
        btnMinimize = new Button();
        dropShadow3 = new DropShadow();

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
        rectangle.setLayoutX(-3.0);
        rectangle.setLayoutY(-6.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(708.0);

        label.setLayoutX(159.0);
        label.setLayoutY(40.0);
        label.setText("Tic-Tac-Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 96.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(1.0);
        label.setEffect(dropShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(48.0);
        circle.setLayoutY(72.0);
        circle.setOpacity(0.2);
        circle.setRadius(111.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        btnNext.setLayoutX(227.0);
        btnNext.setLayoutY(471.0);
        btnNext.setMnemonicParsing(false);
        btnNext.setPrefHeight(94.0);
        btnNext.setPrefWidth(249.0);
        btnNext.setStyle("-fx-background-radius: 100; -fx-background-color: #FD6D84;");
        btnNext.setText("Start");
        btnNext.setTextFill(javafx.scene.paint.Color.WHITE);
        btnNext.setFont(new Font("Franklin Gothic Demi Cond", 43.0));
        btnNext.setCursor(Cursor.HAND);

        dropShadow0.setColor(Color.valueOf("#fff7f7"));
        dropShadow0.setSpread(0.69);
        btnNext.setEffect(dropShadow0);

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

        rectangle3.setArcHeight(5.0);
        rectangle3.setArcWidth(5.0);
        rectangle3.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle3.setHeight(188.0);
        rectangle3.setLayoutX(626.0);
        rectangle3.setLayoutY(169.0);
        rectangle3.setOpacity(0.2);
        rectangle3.setRotate(-138.0);
        rectangle3.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle3.setWidth(29.0);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(662.0);
        circle0.setLayoutY(548.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(71.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        imageView.setFitHeight(267.0);
        imageView.setFitWidth(274.0);
        imageView.setLayoutX(214.0);
        imageView.setLayoutY(167.0);
        imageView.setImage(new Image(getClass().getResource("images/XO.png").toExternalForm()));

        dropShadow1.setSpread(0.16);
        imageView.setEffect(dropShadow1);

        btnClose.setLayoutX(636.0);
        btnClose.setLayoutY(20.0);
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

        dropShadow2.setColor(Color.valueOf("#fff7f7"));
        dropShadow2.setSpread(0.69);
        btnClose.setEffect(dropShadow2);

        btnMinimize.setLayoutX(567.0);
        btnMinimize.setLayoutY(20.0);
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

        //dropShadow3.setColor(javafx.scene.paint.Color.#fff7f7);
        dropShadow3.setColor(Color.valueOf("#fff7f7"));
        dropShadow3.setSpread(0.69);
        btnMinimize.setEffect(dropShadow3);

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(circle);
        getChildren().add(btnNext);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(rectangle3);
        getChildren().add(circle0);
        getChildren().add(imageView);
        getChildren().add(btnClose);
        getChildren().add(btnMinimize);

        //_____________________My Work_______________________
        setListeners(ClientApp.stage);
        Animation.setButtonHoverFunctionality(btnNext);
        ClientApp.curDisplayedScreen = this;
    }

    private void setListeners(Stage stage) {
        btnNext.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            Parent modeeScreen = new ModesScreenUI();
            Util.displayScreen(modeeScreen);
        });

        btnClose.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            stage.close();
        });

        btnMinimize.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            stage.setIconified(true);
        });
    }
}
