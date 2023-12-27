package ui;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class GameBoardbase extends BorderPane {

    protected final Pane pane;
    protected final Ellipse backgroundET;
    protected final Rectangle backgroundRTX;
    protected final Rectangle backgroundRTX2;
    protected final Label logoTic;
    protected final Rectangle backgroundRBX;
    protected final Rectangle backgroundRBX2;
    protected final Button btnNewGame;
    protected final DropShadow dropShadow;
    protected final Pane paneMessage;
    protected final BorderPane borderMessage;
    protected final TextArea taMessage;
    protected final FlowPane flowPane;
    protected final TextField tfMessage;
    protected final Button btnSendMessage;
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
    protected final Button position1;
    protected final Button position2;
    protected final Button position3;
    protected final Button position4;
    protected final Button position5;
    protected final Button position6;
    protected final Button position7;
    protected final Button position8;
    protected final Button position9;
    protected final DropShadow dropShadow0;
    protected final Button btnClose;
    protected final DropShadow dropShadow1;
    protected final Button btnMin;
    protected final DropShadow dropShadow2;
    protected final Button btnExitGame;
    protected final DropShadow dropShadow3;
    protected final Button btnRecordeGame;
    protected final DropShadow dropShadow4;

    public GameBoardbase() {

        pane = new Pane();
        backgroundET = new Ellipse();
        backgroundRTX = new Rectangle();
        backgroundRTX2 = new Rectangle();
        logoTic = new Label();
        backgroundRBX = new Rectangle();
        backgroundRBX2 = new Rectangle();
        btnNewGame = new Button();
        dropShadow = new DropShadow();
        paneMessage = new Pane();
        borderMessage = new BorderPane();
        taMessage = new TextArea();
        flowPane = new FlowPane();
        tfMessage = new TextField();
        btnSendMessage = new Button();
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
        position1 = new Button();
        position2 = new Button();
        position3 = new Button();
        position4 = new Button();
        position5 = new Button();
        position6 = new Button();
        position7 = new Button();
        position8 = new Button();
        position9 = new Button();
        dropShadow0 = new DropShadow();
        btnClose = new Button();
        dropShadow1 = new DropShadow();
        btnMin = new Button();
        dropShadow2 = new DropShadow();
        btnExitGame = new Button();
        dropShadow3 = new DropShadow();
        btnRecordeGame = new Button();
        dropShadow4 = new DropShadow();

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

        logoTic.setLayoutX(14.0);
        logoTic.setLayoutY(431.0);
        logoTic.setPrefHeight(76.0);
        logoTic.setPrefWidth(123.0);
        logoTic.setText("Tic.");
        logoTic.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        logoTic.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        logoTic.setFont(new Font("Bauhaus 93", 64.0));

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

        btnNewGame.setLayoutX(90.0);
        btnNewGame.setLayoutY(542.0);
        btnNewGame.setMnemonicParsing(false);
        btnNewGame.setPrefHeight(44.0);
        btnNewGame.setPrefWidth(131.0);
        btnNewGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnNewGame.setText("New Game");
        btnNewGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnNewGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow.setSpread(0.25);
        btnNewGame.setEffect(dropShadow);
        btnNewGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnNewGame.setCursor(Cursor.HAND);

        paneMessage.setLayoutX(411.0);
        paneMessage.setLayoutY(93.0);

        borderMessage.setMaxHeight(USE_PREF_SIZE);
        borderMessage.setMaxWidth(USE_PREF_SIZE);
        borderMessage.setMinHeight(USE_PREF_SIZE);
        borderMessage.setMinWidth(USE_PREF_SIZE);
        borderMessage.setPrefHeight(415.0);
        borderMessage.setPrefWidth(265.0);
        borderMessage.setStyle("-fx-background-radius: 20;");

        BorderPane.setAlignment(taMessage, javafx.geometry.Pos.CENTER);
        taMessage.setDisable(true);
        taMessage.setPrefWidth(0.0);
        taMessage.setStyle("-fx-textColor: black; -fx-background-radius: 10;");
        borderMessage.setCenter(taMessage);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);

        tfMessage.setPrefHeight(50.0);
        tfMessage.setPrefWidth(180.0);
        tfMessage.setStyle("-fx-background-radius: 10;");

        btnSendMessage.setMnemonicParsing(false);
        btnSendMessage.setPrefHeight(50.0);
        btnSendMessage.setPrefWidth(85.0);
        btnSendMessage.setStyle("-fx-background-color: #FD6D84; -fx-background-radius: 10;");
        btnSendMessage.setText("Send");
        btnSendMessage.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
        btnSendMessage.setFont(new Font(23.0));
        borderMessage.setBottom(flowPane);

        pane0.setLayoutX(46.0);
        pane0.setLayoutY(75.0);
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
        paneCount.setOpacity(0.41);
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

        backgroundPosition.setArcHeight(20.0);
        backgroundPosition.setArcWidth(20.0);
        backgroundPosition.setFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        backgroundPosition.setHeight(300.0);
        backgroundPosition.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundPosition.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundPosition.setStrokeWidth(0.0);
        backgroundPosition.setWidth(300.0);

        position1.setAlignment(javafx.geometry.Pos.CENTER);
        position1.setLayoutX(10.0);
        position1.setLayoutY(7.0);
        position1.setMnemonicParsing(false);
        position1.setPrefHeight(85.0);
        position1.setPrefWidth(85.0);
        position1.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position1.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position1.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position1.setCursor(Cursor.HAND);

        position2.setAlignment(javafx.geometry.Pos.CENTER);
        position2.setLayoutX(108.0);
        position2.setLayoutY(7.0);
        position2.setMnemonicParsing(false);
        position2.setPrefHeight(85.0);
        position2.setPrefWidth(85.0);
        position2.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position2.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position2.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position2.setCursor(Cursor.HAND);

        position3.setAlignment(javafx.geometry.Pos.CENTER);
        position3.setLayoutX(205.0);
        position3.setLayoutY(8.0);
        position3.setMnemonicParsing(false);
        position3.setPrefHeight(85.0);
        position3.setPrefWidth(85.0);
        position3.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position3.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position3.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position3.setCursor(Cursor.HAND);

        position4.setAlignment(javafx.geometry.Pos.CENTER);
        position4.setLayoutX(10.0);
        position4.setLayoutY(108.0);
        position4.setMnemonicParsing(false);
        position4.setPrefHeight(85.0);
        position4.setPrefWidth(85.0);
        position4.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position4.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position4.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position4.setCursor(Cursor.HAND);

        position5.setAlignment(javafx.geometry.Pos.CENTER);
        position5.setLayoutX(108.0);
        position5.setLayoutY(108.0);
        position5.setMnemonicParsing(false);
        position5.setPrefHeight(85.0);
        position5.setPrefWidth(85.0);
        position5.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position5.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position5.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position5.setCursor(Cursor.HAND);

        position6.setAlignment(javafx.geometry.Pos.CENTER);
        position6.setLayoutX(205.0);
        position6.setLayoutY(109.0);
        position6.setMnemonicParsing(false);
        position6.setPrefHeight(85.0);
        position6.setPrefWidth(85.0);
        position6.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position6.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position6.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position6.setCursor(Cursor.HAND);

        position7.setAlignment(javafx.geometry.Pos.CENTER);
        position7.setLayoutX(10.0);
        position7.setLayoutY(208.0);
        position7.setMnemonicParsing(false);
        position7.setPrefHeight(85.0);
        position7.setPrefWidth(85.0);
        position7.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position7.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position7.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position7.setCursor(Cursor.HAND);

        position8.setAlignment(javafx.geometry.Pos.CENTER);
        position8.setLayoutX(108.0);
        position8.setLayoutY(208.0);
        position8.setMnemonicParsing(false);
        position8.setPrefHeight(85.0);
        position8.setPrefWidth(85.0);
        position8.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position8.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position8.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position8.setCursor(Cursor.HAND);

        position9.setAlignment(javafx.geometry.Pos.CENTER);
        position9.setLayoutX(205.0);
        position9.setLayoutY(209.0);
        position9.setMnemonicParsing(false);
        position9.setPrefHeight(85.0);
        position9.setPrefWidth(85.0);
        position9.setStyle("-fx-background-radius: 10; -fx-background-color: #d7d7d7;");
        position9.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        position9.setFont(new Font("Arial Rounded MT Bold", 36.0));
        position9.setCursor(Cursor.HAND);

        dropShadow0.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow0.setSpread(0.25);
        pane0.setEffect(dropShadow0);

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

        dropShadow1.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow1.setSpread(0.69);
        btnClose.setEffect(dropShadow1);

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

        dropShadow2.setColor(javafx.scene.paint.Color.valueOf("#d0c1c1"));
        dropShadow2.setSpread(0.69);
        btnMin.setEffect(dropShadow2);

        btnExitGame.setLayoutX(476.0);
        btnExitGame.setLayoutY(542.0);
        btnExitGame.setMnemonicParsing(false);
        btnExitGame.setPrefHeight(44.0);
        btnExitGame.setPrefWidth(124.0);
        btnExitGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnExitGame.setText("Exit Game");
        btnExitGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnExitGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow3.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow3.setSpread(0.25);
        btnExitGame.setEffect(dropShadow3);
        btnExitGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnExitGame.setCursor(Cursor.HAND);

        btnRecordeGame.setLayoutX(266.0);
        btnRecordeGame.setLayoutY(542.0);
        btnRecordeGame.setMnemonicParsing(false);
        btnRecordeGame.setPrefHeight(44.0);
        btnRecordeGame.setPrefWidth(168.0);
        btnRecordeGame.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnRecordeGame.setText("Recorde Game");
        btnRecordeGame.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnRecordeGame.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow4.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow4.setSpread(0.25);
        btnRecordeGame.setEffect(dropShadow4);
        btnRecordeGame.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnRecordeGame.setCursor(Cursor.HAND);
        setCenter(pane);

        pane.getChildren().add(backgroundET);
        pane.getChildren().add(backgroundRTX);
        pane.getChildren().add(backgroundRTX2);
        pane.getChildren().add(logoTic);
        pane.getChildren().add(backgroundRBX);
        pane.getChildren().add(backgroundRBX2);
        pane.getChildren().add(btnNewGame);
        flowPane.getChildren().add(tfMessage);
        flowPane.getChildren().add(btnSendMessage);
        paneMessage.getChildren().add(borderMessage);
        pane.getChildren().add(paneMessage);
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
        paneGame.getChildren().add(position1);
        paneGame.getChildren().add(position2);
        paneGame.getChildren().add(position3);
        paneGame.getChildren().add(position4);
        paneGame.getChildren().add(position5);
        paneGame.getChildren().add(position6);
        paneGame.getChildren().add(position7);
        paneGame.getChildren().add(position8);
        paneGame.getChildren().add(position9);
        pane0.getChildren().add(paneGame);
        pane.getChildren().add(pane0);
        pane.getChildren().add(btnClose);
        pane.getChildren().add(btnMin);
        pane.getChildren().add(btnExitGame);
        pane.getChildren().add(btnRecordeGame);

    }
}
