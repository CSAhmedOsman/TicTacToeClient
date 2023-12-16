package ui;

import client.ClientApp;
import client.data.Player;
import java.io.File;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameBoard extends BorderPane {

    protected final Pane pane;
    protected final Pane win;
    protected final Ellipse backgroundET;
    protected final Rectangle backgroundRTX;
    protected final Rectangle backgroundRTX2;
    protected final Ellipse backgroundEB;
    protected final Label logoTic;
    protected final Label logoTac;
    protected final Label logoToe;
    protected final Rectangle backgroundRBX;
    protected final Rectangle backgroundRBX2;
    protected final Button btnNewGame;
    protected final DropShadow dropShadow;
    protected final Button btnRecordeGame;
    protected final DropShadow dropShadow0;
    protected final Button btnExitGame;
    protected final DropShadow dropShadow1;
    protected final Pane pane0;
    protected final Rectangle backgroundGame;
    protected final Pane panePlayerX;
    protected final Rectangle backgroundPlayerX;
    protected final Label labelPlayerX;
    protected final Label labelPlayerXNum;
    protected final Pane paneDraw;
    protected final Rectangle backgroundDraw;
    protected final Label lableDraw;
    protected final Label labelDrawNum;
    protected final Pane panePlayerO;
    protected final Rectangle backgroundPlayerO;
    protected final Label labelPlayerO;
    protected final Label labelPlayerONum;
    protected final Pane paneCount;
    protected final Rectangle backgroundCount;
    protected final Label labelCount;
    protected final Label labelCountNum;
    protected final Pane paneGame;
    protected final Rectangle backgroundPosition;
    protected final Button[] position;
    protected final DropShadow dropShadow2;
    protected final Button btnClose;
    protected final DropShadow dropShadow3;
    protected final Button btnMin;
    protected final DropShadow dropShadow4;

    //--------------ahmed work-----------
    protected boolean isXTurn;
    protected boolean isRunning;
    protected int countDownLimit;
    protected Stage stage;
    protected MediaPlayer mediaPlayer;
    protected int playedKey;

    {
        pane = new Pane();
        win = new Pane();
        backgroundET = new Ellipse();
        backgroundRTX = new Rectangle();
        backgroundRTX2 = new Rectangle();
        backgroundEB = new Ellipse();
        logoTic = new Label();
        logoTac = new Label();
        logoToe = new Label();
        backgroundRBX = new Rectangle();
        backgroundRBX2 = new Rectangle();
        btnNewGame = new Button();
        dropShadow = new DropShadow();
        btnRecordeGame = new Button();
        dropShadow0 = new DropShadow();
        btnExitGame = new Button();
        dropShadow1 = new DropShadow();
        pane0 = new Pane();
        backgroundGame = new Rectangle();
        panePlayerX = new Pane();
        backgroundPlayerX = new Rectangle();
        labelPlayerX = new Label();
        labelPlayerXNum = new Label();
        paneDraw = new Pane();
        backgroundDraw = new Rectangle();
        lableDraw = new Label();
        labelDrawNum = new Label();
        panePlayerO = new Pane();
        backgroundPlayerO = new Rectangle();
        labelPlayerO = new Label();
        labelPlayerONum = new Label();
        paneCount = new Pane();
        backgroundCount = new Rectangle();
        labelCount = new Label();
        labelCountNum = new Label();
        paneGame = new Pane();
        backgroundPosition = new Rectangle();
        position = new Button[9];
        for (int i = 0; i < 9; i++) {
            position[i] = new Button();
        }
        dropShadow2 = new DropShadow();
        btnClose = new Button();
        dropShadow3 = new DropShadow();
        btnMin = new Button();
        dropShadow4 = new DropShadow();
        //---------------ahmed work------------
        isRunning = false;
        isXTurn = true;
        countDownLimit = 0;
        playedKey = 0;
    }

    public GameBoard() {
        init();
        startLocalGame();
    }

    /*
    public GameBoard(Player or Robot) {
        init();
        //------ add function name for handling the gamming aginst robot
    }
     */
    // show recorded games ---
    public GameBoard(File file) {
        init();
        //--------add function name for handling the read files
        // -------- don't forget to disable -- buttons with using forloop -- position[i].setDisable(true);
    }

    // playing online game ---
    public GameBoard(Player player1, Socket player2) {
        init();
        //--------add function name for handling the online gamming
    }

    public void init() {

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: F1AAAA;");

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        backgroundET.setLayoutX(626.0);
        backgroundET.setLayoutY(36.0);
        backgroundET.setOpacity(0.2);
        backgroundET.setRadiusX(88.0);
        backgroundET.setRadiusY(84.0);
        backgroundET.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundET.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        backgroundRTX.setArcHeight(5.0);
        backgroundRTX.setArcWidth(5.0);
        backgroundRTX.setHeight(200.0);
        backgroundRTX.setLayoutX(12.0);
        backgroundRTX.setLayoutY(-19.0);
        backgroundRTX.setOpacity(0.2);
        backgroundRTX.setRotate(-65.0);
        backgroundRTX.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundRTX.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundRTX.setWidth(30.0);

        backgroundRTX2.setArcHeight(5.0);
        backgroundRTX2.setArcWidth(5.0);
        backgroundRTX2.setHeight(200.0);
        backgroundRTX2.setLayoutX(12.0);
        backgroundRTX2.setLayoutY(-19.0);
        backgroundRTX2.setOpacity(0.2);
        backgroundRTX2.setRotate(25.0);
        backgroundRTX2.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundRTX2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundRTX2.setWidth(30.0);

        backgroundEB.setLayoutX(53.0);
        backgroundEB.setLayoutY(532.0);
        backgroundEB.setOpacity(0.2);
        backgroundEB.setRadiusX(112.0);
        backgroundEB.setRadiusY(102.0);
        backgroundEB.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundEB.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        logoTic.setLayoutX(14.0);
        logoTic.setLayoutY(431.0);
        logoTic.setPrefHeight(76.0);
        logoTic.setPrefWidth(123.0);
        logoTic.setText("Tic.");
        logoTic.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoTic.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        logoTic.setFont(new Font("Bauhaus 93", 64.0));

        logoTac.setLayoutX(1.0);
        logoTac.setLayoutY(475.0);
        logoTac.setPrefHeight(76.0);
        logoTac.setPrefWidth(137.0);
        logoTac.setText("Tac.");
        logoTac.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoTac.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        logoTac.setFont(new Font("Bauhaus 93", 64.0));

        logoToe.setLayoutX(8.0);
        logoToe.setLayoutY(524.0);
        logoToe.setPrefHeight(76.0);
        logoToe.setPrefWidth(137.0);
        logoToe.setText("Toe.");
        logoToe.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoToe.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        logoToe.setFont(new Font("Bauhaus 93", 64.0));

        backgroundRBX.setArcHeight(5.0);
        backgroundRBX.setArcWidth(5.0);
        backgroundRBX.setHeight(200.0);
        backgroundRBX.setLayoutX(605.0);
        backgroundRBX.setLayoutY(473.0);
        backgroundRBX.setOpacity(0.2);
        backgroundRBX.setRotate(-25.0);
        backgroundRBX.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundRBX.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundRBX.setWidth(30.0);

        backgroundRBX2.setArcHeight(5.0);
        backgroundRBX2.setArcWidth(5.0);
        backgroundRBX2.setHeight(200.0);
        backgroundRBX2.setLayoutX(605.0);
        backgroundRBX2.setLayoutY(473.0);
        backgroundRBX2.setOpacity(0.2);
        backgroundRBX2.setRotate(65.0);
        backgroundRBX2.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundRBX2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundRBX2.setWidth(30.0);

        btnNewGame.setLayoutX(88.0);
        btnNewGame.setLayoutY(196.0);
        btnNewGame.setMnemonicParsing(false);
        btnNewGame.setPrefHeight(44.0);
        btnNewGame.setPrefWidth(132.0);
        btnNewGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnNewGame.setText("New Game");
        btnNewGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnNewGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow.setSpread(0.25);
        btnNewGame.setEffect(dropShadow);
        btnNewGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnNewGame.setCursor(Cursor.HAND);

        btnRecordeGame.setLayoutX(71.0);
        btnRecordeGame.setLayoutY(286.0);
        btnRecordeGame.setMnemonicParsing(false);
        btnRecordeGame.setPrefHeight(44.0);
        btnRecordeGame.setPrefWidth(167.0);
        btnRecordeGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnRecordeGame.setText("Recorde Game");
        btnRecordeGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnRecordeGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow0.setColor(Color.valueOf("#fff7f7"));
        dropShadow0.setSpread(0.25);
        btnRecordeGame.setEffect(dropShadow0);
        btnRecordeGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnRecordeGame.setCursor(Cursor.HAND);

        btnExitGame.setLayoutX(92.0);
        btnExitGame.setLayoutY(374.0);
        btnExitGame.setMnemonicParsing(false);
        btnExitGame.setPrefHeight(44.0);
        btnExitGame.setPrefWidth(123.0);
        btnExitGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnExitGame.setText("Exit Game");
        btnExitGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnExitGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow1.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow1.setSpread(0.25);
        btnExitGame.setEffect(dropShadow1);
        btnExitGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnExitGame.setCursor(Cursor.HAND);

        pane0.setLayoutX(286.0);
        pane0.setLayoutY(117.0);
        pane0.setPrefHeight(450.0);
        pane0.setPrefWidth(350.0);

        backgroundGame.setArcHeight(25.0);
        backgroundGame.setArcWidth(25.0);
        backgroundGame.setFill(javafx.scene.paint.Color.valueOf("#ca4b62"));
        backgroundGame.setHeight(450.0);
        backgroundGame.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundGame.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundGame.setStrokeWidth(0.0);
        backgroundGame.setWidth(350.0);

        panePlayerX.setLayoutX(25.0);
        panePlayerX.setLayoutY(23.0);
        panePlayerX.setPrefHeight(90.0);
        panePlayerX.setPrefWidth(90.0);

        backgroundPlayerX.setArcHeight(20.0);
        backgroundPlayerX.setArcWidth(20.0);
        backgroundPlayerX.setFill(javafx.scene.paint.Color.valueOf("#030040"));
        backgroundPlayerX.setHeight(90.0);
        backgroundPlayerX.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundPlayerX.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundPlayerX.setStrokeWidth(0.0);
        backgroundPlayerX.setWidth(90.0);

        labelPlayerX.setLayoutX(9.0);
        labelPlayerX.setLayoutY(11.0);
        labelPlayerX.setText("Player X");
        labelPlayerX.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelPlayerX.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayerX.setFont(new Font("Arial Rounded MT Bold", 18.0));

        labelPlayerXNum.setLayoutX(40.0);
        labelPlayerXNum.setLayoutY(45.0);
        labelPlayerXNum.setText("0");
        labelPlayerXNum.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelPlayerXNum.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayerXNum.setFont(new Font("Arial Rounded MT Bold", 18.0));

        paneDraw.setLayoutX(130.0);
        paneDraw.setLayoutY(23.0);
        paneDraw.setPrefHeight(90.0);
        paneDraw.setPrefWidth(90.0);

        backgroundDraw.setArcHeight(15.0);
        backgroundDraw.setArcWidth(15.0);
        backgroundDraw.setFill(javafx.scene.paint.Color.valueOf("#bcdbf9"));
        backgroundDraw.setHeight(90.0);
        backgroundDraw.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundDraw.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundDraw.setStrokeWidth(0.0);
        backgroundDraw.setWidth(90.0);

        lableDraw.setLayoutX(19.0);
        lableDraw.setLayoutY(11.0);
        lableDraw.setText("Draw");
        lableDraw.setTextFill(javafx.scene.paint.Color.valueOf("#515151"));
        lableDraw.setFont(new Font("Arial Rounded MT Bold", 20.0));

        labelDrawNum.setLayoutX(40.0);
        labelDrawNum.setLayoutY(45.0);
        labelDrawNum.setText("0");
        labelDrawNum.setTextFill(javafx.scene.paint.Color.valueOf("#515151"));
        labelDrawNum.setFont(new Font("Arial Rounded MT Bold", 18.0));

        panePlayerO.setLayoutX(235.0);
        panePlayerO.setLayoutY(23.0);
        panePlayerO.setPrefHeight(90.0);
        panePlayerO.setPrefWidth(90.0);

        backgroundPlayerO.setArcHeight(20.0);
        backgroundPlayerO.setArcWidth(20.0);
        backgroundPlayerO.setFill(javafx.scene.paint.Color.valueOf("#e2be00"));
        backgroundPlayerO.setHeight(90.0);
        backgroundPlayerO.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundPlayerO.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundPlayerO.setStrokeWidth(0.0);
        backgroundPlayerO.setWidth(90.0);

        labelPlayerO.setLayoutX(8.0);
        labelPlayerO.setLayoutY(11.0);
        labelPlayerO.setText("Player O");
        labelPlayerO.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelPlayerO.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayerO.setFont(new Font("Arial Rounded MT Bold", 18.0));

        labelPlayerONum.setLayoutX(40.0);
        labelPlayerONum.setLayoutY(45.0);
        labelPlayerONum.setText("0");
        labelPlayerONum.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelPlayerONum.setTextFill(javafx.scene.paint.Color.WHITE);
        labelPlayerONum.setFont(new Font("Arial Rounded MT Bold", 18.0));

        paneCount.setLayoutX(25.0);
        paneCount.setLayoutY(23.0);
        paneCount.setOpacity(0.0);
        paneCount.setPrefHeight(90.0);
        paneCount.setPrefWidth(300.0);

        backgroundCount.setArcHeight(15.0);
        backgroundCount.setArcWidth(15.0);
        backgroundCount.setFill(javafx.scene.paint.Color.valueOf("#bcdbf9"));
        backgroundCount.setHeight(90.0);
        backgroundCount.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundCount.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundCount.setStrokeWidth(0.0);
        backgroundCount.setWidth(300.0);

        labelCount.setLayoutX(79.0);
        labelCount.setLayoutY(14.0);
        labelCount.setText("Count Down");
        labelCount.setTextFill(javafx.scene.paint.Color.valueOf("#515151"));
        labelCount.setFont(new Font("Arial Rounded MT Bold", 24.0));

        labelCountNum.setLayoutX(118.0);
        labelCountNum.setLayoutY(45.0);
        labelCountNum.setText("01:00");
        labelCountNum.setTextFill(javafx.scene.paint.Color.valueOf("#515151"));
        labelCountNum.setFont(new Font("Arial Rounded MT Bold", 24.0));

        paneGame.setLayoutX(25.0);
        paneGame.setLayoutY(128.0);
        paneGame.setPrefHeight(300.0);
        paneGame.setPrefWidth(300.0);

        win.setLayoutX(75.0);
        win.setLayoutY(25.0);
        win.setPrefHeight(550.0);
        win.setPrefWidth(550.0);
        win.setOpacity(0.0);
        win.setDisable(true);
        win.setStyle("-fx-background-radius: 10; -fx-background-color: #FD6D84;");

        backgroundPosition.setArcHeight(20.0);
        backgroundPosition.setArcWidth(20.0);
        backgroundPosition.setFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        backgroundPosition.setHeight(300.0);
        backgroundPosition.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundPosition.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundPosition.setStrokeWidth(0.0);
        backgroundPosition.setWidth(300.0);

        btnExitGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        dropShadow1.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow1.setSpread(0.25);
        btnExitGame.setEffect(dropShadow1);

        for (int i = 0; i < 9; i++) {
            position[i].setAlignment(javafx.geometry.Pos.CENTER);
            position[i].setMnemonicParsing(false);
            position[i].setPrefHeight(85.0);
            position[i].setPrefWidth(85.0);
            position[i].setText("");
            position[i].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
            position[i].setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
            position[i].setFont(new Font("Arial Rounded MT Bold", 36.0));
            position[i].setCursor(Cursor.HAND);
            if (i / 3 == 0) {
                position[i].setLayoutY(11.0);
                if (i % 3 == 0) {
                    position[i].setLayoutX(11.0);
                } else if (i % 3 == 1) {
                    position[i].setLayoutX(107.0);
                } else {
                    position[i].setLayoutX(203.0);
                }
            } else if (i / 3 == 1) {
                position[i].setLayoutY(107.0);
                if (i % 3 == 0) {
                    position[i].setLayoutX(11.0);
                } else if (i % 3 == 1) {
                    position[i].setLayoutX(107.0);
                } else {
                    position[i].setLayoutX(203.0);
                }
            } else {
                position[i].setLayoutY(203.0);
                if (i % 3 == 0) {
                    position[i].setLayoutX(11.0);
                } else if (i % 3 == 1) {
                    position[i].setLayoutX(107.0);
                } else {
                    position[i].setLayoutX(203.0);
                }
            }

        }

        dropShadow2.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow2.setSpread(0.25);
        pane0.setEffect(dropShadow2);

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

        dropShadow3.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow3.setSpread(0.69);
        btnClose.setEffect(dropShadow3);

        btnMin.setLayoutX(567.0);
        btnMin.setLayoutY(20.0);
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

        dropShadow4.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow4.setSpread(0.69);
        btnMin.setEffect(dropShadow4);
        setCenter(pane);

        pane.getChildren().add(backgroundET);
        pane.getChildren().add(backgroundRTX);
        pane.getChildren().add(backgroundRTX2);
        pane.getChildren().add(backgroundEB);
        pane.getChildren().add(logoTic);
        pane.getChildren().add(logoTac);
        pane.getChildren().add(logoToe);
        pane.getChildren().add(backgroundRBX);
        pane.getChildren().add(backgroundRBX2);
        pane.getChildren().add(btnNewGame);
        pane.getChildren().add(btnRecordeGame);
        pane.getChildren().add(btnExitGame);
        pane0.getChildren().add(backgroundGame);
        panePlayerX.getChildren().add(backgroundPlayerX);
        panePlayerX.getChildren().add(labelPlayerX);
        panePlayerX.getChildren().add(labelPlayerXNum);
        pane0.getChildren().add(panePlayerX);
        paneDraw.getChildren().add(backgroundDraw);
        paneDraw.getChildren().add(lableDraw);
        paneDraw.getChildren().add(labelDrawNum);
        pane0.getChildren().add(paneDraw);
        panePlayerO.getChildren().add(backgroundPlayerO);
        panePlayerO.getChildren().add(labelPlayerO);
        panePlayerO.getChildren().add(labelPlayerONum);
        pane0.getChildren().add(panePlayerO);
        paneCount.getChildren().add(backgroundCount);
        paneCount.getChildren().add(labelCount);
        paneCount.getChildren().add(labelCountNum);
        pane0.getChildren().add(paneCount);
        paneGame.getChildren().add(backgroundPosition);
        for (int i = 0; i < 9; i++) {
            paneGame.getChildren().add(position[i]);
        }
        pane0.getChildren().add(paneGame);
        pane.getChildren().add(pane0);
        pane.getChildren().add(btnClose);
        pane.getChildren().add(btnMin);
        pane.getChildren().add(win);
    }

    public void startLocalGame() {
        for (int i = 0; i < 9; i++) {
            position[i].setText("");
            position[i].setDisable(false);
            position[i].setStyle("-fx-background-radius: 10; -fx-background-color: #c7c7c7;");
        }

        //---------------ahmed work------------
        playedKey = 0;
        isRunning = true;
        isXTurn = true;
        paneCount.setOpacity(1.0);
        countDownLimit = 30;

        //------------Handlers------
        addEventHandlers();
        //----------Game Limits countDownLimit thread
        new Thread(() -> {
            while (isRunning && winIndex()[0] == -1) {
                try {
                    if (countDownLimit > 1) {
                        drawCount();
                    } else {
                        changeTern();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private void changeTern() {
        int[] winIndexes = winIndex();
        if (playedKey < 9 && winIndexes[0] == -1) {
            countDownLimit = 30;
            isXTurn = !isXTurn;
            drawCount();
        } else if (winIndexes[0] != -1) {
            for (int i = 0; i < 9; i++) {
                position[i].setDisable(true);
            }
            winner(winIndexes);
        } else {
            drawer();
        }
    }

    private int[] winIndex() {
        int[] indexes = {-1, -1, -1};
        if ((position[0].getText() != "" && position[1].getText() != "" && position[2].getText() != "")
                && (position[0].getText() == position[1].getText() && position[1].getText() == position[2].getText())) {
            indexes[0] = 0;
            indexes[1] = 1;
            indexes[2] = 2;
        } else if ((position[3].getText() != "" && position[4].getText() != "" && position[5].getText() != "")
                && (position[3].getText() == position[4].getText() && position[4].getText() == position[5].getText())) {
            indexes[0] = 3;
            indexes[1] = 4;
            indexes[2] = 5;
        } else if ((position[6].getText() != "" && position[7].getText() != "" && position[8].getText() != "")
                && (position[6].getText() == position[7].getText() && position[7].getText() == position[8].getText())) {
            indexes[0] = 6;
            indexes[1] = 7;
            indexes[2] = 8;
        } else if ((position[0].getText() != "" && position[3].getText() != "" && position[6].getText() != "")
                && (position[0].getText() == position[3].getText() && position[3].getText() == position[6].getText())) {
            indexes[0] = 0;
            indexes[1] = 3;
            indexes[2] = 6;
        } else if ((position[1].getText() != "" && position[4].getText() != "" && position[7].getText() != "")
                && (position[1].getText() == position[4].getText() && position[4].getText() == position[7].getText())) {
            indexes[0] = 1;
            indexes[1] = 4;
            indexes[2] = 7;
        } else if ((position[2].getText() != "" && position[5].getText() != "" && position[8].getText() != "")
                && (position[2].getText() == position[5].getText() && position[5].getText() == position[8].getText())) {
            indexes[0] = 2;
            indexes[1] = 5;
            indexes[2] = 8;
        } else if ((position[0].getText() != "" && position[4].getText() != "" && position[8].getText() != "")
                && (position[0].getText() == position[4].getText() && position[4].getText() == position[8].getText())) {
            indexes[0] = 0;
            indexes[1] = 4;
            indexes[2] = 8;
        } else if ((position[2].getText() != "" && position[4].getText() != "" && position[6].getText() != "")
                && (position[2].getText() == position[4].getText() && position[4].getText() == position[6].getText())) {
            indexes[0] = 2;
            indexes[1] = 4;
            indexes[2] = 6;
        }
        return indexes;
    }

    private void winner(int[] winIndexes) {
        isRunning = false;
        for (int i = 0; i < 3; i++) {
            position[winIndexes[i]].setStyle("-fx-background-radius: 10; -fx-background-color: #FD6D84;");
            position[winIndexes[i]].setEffect(dropShadow1);
        }
        paneCount.setOpacity(0.0);
        if (position[winIndexes[0]].getText() == "X") {
            int name = Integer.valueOf(labelPlayerXNum.getText()) + 1;
            labelPlayerXNum.setText("" + name);
        } else {
            int name = Integer.valueOf(labelPlayerONum.getText()) + 1;
            labelPlayerONum.setText("" + name);
        }
        String fileName = "/src/ui/video/win.mp4";
        String directory = System.getProperty("user.dir");
        String path = directory + fileName;
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        mediaView.setLayoutX(5.0);
        mediaView.setLayoutY(5.0);
        win.setOpacity(1.0);
        win.getChildren().add(mediaView);
        win.setDisable(false);
    }

    private void addEventHandlers() {
        //ClientApp.stage.
        btnClose.setOnAction((e) -> {
            isRunning = false;
            Platform.exit();
        });

        btnMin.setOnAction((e) -> {
            ClientApp.stage.setIconified(true);
        });

        win.setOnMouseClicked((e) -> {
            mediaPlayer.pause();
            win.setOpacity(0.0);
            win.setDisable(true);
        });

        //X-O-Draws
        for (int i = 0; i < 9; i++) {
            final int index = i;
            position[i].setOnAction((e) -> {
                position[index].setText(isXTurn ? "X" : "O");
                position[index].setDisable(true);
                playedKey++;
                changeTern();
            });
        }

        //new game btn
        btnNewGame.setOnAction((e) -> {
            startLocalGame();
        });
    }

    private void drawCount() {
        if (isXTurn) {
            Platform.runLater(() -> labelCount.setText("Player 1 Turn"));
        } else {
            Platform.runLater(() -> labelCount.setText("Player 2 Turn"));
        }
        if (countDownLimit > 10) {
            Platform.runLater(() -> labelCountNum.setText("00:" + (--countDownLimit)));
        } else {
            Platform.runLater(() -> labelCountNum.setText("00:0" + (--countDownLimit)));
        }
    }

    private void drawer() {
        isRunning = false;
        paneCount.setOpacity(0.0);
        int name = Integer.valueOf(labelDrawNum.getText()) + 1;
        labelDrawNum.setText("" + name);
    }
}
