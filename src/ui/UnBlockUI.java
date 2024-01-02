package ui;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import data.Player;
import exception.NotConnectedException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import utils.Constants;
import utils.Util;

public class UnBlockUI extends BorderPane {

    protected final Pane pane;
    protected final Button btnClose;
    protected final DropShadow dropShadow;
    protected final Button btnMin;
    protected final Button btnBack;
    protected final DropShadow dropShadow0;
    protected final ImageView imageView;
    protected final ListView<HBox> blockList;
    protected final Label label;
    protected final DropShadow dropShadow1;
    int playerId;

    {

        pane = new Pane();
        btnClose = new Button();
        dropShadow = new DropShadow();
        btnMin = new Button();
        btnBack = new Button();
        dropShadow0 = new DropShadow();
        imageView = new ImageView();
        blockList = new ListView();
        label = new Label();
        dropShadow1 = new DropShadow();

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
        

        btnClose.setLayoutX(618.0);
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

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow.setSpread(0.69);
        btnClose.setEffect(dropShadow);

        btnMin.setLayoutX(546.0);
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

        btnBack.setLayoutX(14.0);
        btnBack.setLayoutY(12.0);
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

        dropShadow0.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow0.setSpread(0.69);
        btnMin.setEffect(dropShadow0);

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(40.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(18.0);
        imageView.setImage(new Image(getClass().getResource("images/back.png").toExternalForm()));

        blockList.setLayoutX(97.0);
        blockList.setLayoutY(153.0);
        blockList.setPrefHeight(424.0);
        blockList.setPrefWidth(461.0);
        blockList.setStyle("-fx-background-radius: 10;");

        label.setLayoutX(149.0);
        label.setLayoutY(41.0);
        label.setText("Block List");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 96.0));

        dropShadow1.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow1.setSpread(0.98);
        label.setEffect(dropShadow1);
        setCenter(pane);

        pane.getChildren().add(btnClose);
        pane.getChildren().add(btnMin);
        getChildren().add(btnBack);
        pane.getChildren().add(imageView);
        pane.getChildren().add(blockList);
        pane.getChildren().add(label);

        ClientApp.curDisplayedScreen = this;
    }

    public UnBlockUI(int playerId ) {
        this.playerId=playerId;
        Platform.runLater(() -> {
            getBlockPlayers();
        });
        setListeners();
    }

    private void setListeners() {

        btnClose.setOnAction((ActionEvent event) -> {
            ClientApp.stage.close();
        });

        btnMin.setOnAction((ActionEvent event) -> {
            ClientApp.stage.setIconified(true);
        });
         btnBack.setOnAction((ActionEvent event) -> {
            Parent root = new LobbyScreenUI(playerId);
            Util.displayScreen(root);
        });
    }

    private void unBlockPlayer(int playerId, int blockedId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.UN_BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(blockedId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "un Block Player Error", "Error While connecting to server");
        }
    }

    public void unBlockPlayer() {
        Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now You Can Play With Him !");
    }

    private void getBlockPlayers() {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BLOCKLIST);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "get Blocked Players Error", "Error While connecting to server");
        }
    }

    public void displayBlockPlayers(ArrayList<Player> availablePlayers) {

        Platform.runLater(() -> {
            blockList.getItems().clear();

            for (Player player : availablePlayers) {
                if (player.getId() == playerId) {
                    continue;
                }

                HBox playerBox = createPlayerBox(player);
                playerBox.setStyle("-fx-background-color: #a02cda; -fx-background-radius: 10;");
                blockList.getItems().add(playerBox);
            }
            blockList.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
        });
    }

    private HBox createPlayerBox(Player player) {
        HBox playerBox = new HBox();
        Label nameLabel = new Label();
        nameLabel.setPrefWidth(100.0);
        nameLabel.setLayoutY(27.0);
        nameLabel.setText(player.getName());
        nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        nameLabel.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        Label scoreLabel = new Label();
        scoreLabel.setPrefWidth(70.0);
        scoreLabel.setLayoutY(51.0);
        scoreLabel.setText("Score:  " + (String.valueOf(player.getScore())));
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        scoreLabel.setFont(new Font("Franklin Gothic Demi Cond", 18.0));

        Button unBlockButton = new Button("UnBlock");
        unBlockButton.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        unBlockButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        unBlockButton.setFont(new Font("Gill Sans Ultra Bold Condensed", 10.0));
        unBlockButton.setCursor(Cursor.HAND);
        unBlockButton.setLayoutX(100.0);
        unBlockButton.setLayoutY(177.0);
        unBlockButton.setMnemonicParsing(false);
        unBlockButton.setPrefHeight(30.0);
        unBlockButton.setPrefWidth(70.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(60.0);
        imageView.setFitWidth(70.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(353.0);
        imageView.setImage(new Image(getClass().getResource("images/" + ((player.getId()) % 3) + ".png").toExternalForm()));

        unBlockButton.setOnAction((e) -> {
            unBlockPlayer(playerId, player.getId());
        });

        HBox playerInfo = new HBox(nameLabel, scoreLabel, unBlockButton);
        playerInfo.setAlignment(Pos.CENTER_LEFT);
        playerInfo.setSpacing(20);

        playerBox.getChildren().addAll(imageView, playerInfo);
        playerBox.setSpacing(20);

        return playerBox;
    }
}
