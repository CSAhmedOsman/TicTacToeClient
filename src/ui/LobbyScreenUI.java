package ui;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import exception.NotConnectedException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import utils.Constants;
import utils.Util;

public class LobbyScreenUI extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Circle circle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle btnLogin;
    protected final Circle circle0;
    protected final Button btnOffLine;
    protected final DropShadow dropShadow0;
    protected final ScrollPane scrollPane;
    protected final DropShadow dropShadow1;
    protected final AnchorPane anchorPane;
    protected final Rectangle rectangle3;
    protected final DropShadow dropShadow2;
    protected final Label label0;
    protected final Button btnOffLine1;
    protected final DropShadow dropShadow3;
    protected final Rectangle rectangle4;
    protected final DropShadow dropShadow4;
    protected final Label label1;
    protected final Rectangle rectangle5;
    protected final DropShadow dropShadow5;
    protected final Label label2;
    protected final Rectangle rectangle6;
    protected final DropShadow dropShadow6;
    protected final Label label3;
    protected final Button btnOffLine11;
    protected final DropShadow dropShadow7;
    protected final Button btnOffLine111;
    protected final DropShadow dropShadow8;
    protected final Button btnOffLine112;
    protected final DropShadow dropShadow9;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final Label label4;
    protected final DropShadow dropShadow10;
    protected final Button btnClose;
    protected final DropShadow dropShadow11;
    protected final Button btnMin;
    protected final DropShadow dropShadow12;
    
    {
        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        circle = new Circle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        btnLogin = new Rectangle();
        circle0 = new Circle();
        btnOffLine = new Button();
        dropShadow0 = new DropShadow();
        scrollPane = new ScrollPane();
        dropShadow1 = new DropShadow();
        anchorPane = new AnchorPane();
        rectangle3 = new Rectangle();
        dropShadow2 = new DropShadow();
        label0 = new Label();
        btnOffLine1 = new Button();
        dropShadow3 = new DropShadow();
        rectangle4 = new Rectangle();
        dropShadow4 = new DropShadow();
        label1 = new Label();
        rectangle5 = new Rectangle();
        dropShadow5 = new DropShadow();
        label2 = new Label();
        rectangle6 = new Rectangle();
        dropShadow6 = new DropShadow();
        label3 = new Label();
        btnOffLine11 = new Button();
        dropShadow7 = new DropShadow();
        btnOffLine111 = new Button();
        dropShadow8 = new DropShadow();
        btnOffLine112 = new Button();
        dropShadow9 = new DropShadow();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        label4 = new Label();
        dropShadow10 = new DropShadow();
        btnClose = new Button();
        dropShadow11 = new DropShadow();
        btnMin = new Button();
        dropShadow12 = new DropShadow();

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
        rectangle.setLayoutX(-22.0);
        rectangle.setLayoutY(-21.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(708.0);

        label.setLayoutX(33.0);
        label.setLayoutY(101.0);
        label.setPrefHeight(244.0);
        label.setPrefWidth(285.0);
        label.setText("Tic-Tac-Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 64.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.91);
        label.setEffect(dropShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(53.0);
        circle.setLayoutY(72.0);
        circle.setOpacity(0.2);
        circle.setRadius(111.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

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
        rectangle2.setLayoutX(616.0);
        rectangle2.setLayoutY(-7.0);
        rectangle2.setOpacity(0.2);
        rectangle2.setRotate(-50.2);
        rectangle2.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(29.0);

        btnLogin.setArcHeight(5.0);
        btnLogin.setArcWidth(5.0);
        btnLogin.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        btnLogin.setHeight(188.0);
        btnLogin.setLayoutX(616.0);
        btnLogin.setLayoutY(-7.0);
        btnLogin.setOpacity(0.2);
        btnLogin.setRotate(-138.0);
        btnLogin.setStroke(javafx.scene.paint.Color.BLACK);
        btnLogin.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        btnLogin.setWidth(29.0);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(662.0);
        circle0.setLayoutY(548.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(71.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        btnOffLine.setLayoutX(62.0);
        btnOffLine.setLayoutY(402.0);
        btnOffLine.setMnemonicParsing(false);
        btnOffLine.setPrefHeight(75.0);
        btnOffLine.setPrefWidth(204.0);
        btnOffLine.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine.setText("Back");
        btnOffLine.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine.setFont(new Font("Gill Sans Ultra Bold Condensed", 39.0));
        btnOffLine.setCursor(Cursor.HAND);

        dropShadow0.setHeight(35.83);
        dropShadow0.setRadius(17.415);
        dropShadow0.setWidth(35.83);
        btnOffLine.setEffect(dropShadow0);

        scrollPane.setLayoutX(351.0);
        scrollPane.setLayoutY(141.0);
        scrollPane.setPrefHeight(407.0);
        scrollPane.setPrefWidth(322.0);
        scrollPane.setStyle("-fx-background-color: #43115b;");

        scrollPane.setEffect(dropShadow1);

        anchorPane.setPrefHeight(506.0);
        anchorPane.setPrefWidth(320.0);
        anchorPane.setStyle("-fx-background-color: #43115b;");

        rectangle3.setArcHeight(5.0);
        rectangle3.setArcWidth(5.0);
        rectangle3.setFill(javafx.scene.paint.Color.valueOf("#9f56ff"));
        rectangle3.setHeight(98.0);
        rectangle3.setLayoutX(24.0);
        rectangle3.setLayoutY(14.0);
        rectangle3.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle3.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle3.setWidth(273.0);

        rectangle3.setEffect(dropShadow2);

        label0.setLayoutX(102.0);
        label0.setLayoutY(27.0);
        label0.setPrefWidth(198.0);
        label0.setText("Abdelrhman Mamdouh");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
        label0.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        btnOffLine1.setLayoutX(125.0);
        btnOffLine1.setLayoutY(66.0);
        btnOffLine1.setMnemonicParsing(false);
        btnOffLine1.setPrefHeight(30.0);
        btnOffLine1.setPrefWidth(122.0);
        btnOffLine1.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine1.setText("Request");
        btnOffLine1.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine1.setFont(new Font("Gill Sans Ultra Bold Condensed", 14.0));
        btnOffLine1.setCursor(Cursor.HAND);

        dropShadow3.setHeight(35.83);
        dropShadow3.setRadius(17.415);
        dropShadow3.setWidth(35.83);
        btnOffLine1.setEffect(dropShadow3);

        rectangle4.setArcHeight(5.0);
        rectangle4.setArcWidth(5.0);
        rectangle4.setFill(javafx.scene.paint.Color.valueOf("#9f56ff"));
        rectangle4.setHeight(98.0);
        rectangle4.setLayoutX(23.0);
        rectangle4.setLayoutY(130.0);
        rectangle4.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle4.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle4.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle4.setWidth(273.0);

        rectangle4.setEffect(dropShadow4);

        label1.setLayoutX(101.0);
        label1.setLayoutY(143.0);
        label1.setPrefWidth(198.0);
        label1.setText("Ahmed Osman");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
        label1.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        rectangle5.setArcHeight(5.0);
        rectangle5.setArcWidth(5.0);
        rectangle5.setFill(javafx.scene.paint.Color.valueOf("#9f56ff"));
        rectangle5.setHeight(98.0);
        rectangle5.setLayoutX(22.0);
        rectangle5.setLayoutY(245.0);
        rectangle5.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle5.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle5.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle5.setWidth(273.0);

        rectangle5.setEffect(dropShadow5);

        label2.setLayoutX(102.0);
        label2.setLayoutY(265.0);
        label2.setPrefWidth(198.0);
        label2.setText("Elham");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
        label2.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        rectangle6.setArcHeight(5.0);
        rectangle6.setArcWidth(5.0);
        rectangle6.setFill(javafx.scene.paint.Color.valueOf("#9f56ff"));
        rectangle6.setHeight(98.0);
        rectangle6.setLayoutX(23.0);
        rectangle6.setLayoutY(356.0);
        rectangle6.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle6.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle6.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle6.setWidth(273.0);

        rectangle6.setEffect(dropShadow6);

        label3.setLayoutX(101.0);
        label3.setLayoutY(369.0);
        label3.setPrefWidth(198.0);
        label3.setText("Abdelhmed");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
        label3.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        btnOffLine11.setLayoutX(118.0);
        btnOffLine11.setLayoutY(177.0);
        btnOffLine11.setMnemonicParsing(false);
        btnOffLine11.setPrefHeight(30.0);
        btnOffLine11.setPrefWidth(122.0);
        btnOffLine11.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine11.setText("Request");
        btnOffLine11.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine11.setFont(new Font("Gill Sans Ultra Bold Condensed", 14.0));
        btnOffLine11.setCursor(Cursor.HAND);

        dropShadow7.setHeight(35.83);
        dropShadow7.setRadius(17.415);
        dropShadow7.setWidth(35.83);
        btnOffLine11.setEffect(dropShadow7);

        btnOffLine111.setLayoutX(111.0);
        btnOffLine111.setLayoutY(294.0);
        btnOffLine111.setMnemonicParsing(false);
        btnOffLine111.setPrefHeight(30.0);
        btnOffLine111.setPrefWidth(122.0);
        btnOffLine111.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine111.setText("Request");
        btnOffLine111.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine111.setFont(new Font("Gill Sans Ultra Bold Condensed", 14.0));
        btnOffLine111.setCursor(Cursor.HAND);

        dropShadow8.setHeight(35.83);
        dropShadow8.setRadius(17.415);
        dropShadow8.setWidth(35.83);
        btnOffLine111.setEffect(dropShadow8);

        btnOffLine112.setLayoutX(111.0);
        btnOffLine112.setLayoutY(402.0);
        btnOffLine112.setMnemonicParsing(false);
        btnOffLine112.setPrefHeight(30.0);
        btnOffLine112.setPrefWidth(122.0);
        btnOffLine112.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        btnOffLine112.setText("Request");
        btnOffLine112.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOffLine112.setFont(new Font("Gill Sans Ultra Bold Condensed", 14.0));
        btnOffLine112.setCursor(Cursor.HAND);

        dropShadow9.setHeight(35.83);
        dropShadow9.setRadius(17.415);
        dropShadow9.setWidth(35.83);
        btnOffLine112.setEffect(dropShadow9);

        imageView.setFitHeight(63.0);
        imageView.setFitWidth(57.0);
        imageView.setLayoutX(35.0);
        imageView.setLayoutY(26.0);
        imageView.setImage(new Image(getClass().getResource("images/bear.png").toExternalForm()));

        imageView0.setFitHeight(64.0);
        imageView0.setFitWidth(53.0);
        imageView0.setLayoutX(37.0);
        imageView0.setLayoutY(145.0);
        imageView0.setImage(new Image(getClass().getResource("images/panda.png").toExternalForm()));

        imageView1.setFitHeight(68.0);
        imageView1.setFitWidth(63.0);
        imageView1.setLayoutX(33.0);
        imageView1.setLayoutY(255.0);
        imageView1.setImage(new Image(getClass().getResource("images/dog.png").toExternalForm()));

        imageView2.setFitHeight(60.0);
        imageView2.setFitWidth(63.0);
        imageView2.setLayoutX(32.0);
        imageView2.setLayoutY(372.0);
        imageView2.setImage(new Image(getClass().getResource("images/bear.png").toExternalForm()));
        scrollPane.setContent(anchorPane);

        label4.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label4.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label4.setLayoutX(92.0);
        label4.setLayoutY(7.0);
        label4.setLineSpacing(1.0);
        label4.setPrefHeight(170.0);
        label4.setPrefWidth(594.0);
        label4.setText("Select from available players");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label4.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        label4.setFont(new Font("Franklin Gothic Demi Cond", 35.0));

        dropShadow10.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow10.setSpread(0.91);
        label4.setEffect(dropShadow10);

        btnClose.setLayoutX(626.0);
        btnClose.setLayoutY(14.0);
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

        dropShadow11.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow11.setSpread(0.69);
        btnClose.setEffect(dropShadow11);

        btnMin.setLayoutX(557.0);
        btnMin.setLayoutY(14.0);
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

        dropShadow12.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow12.setSpread(0.69);
        btnMin.setEffect(dropShadow12);

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(circle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(btnLogin);
        getChildren().add(circle0);
        getChildren().add(btnOffLine);
        anchorPane.getChildren().add(rectangle3);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(btnOffLine1);
        anchorPane.getChildren().add(rectangle4);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(rectangle5);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(rectangle6);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(btnOffLine11);
        anchorPane.getChildren().add(btnOffLine111);
        anchorPane.getChildren().add(btnOffLine112);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(imageView1);
        anchorPane.getChildren().add(imageView2);
        getChildren().add(scrollPane);
        getChildren().add(label4);
        getChildren().add(btnClose);
        getChildren().add(btnMin);

        //______________My Work_______________
        
        ClientApp.currentScreen = this;
        
        sendMessageToAll(1, "BroadCast Message To All Players");
        
        
        blockPlayer(6, 8);
        blockPlayer(6, 7);
        unBlockPlayer(6, 8);
        unBlockPlayer(6, 7);
    }
    
    public LobbyScreenUI(int playerId) {
    }

    private void sendMessageToAll(int sourceId, String broadcastMessage) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BROADCAST_MESSAGE);
        jsonRequest.add(sourceId);
        jsonRequest.add(broadcastMessage);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void addFriend(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.ADD_FRIEND);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);
        
        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void removeFriend(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.REMOVE_FRIEND);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);
        
        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void blockPlayer(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);
        
        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void unBlockPlayer(int playerId, int friendId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.UN_BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(friendId);
        
        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void desplayMessage(String srcPlayerName, String message) {
        Platform.runLater(() -> {
            Util.showAlertDialog(Alert.AlertType.CONFIRMATION, srcPlayerName, message);
        });
    }
    
    public void addFriend() {
        Platform.runLater(()-> {
                Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now Is your Friend");
        });
    }
    
    public void removeFriend() {
        Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now Is Not your Friend");
        });
    }
    
    public void blockPlayer() {
        Platform.runLater(()-> {
                Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Blocked Area", "Now In Block List");
        });
    }
    
    public void unBlockPlayer() {
        Platform.runLater(() -> {
                Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now You Can Play With Him !");
        });
    }
}
