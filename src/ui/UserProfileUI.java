package ui;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import data.Player;
import exception.NotConnectedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Constants;
import utils.Util;

public class UserProfileUI extends BorderPane {

    protected final Pane pane;
    protected final Label userName;
    protected final DropShadow dropShadow;
    protected final Button btnClose;
    protected final DropShadow dropShadow0;
    protected final Button btnMin;
    protected final DropShadow dropShadow1;
    protected final Rectangle rectangle;
    protected final Button btnBack;
    protected final Pane pane0;
    protected final ImageView imageView;
    protected final Circle circle;
    protected final ImageView imageView0;
    //protected final Button btnEdit;
    protected final DropShadow dropShadow2;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final TextField password;
    protected final TextField email;
    protected final TextField name;
    Player player;

    {
        pane = new Pane();
        userName = new Label();
        dropShadow = new DropShadow();
        btnClose = new Button();
        dropShadow0 = new DropShadow();
        btnMin = new Button();
        dropShadow1 = new DropShadow();
        rectangle = new Rectangle();
        btnBack = new Button();
        pane0 = new Pane();
        imageView = new ImageView();
        circle = new Circle();
        imageView0 = new ImageView();
        //btnEdit = new Button();
        dropShadow2 = new DropShadow();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        password = new TextField();
        email = new TextField();
        name = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(600.0);
        pane.setPrefWidth(700.0);
        pane.setStyle("-fx-background-color: #ffbdbd;");

        userName.setLayoutX(254.0);
        userName.setLayoutY(157.0);
        userName.setPrefHeight(54.0);
        userName.setPrefWidth(172.0);
        userName.setText("User Name");

        userName.setTextFill(javafx.scene.paint.Color.valueOf("#3c0d54"));
        userName.setFont(new Font("Franklin Gothic Demi Cond", 40.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.98);
        userName.setEffect(dropShadow);

        btnClose.setLayoutX(615.0);
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

        btnMin.setLayoutX(534.0);
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

        rectangle.setArcHeight(300.0);
        rectangle.setArcWidth(300.0);
        rectangle.setHeight(536.0);
        rectangle.setLayoutY(223.0);
        rectangle.setOpacity(0.17);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-border-radius: 20;");
        rectangle.setWidth(700.0);

        btnBack.setLayoutX(14.0);
        btnBack.setLayoutY(18.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(45.0);
        btnBack.setPrefWidth(51.0);
        btnBack.setStyle("-fx-background-color: #ffbdbd;");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#da0a0a"));

        pane0.setPrefHeight(45.0);
        pane0.setPrefWidth(51.0);

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(40.0);
        imageView.setLayoutX(1.0);
        imageView.setLayoutY(-4.0);
        imageView.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));
        btnBack.setGraphic(pane0);

        circle.setFill(javafx.scene.paint.Color.WHITE);
        circle.setLayoutX(329.0);
        circle.setLayoutY(90.0);
        circle.setRadius(67.0);
        circle.setStroke(javafx.scene.paint.Color.WHITE);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        imageView0.setFitHeight(89.0);
        imageView0.setFitWidth(102.0);
        imageView0.setLayoutX(279.0);
        imageView0.setLayoutY(46.0);
        imageView0.setImage(new Image(getClass().getResource("images/boy.jpg").toExternalForm()));

        /*btnEdit.setLayoutX(279.0);
        btnEdit.setLayoutY(524.0);
        btnEdit.setMnemonicParsing(false);
        btnEdit.setPrefHeight(49.0);
        btnEdit.setPrefWidth(100.0);
        btnEdit.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnEdit.setText("Edit");
        btnEdit.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnEdit.setTextFill(javafx.scene.paint.Color.WHITE);

        dropShadow2.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow2.setSpread(0.25);
        btnEdit.setEffect(dropShadow2);
        btnEdit.setFont(new Font("Arial Rounded MT Bold", 14.0));
        btnEdit.setCursor(Cursor.HAND);*/

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(95.0);
        text.setLayoutY(306.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Name");
        text.setFont(new Font("Franklin Gothic Demi Cond", 30.0));

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(95.0);
        text0.setLayoutY(387.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Email");
        text0.setFont(new Font("Franklin Gothic Demi Cond", 30.0));

        text1.setFill(javafx.scene.paint.Color.WHITE);
        text1.setLayoutX(65.0);
        text1.setLayoutY(456.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Password");
        text1.setFont(new Font("Franklin Gothic Demi Cond", 30.0));

        password.setLayoutX(184.0);
        password.setLayoutY(424.0);
        password.setOpacity(1.0);
        password.setPrefHeight(43.0);
        password.setPrefWidth(270.0);
        password.setDisable(true);
        password.setStyle("-fx-background-radius: 50; -fx-background-color: white;");

        email.setLayoutX(184.0);
        email.setLayoutY(356.0);
        email.setOpacity(1.0);
        email.setPrefHeight(43.0);
        email.setPrefWidth(270.0);
        email.setStyle("-fx-background-radius: 50; -fx-background-color: white;");
        email.setDisable(true);
        
        name.setLayoutX(184.0);
        name.setLayoutY(279.0);
        name.setOpacity(1.0);
        name.setPrefHeight(43.0);
        name.setPrefWidth(270.0);
        name.setStyle("-fx-background-radius: 50; -fx-background-color: white;");
        name.setDisable(true);
        setTop(pane);

        pane.getChildren().add(userName);
        pane.getChildren().add(btnClose);
        pane.getChildren().add(btnMin);
        pane.getChildren().add(rectangle);
        pane0.getChildren().add(imageView);
        pane.getChildren().add(btnBack);
        pane.getChildren().add(circle);
        pane.getChildren().add(imageView0);
        //pane.getChildren().add(btnEdit);
        pane.getChildren().add(text);
        pane.getChildren().add(text0);
        pane.getChildren().add(text1);
        pane.getChildren().add(password);
        pane.getChildren().add(email);
        pane.getChildren().add(name);

    }

    public UserProfileUI(int playerId) {
        ClientApp.currentScreen = this;
        player = new Player(playerId, null, 0);
        getData();
        setListeners();
        System.out.println("User Profile UI");
    }

    private void getData() {

        Gson gson = new Gson();
        ArrayList<Object> jsonArr = new ArrayList<>();
        jsonArr.add(Constants.SETDATAOFPLAYER);
        jsonArr.add(player.getId());

        String gsonRequest = gson.toJson(jsonArr);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void setData(Player p) {
        System.out.println(p.getName() + " " + p.getEmail() + " " + p.getPassword());
        player.setName(p.getName());
        player.setEmail(p.getEmail());
        player.setPassword(p.getPassword());
        name.setText(p.getName());
        email.setText(p.getEmail());
        password.setText(p.getPassword());
    }

    private void setListeners() {

        btnClose.setOnAction((ActionEvent event) -> {
            ClientApp.stage.close();
        });

        btnMin.setOnAction((ActionEvent event) -> {
            ClientApp.stage.setIconified(true);
        });
        btnBack.setOnAction((ActionEvent event) -> {
            Parent root = new LobbyScreenUI(player.getId());
            Util.displayScreen(root);
        });

        /*btnEdit.setOnAction((e) -> {
            Gson gson = new Gson();
            ArrayList<Object> jsonArr = new ArrayList<>();
            jsonArr.add(Constants.UPDATEUSERPROFILE);
            player.setName(name.getText());
            player.setEmail(email.getText());
            player.setPassword(password.getText());
            jsonArr.add(player);

            String gsonRequest = gson.toJson(jsonArr);
            try {
                Client.getClient().sendRequest(gsonRequest);
            } catch (NotConnectedException ex) {
                Logger.getLogger(LobbyScreenUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });*/

    }

}
