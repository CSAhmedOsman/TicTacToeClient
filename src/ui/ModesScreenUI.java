package ui;

import client.Client;
import utils.Util;
import client.ClientApp;
import com.google.gson.Gson;
import data.GameInfo;
import exception.NotConnectedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Animation;
import utils.Constants;

public class ModesScreenUI extends Pane {

    protected final Ellipse ellipse;
    protected final Ellipse ellipse0;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Text text;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Ellipse ellipse1;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Button btnWithPc;
    protected final Button btnOfline;
    protected final Button btnOnline;
    protected final Button btnGamesHistory;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final Button btnLogout;
    protected final ImageView imageView5;
    protected final Button btnClose;
    protected final DropShadow dropShadow3;
    protected final Button btnMin;
    protected final DropShadow dropShadow4;

    {
        ellipse = new Ellipse();
        ellipse0 = new Ellipse();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        text = new Text();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        ellipse1 = new Ellipse();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        btnWithPc = new Button();
        btnOfline = new Button();
        btnOnline = new Button();
        btnGamesHistory = new Button();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();
        btnLogout = new Button();
        imageView5 = new ImageView();
        btnClose = new Button();
        dropShadow3 = new DropShadow();
        btnMin = new Button();
        dropShadow4 = new DropShadow();

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
        rectangle.setHeight(144.0);
        rectangle.setLayoutX(635.0);
        rectangle.setLayoutY(469.0);
        rectangle.setOpacity(0.25);
        rectangle.setRotate(125.5);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(20.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        rectangle0.setHeight(144.0);
        rectangle0.setLayoutX(635.0);
        rectangle0.setLayoutY(469.0);
        rectangle0.setOpacity(0.24);
        rectangle0.setRotate(171.9);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(20.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#43115b"));
        text.setLayoutX(46.0);
        text.setLayoutY(153.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic");
        text.setWrappingWidth(155.5634754896164);
        text.setFont(new Font("Arial Rounded MT Bold", 96.0));

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
        ellipse1.setLayoutX(68.0);
        ellipse1.setLayoutY(586.0);
        ellipse1.setOpacity(0.25);
        ellipse1.setRadiusX(100.0);
        ellipse1.setRadiusY(80.0);
        ellipse1.setStroke(javafx.scene.paint.Color.valueOf("#f1aaaa"));
        ellipse1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        ellipse1.setStyle("-fx-blend-mode: CDC9C9;");

        text0.setFill(javafx.scene.paint.Color.valueOf("#f1eff2"));
        text0.setLayoutX(194.0);
        text0.setLayoutY(153.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("-T");
        text0.setFont(new Font("Arial Rounded MT Bold", 96.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#f8f6f8"));
        text1.setLayoutX(472.0);
        text1.setLayoutY(153.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("oe");
        text1.setFont(new Font("Arial Rounded MT Bold", 96.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#772ca6"));
        text2.setLayoutX(274.0);
        text2.setLayoutY(153.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("ac-T");
        text2.setFont(new Font("Arial Rounded MT Bold", 96.0));

        btnWithPc.setLayoutX(42.0);
        btnWithPc.setLayoutY(256.0);
        btnWithPc.setMnemonicParsing(false);
        btnWithPc.setPrefHeight(160.0);
        btnWithPc.setPrefWidth(181.0);
        btnWithPc.setStyle("-fx-background-radius: 30; -fx-background-color: #fff7f7;");
        btnWithPc.setText("VS");
        btnWithPc.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnWithPc.setFont(new Font("Arial Rounded MT Bold", 35.0));

        btnOfline.setLayoutX(260.0);
        btnOfline.setLayoutY(256.0);
        btnOfline.setMnemonicParsing(false);
        btnOfline.setPrefHeight(160.0);
        btnOfline.setPrefWidth(181.0);
        btnOfline.setStyle("-fx-background-radius: 30; -fx-background-color: #fff7f7;");
        btnOfline.setText("VS");
        btnOfline.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOfline.setFont(new Font("Arial Rounded MT Bold", 34.0));

        btnOnline.setLayoutX(472.0);
        btnOnline.setLayoutY(256.0);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(160.0);
        btnOnline.setPrefWidth(181.0);
        btnOnline.setStyle("-fx-background-radius: 30; -fx-background-color: #fff7f7;");
        btnOnline.setText("VS");
        btnOnline.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOnline.setFont(new Font("Arial Rounded MT Bold", 35.0));

        btnGamesHistory.setLayoutX(227.0);
        btnGamesHistory.setLayoutY(500.0);
        btnGamesHistory.setMnemonicParsing(false);
        btnGamesHistory.setPrefHeight(40.0);
        btnGamesHistory.setPrefWidth(249.0);
        btnGamesHistory.setStyle("-fx-background-radius: 100; -fx-background-color: #FD6D84;");
        btnGamesHistory.setText("Games History");
        btnGamesHistory.setTextFill(javafx.scene.paint.Color.WHITE);
        btnGamesHistory.setFont(new Font("Franklin Gothic Demi Cond", 33.0));
        btnGamesHistory.setCursor(Cursor.HAND);

        imageView.setFitHeight(60.0);
        imageView.setFitWidth(92.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(353.0);
        imageView.setImage(new Image(getClass().getResource("images/robot.png").toExternalForm()));

        imageView0.setFitHeight(60.0);
        imageView0.setFitWidth(64.0);
        imageView0.setLayoutX(274.0);
        imageView0.setLayoutY(264.0);
        imageView0.setImage(new Image(getClass().getResource("images/boy.jpg").toExternalForm()));

        imageView1.setFitHeight(60.0);
        imageView1.setFitWidth(64.0);
        imageView1.setLayoutX(46.0);
        imageView1.setLayoutY(256.0);
        imageView1.setImage(new Image(getClass().getResource("images/player.png").toExternalForm()));

        imageView2.setFitHeight(60.0);
        imageView2.setFitWidth(64.0);
        imageView2.setLayoutX(368.0);
        imageView2.setLayoutY(353.0);
        imageView2.setImage(new Image(getClass().getResource("images/girl.jpg").toExternalForm()));

        imageView3.setFitHeight(60.0);
        imageView3.setFitWidth(64.0);
        imageView3.setLayoutX(581.0);
        imageView3.setLayoutY(353.0);
        imageView3.setImage(new Image(getClass().getResource("images/world-grid.png").toExternalForm()));

        imageView4.setFitHeight(60.0);
        imageView4.setFitWidth(64.0);
        imageView4.setLayoutX(480.0);
        imageView4.setLayoutY(256.0);
        imageView4.setImage(new Image(getClass().getResource("images/player.png").toExternalForm()));

        btnLogout.setLayoutX(15.0);
        btnLogout.setLayoutY(11.0);
        btnLogout.setMnemonicParsing(false);
        btnLogout.setPrefHeight(40.0);
        btnLogout.setPrefWidth(55.0);
        btnLogout.setStyle("-fx-background-color: F1AAAA;");
        btnLogout.setTextFill(javafx.scene.paint.Color.valueOf("#f8baba"));

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setLayoutX(17.0);
        imageView5.setLayoutY(11.0);
        imageView5.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));

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

        getChildren().add(ellipse);
        getChildren().add(ellipse0);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(text);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(ellipse1);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(btnWithPc);
        getChildren().add(btnOfline);
        getChildren().add(btnOnline);
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView4);
        getChildren().add(btnLogout);
        getChildren().add(imageView5);
        getChildren().add(btnClose);
        getChildren().add(btnGamesHistory);
        getChildren().add(btnMin);

        //___________________My Work________________________
        addEventHandlers();

        Animation.setButtonHoverFunctionality(btnGamesHistory);
    }

    public ModesScreenUI(int playerId) {

    }

    public ModesScreenUI() {

    }

    protected void addEventHandlers() {
        btnClose.setOnAction((e) -> {
            Platform.exit();
        });

        btnMin.setOnAction((e) -> {
            //ClientApp.stage.setIconified(true);
            GameInfo info = new GameInfo("ahmed", "abdo", 8, 9,10,11);
            sendInvit(info,1);

        });

        btnOfline.setOnAction((e) -> {
            Parent localGame = new LocalGame();
            animateOut(localGame);
        });

        btnWithPc.setOnAction((e) -> {
            Parent selectGame = new SelectGameLevel();
            animateOut(selectGame);
        });

        btnOnline.setOnAction((e) -> {
            Util.showAlertDialog(Alert.AlertType.INFORMATION, "Future work", "Will be Added Soon.");
        });

        btnLogout.setOnAction((e) -> {
            Parent homeScreen = new LoginScreenUI();
            animateOut(homeScreen);
        });

        btnGamesHistory.setOnAction((event) -> {
            Parent homeScreen = new SelectRecord();
            animateOut(homeScreen);
        });
    }

    private void animateOut(Parent destination) {

        Animation.setAnimatedNodeOut(btnGamesHistory);
        Animation.setAnimatedNodeOut(btnClose);
        Animation.setAnimatedNodeOut(btnLogout);
        Animation.setAnimatedNodeOut(btnOfline);
        Animation.setAnimatedNodeOut(btnOnline);
        Animation.setAnimatedNodeOut(btnWithPc);

        Animation.setAnimatedRootOut(this, destination);

    }

    public static void sendInvit(GameInfo info,int type) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.SENDINVITE);
        jsonRequest.add(info);
        jsonRequest.add(type);
        System.out.println("sentInvite");
        String gsonRequest = gson.toJson(jsonRequest);
       
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Logger.getLogger(ModesScreenUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

   
}
