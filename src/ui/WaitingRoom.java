package ui;

import client.ClientApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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

public class WaitingRoom extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label labe2;
    protected final DropShadow dropShadow;
    protected final Circle circle;
    protected final Circle circle0;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle btnLogin;
    protected final Button btnBack;
    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button btnClose;
    protected final DropShadow dropShadow0;
    protected final Button btnMin;
    protected final DropShadow dropShadow1;
    protected final Pane pane0;
    protected final ImageView imageView0;
    protected final Label labelCount;
    protected int countDownMSec;
    protected int countDownSec;
    protected boolean isRunning;

    public WaitingRoom(int playerId) {
        ClientApp.curDisplayedScreen = this;
        isRunning = true;
        countDownSec = 59;
        countDownMSec = 99;
        rectangle = new Rectangle();
        label = new Label();
        labe2 = new Label();
        dropShadow = new DropShadow();
        circle = new Circle();
        circle0 = new Circle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        btnLogin = new Rectangle();
        btnBack = new Button();
        pane = new Pane();
        imageView = new ImageView();
        btnClose = new Button();
        dropShadow0 = new DropShadow();
        btnMin = new Button();
        dropShadow1 = new DropShadow();
        pane0 = new Pane();
        imageView0 = new ImageView();
        labelCount = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#ffbdbd"));
        rectangle.setHeight(600.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(700.0);

        label.setLayoutX(150.0);
        label.setLayoutY(100.0);
        label.setText("Waiting Room");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#431159"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 72.0));

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#e6e1f5"));
        dropShadow.setSpread(0.75);
        label.setEffect(dropShadow);

        labe2.setLayoutX(40.0);
        labe2.setLayoutY(180.0);
        labe2.setText("Waiting for your partner to accept the request");
        labe2.setTextFill(javafx.scene.paint.Color.valueOf("#431159"));
        labe2.setFont(new Font("Franklin Gothic Demi Cond", 36.0));

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#e6e1f5"));
        dropShadow.setSpread(0.50);
        labe2.setEffect(dropShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(631.0);
        circle.setLayoutY(51.0);
        circle.setOpacity(0.2);
        circle.setRadius(111.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(54.0);
        circle0.setLayoutY(548.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(85.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circle0.setStrokeWidth(0.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle0.setHeight(188.0);
        rectangle0.setLayoutX(627.0);
        rectangle0.setLayoutY(473.0);
        rectangle0.setOpacity(0.2);
        rectangle0.setRotate(145.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(29.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle1.setHeight(188.0);
        rectangle1.setLayoutX(627.0);
        rectangle1.setLayoutY(473.0);
        rectangle1.setOpacity(0.2);
        rectangle1.setRotate(55.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(29.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle2.setHeight(188.0);
        rectangle2.setLayoutX(14.0);
        rectangle2.setLayoutY(48.0);
        rectangle2.setOpacity(0.2);
        rectangle2.setRotate(155.0);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(29.0);

        btnLogin.setArcHeight(5.0);
        btnLogin.setArcWidth(5.0);
        btnLogin.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        btnLogin.setHeight(188.0);
        btnLogin.setLayoutX(14.0);
        btnLogin.setLayoutY(48.0);
        btnLogin.setOpacity(0.2);
        btnLogin.setRotate(65.0);
        btnLogin.setStroke(javafx.scene.paint.Color.BLACK);
        btnLogin.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        btnLogin.setWidth(29.0);

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

        dropShadow0.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow0.setSpread(0.69);
        btnClose.setEffect(dropShadow0);

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

        dropShadow1.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow1.setSpread(0.69);
        btnMin.setEffect(dropShadow1);

        pane0.setLayoutX(200.0);
        pane0.setLayoutY(225.0);
        pane0.setPrefHeight(250.0);
        pane0.setPrefWidth(300.0);
        
        imageView0.setFitHeight(250.0);
        imageView0.setFitWidth(300.0);
        imageView0.setImage(new Image(getClass().getResource("images/gif/loading.gif").toExternalForm()));
        
        labelCount.setAlignment(javafx.geometry.Pos.CENTER);
        labelCount.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        labelCount.setLayoutX(201.0);
        labelCount.setLayoutY(426.0);
        labelCount.setPrefWidth(300.0);
        labelCount.setText("00:00:00");
        labelCount.setFont(new Font("Franklin Gothic Demi Cond", 48.0));

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(labe2);
        getChildren().add(circle);
        getChildren().add(circle0);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(btnLogin);
        pane.getChildren().add(imageView);
        getChildren().add(btnBack);
        getChildren().add(btnClose);
        getChildren().add(btnMin);
        pane0.getChildren().add(imageView0);
        getChildren().add(pane0);
        getChildren().add(labelCount);

        //---------Ahmed Work----------
        addEventHandlers();
        btnBack.setDisable(true);
        Thread thread = new Thread(() -> {
            while (isRunning) {
                System.err.println("Waiting Room Thread");
                try {
                    if (countDownMSec <= 0 && countDownSec <= 0) {
                        isRunning = false;
                        //utils.Util.displayScreen(new LobbyScreenUI(playerId));
                    } else {
                        if (countDownMSec <= 0) {
                            countDownMSec = 99;
                            countDownSec--;
                        } else {
                            btnBack.setDisable(false);
                        }
                        drawCount();
                        Thread.sleep(10);
                    }
                } catch (InterruptedException ex) {
                    isRunning = false;
                    Util.showAlertDialog(Alert.AlertType.ERROR, "CountDown Error", "Error While Draw CountDown");
                }
            }
        });
        thread.start();
    }

    protected void drawCount() {
        String seconds = (countDownSec > 9 ? "" : "0") + (countDownSec);
        String mSeconds = (countDownMSec > 9 ? "" : "0") + (countDownMSec--);
        Platform.runLater(() -> labelCount.setText("00:" + seconds + ":" + mSeconds));
    }

    protected void addEventHandlers() {
        btnBack.setOnAction((ActionEvent event) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            isRunning=false;
            Parent root = new LobbyScreenUI(ClientApp.playerId);
            Util.displayScreen(root);
        });
        btnClose.setOnAction((e) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            isRunning = false;
            ClientApp.close();
        });

        btnMin.setOnAction((e) -> {
            ClientApp.soundManager.stopClickSound();
            ClientApp.soundManager.playClickSound();
            ClientApp.stage.setIconified(true);
        });
    }
}
