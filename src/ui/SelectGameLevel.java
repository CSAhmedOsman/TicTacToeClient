package ui;

import client.ClientApp;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import utils.Util;

public class SelectGameLevel extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Circle circle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Circle circle0;
    protected final Button btnLow;
    protected final DropShadow dropShadow0;
    protected final Button btnMiddle;
    protected final DropShadow dropShadow1;
    protected final Button btnHigh;
    protected final DropShadow dropShadow2;
    protected final Button btnBack;
    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button btnClose;
    protected final DropShadow dropShadow3;
    protected final Button btnMin;
    protected final DropShadow dropShadow4;
    protected final Label logoTic;
    protected final Label logoToe;
    protected final Label logoTac;

    public SelectGameLevel() {

        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        circle = new Circle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        circle0 = new Circle();
        btnLow = new Button();
        dropShadow0 = new DropShadow();
        btnMiddle = new Button();
        dropShadow1 = new DropShadow();
        btnHigh = new Button();
        dropShadow2 = new DropShadow();
        btnBack = new Button();
        pane = new Pane();
        imageView = new ImageView();
        btnClose = new Button();
        dropShadow3 = new DropShadow();
        btnMin = new Button();
        dropShadow4 = new DropShadow();
        logoTic = new Label();
        logoToe = new Label();
        logoTac = new Label();

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

        label.setLayoutX(131.0);
        label.setLayoutY(71.0);
        label.setText("Select Level ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 96.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.98);
        label.setEffect(dropShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(54.0);
        circle.setLayoutY(571.0);
        circle.setOpacity(0.2);
        circle.setRadius(111.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle0.setHeight(188.0);
        rectangle0.setLayoutX(626.0);
        rectangle0.setLayoutY(169.0);
        rectangle0.setOpacity(0.2);
        rectangle0.setRotate(-50.2);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(29.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle1.setHeight(188.0);
        rectangle1.setLayoutX(626.0);
        rectangle1.setLayoutY(169.0);
        rectangle1.setOpacity(0.2);
        rectangle1.setRotate(-138.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(29.0);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(651.0);
        circle0.setLayoutY(548.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(71.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        btnLow.setLayoutX(206.0);
        btnLow.setLayoutY(208.0);
        btnLow.setMnemonicParsing(false);
        btnLow.setPrefHeight(82.0);
        btnLow.setPrefWidth(305.0);
        btnLow.setStyle("-fx-background-radius: 100; -fx-background-color: #BC5FEA; -fx-font: Ferdoka One;");
        btnLow.setText("Low");
        btnLow.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnLow.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnLow.setCursor(Cursor.HAND);

        dropShadow0.setHeight(35.83);
        dropShadow0.setRadius(17.415);
        dropShadow0.setWidth(35.83);
        btnLow.setEffect(dropShadow0);

        btnMiddle.setLayoutX(206.0);
        btnMiddle.setLayoutY(310.0);
        btnMiddle.setMnemonicParsing(false);
        btnMiddle.setPrefHeight(82.0);
        btnMiddle.setPrefWidth(305.0);
        btnMiddle.setStyle("-fx-background-radius: 100; -fx-background-color: #EAD3D7;");
        btnMiddle.setText("Middle");
        btnMiddle.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnMiddle.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnMiddle.setCursor(Cursor.HAND);

        dropShadow1.setHeight(35.83);
        dropShadow1.setRadius(17.415);
        dropShadow1.setWidth(35.83);
        btnMiddle.setEffect(dropShadow1);

        btnHigh.setLayoutX(206.0);
        btnHigh.setLayoutY(419.0);
        btnHigh.setMnemonicParsing(false);
        btnHigh.setPrefHeight(82.0);
        btnHigh.setPrefWidth(305.0);
        btnHigh.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnHigh.setText("High");
        btnHigh.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnHigh.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnHigh.setCursor(Cursor.HAND);

        dropShadow2.setHeight(35.83);
        dropShadow2.setRadius(17.415);
        dropShadow2.setWidth(35.83);
        btnHigh.setEffect(dropShadow2);

        btnBack.setLayoutX(28.0);
        btnBack.setLayoutY(23.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(45.0);
        btnBack.setPrefWidth(51.0);
        btnBack.setStyle("-fx-background-color: #ffbdbd;");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#da0a0a"));

        pane.setPrefHeight(45.0);
        pane.setPrefWidth(51.0);

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(40.0);
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

        dropShadow3.setColor(javafx.scene.paint.Color.valueOf("#fff7f7")        );
        dropShadow3.setSpread(0.69);
        btnClose.setEffect(dropShadow3);

        btnMin.setLayoutX(547.0);
        btnMin.setLayoutY(23.0);
        btnMin.setMinHeight(USE_PREF_SIZE);
        btnMin.setMinWidth(50.0);
        btnMin.setMnemonicParsing(false);
        btnMin.setPrefHeight(40.0);
        btnMin.setPrefWidth(20.0);
        btnMin.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnMin.setText("-");
        btnMin.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnMin.setTextFill(javafx.scene.paint.Color.WHITE);
        btnMin.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btnMin.setFont(new Font("Franklin Gothic Demi Cond", 43.0));
        btnMin.setCursor(Cursor.HAND);

        dropShadow4.setColor(javafx.scene.paint.Color.valueOf("#fff7f7")        );
        dropShadow4.setSpread(0.69);
        btnMin.setEffect(dropShadow4);

        logoTic.setLayoutX(18.0);
        logoTic.setLayoutY(447.0);
        logoTic.setPrefHeight(76.0);
        logoTic.setPrefWidth(123.0);
        logoTic.setText("Tic.");
        logoTic.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoTic.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        logoTic.setFont(new Font("Bauhaus 93", 64.0));

        logoToe.setLayoutX(11.0);
        logoToe.setLayoutY(533.0);
        logoToe.setPrefHeight(76.0);
        logoToe.setPrefWidth(137.0);
        logoToe.setText("Toe.");
        logoToe.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoToe.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        logoToe.setFont(new Font("Bauhaus 93", 64.0));

        logoTac.setLayoutY(485.0);
        logoTac.setPrefHeight(76.0);
        logoTac.setPrefWidth(137.0);
        logoTac.setText("Tac.");
        logoTac.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoTac.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        logoTac.setFont(new Font("Bauhaus 93", 64.0));

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(circle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(circle0);
        getChildren().add(btnLow);
        getChildren().add(btnMiddle);
        getChildren().add(btnHigh);
        pane.getChildren().add(imageView);
        getChildren().add(btnBack);
        getChildren().add(btnClose);
        getChildren().add(btnMin);
        getChildren().add(logoTic);
        getChildren().add(logoToe);
        getChildren().add(logoTac);

        setListeners();
        
        ClientApp.curDisplayedScreen= this;
    }

    protected void setListeners() {
        btnClose.setOnAction((e) -> {
            Platform.exit();
        });

        btnMin.setOnAction((e) -> {
            ClientApp.stage.setIconified(true);
        });

        btnBack.setOnAction((e) -> {
            Parent root = new ModesScreenUI();
            Util.displayScreen(root);
        });

        btnLow.setOnAction((e) -> {
            Parent root = new RobotGame(1);
            Util.displayScreen(root);
        });

        btnMiddle.setOnAction((e) -> {
            Parent root = new RobotGame(2);
            Util.displayScreen(root);
        });

        btnHigh.setOnAction((e) -> {
            Parent root = new RobotGame(3);
            Util.displayScreen(root);
        });

    }
}
