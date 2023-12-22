package ui;

import client.Client;
import com.google.gson.Gson;
import data.Player;
import java.util.ArrayList;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import utils.Constants;

public class HomeOnlineScreenUI extends AnchorPane {

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
    protected final Label label4;
    protected final DropShadow dropShadow10;
    protected final Button btnClose;
    protected final DropShadow dropShadow11;
    protected final Button btnMin;
    protected final DropShadow dropShadow12;

    // My Work
    private ListView<HBox> playerListView;
    private Client client;

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

        label4 = new Label();
        dropShadow10 = new DropShadow();
        btnClose = new Button();
        dropShadow11 = new DropShadow();
        btnMin = new Button();
        dropShadow12 = new DropShadow();
        playerListView = new ListView<>();
        playerListView.setPrefSize(400, 300);
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

        getChildren().add(scrollPane);
        getChildren().add(label4);
        getChildren().add(btnClose);
        getChildren().add(btnMin);
    }

    public HomeOnlineScreenUI() {

        client = new Client();
        client.connect();

        getAvaliablePlayers();
    }

    public HomeOnlineScreenUI(ArrayList<Player> onlinePlayer) {

        client = new Client();
        client.connect();

        getAvaliablePlayers();
        displayAvaliablePlayers(onlinePlayer);

    }

    private void getAvaliablePlayers() {
        Gson gson = new Gson();
        String gsonRequest = gson.toJson(Constants.GET_AVAILIABLE_PLAYERS);
        client.sendRequest(gsonRequest);
    }

    private void displayAvaliablePlayers(ArrayList<Player> onlinePlayers) {
        playerListView.getItems().clear();

        for (Player player : onlinePlayers) {
            HBox playerBox = new HBox();

            Rectangle rectangle = new Rectangle();
            rectangle.setArcHeight(5.0);
            rectangle.setArcWidth(5.0);
            rectangle.setFill(javafx.scene.paint.Color.valueOf("#9f56ff"));
            rectangle.setHeight(98.0);
            rectangle.setLayoutX(23.0);
            rectangle.setLayoutY(14.0);
            rectangle.setStroke(javafx.scene.paint.Color.BLACK);
            rectangle.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
            rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
            rectangle.setWidth(273.0);

            Label nameLabel = new Label();
            nameLabel.setPrefWidth(198.0);
            nameLabel.setLayoutX(101.0);
            nameLabel.setLayoutY(27.0);
            nameLabel.setText(player.getName());
            nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
            nameLabel.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

            Label scoreLabel = new Label();
            scoreLabel.setPrefWidth(50.0);
            scoreLabel.setLayoutX(101.0);
            scoreLabel.setLayoutY(51.0); // Adjust this value based on your layout
            scoreLabel.setText("Score: " + player.getScore());
            scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f4dfff"));
            scoreLabel.setFont(new Font("Franklin Gothic Demi Cond", 14.0));

            ImageView imageView = new ImageView();
            imageView.setFitHeight(64.0);
            imageView.setFitWidth(53.0);
            imageView.setLayoutX(37.0);
            imageView.setLayoutY(14.0); // Adjust this value based on your layout
            imageView.setImage(new Image(getClass().getResource("images/panda.png").toExternalForm()));

            Button requestButton = new Button("Request");
            requestButton.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
            requestButton.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
            requestButton.setFont(new Font("Gill Sans Ultra Bold Condensed", 10.0));
            requestButton.setCursor(Cursor.HAND);
            requestButton.setLayoutX(118.0);
            requestButton.setLayoutY(177.0);
            requestButton.setMnemonicParsing(false);
            requestButton.setPrefHeight(30.0);
            requestButton.setPrefWidth(122.0);

            playerBox.getChildren().addAll(rectangle, nameLabel, scoreLabel, imageView, requestButton);
            playerListView.getItems().add(playerBox);
        }
    }

}
