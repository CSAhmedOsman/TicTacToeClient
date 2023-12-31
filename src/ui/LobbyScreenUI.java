package ui;

import client.Client;
import client.ClientApp;
import com.google.gson.Gson;
import data.Player;
import exception.NotConnectedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import utils.Constants;
import utils.Util;

public class LobbyScreenUI extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Rectangle rectangle0;
    protected final Rectangle btnLogin;
    protected final Label label0;
    protected final DropShadow dropShadow0;
    protected final Button btnClose;
    protected final DropShadow dropShadow1;
    protected final Button btnMin;
    protected final DropShadow dropShadow2;
    protected final Button btnBack;
    protected final MenuButton menuButton;
    protected final MenuItem profile;
    protected final MenuItem unBlock;
    protected final ImageView imageView0;
    protected final Pane pane;
    protected final ImageView imageView;
    protected final Pane pane0;
    protected final BorderPane borderPane;
    protected final TextArea textArea;
    protected final FlowPane flowPane;
    protected final TextField tfMessage;
    protected final Button btnSend;
    protected final ListView<HBox> playerListView;
    int playerId;
    boolean isRunning;
    // private static ArrayList<Player> players;
    Thread thread;

    {

        isRunning = true;
        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        rectangle0 = new Rectangle();
        btnLogin = new Rectangle();
        label0 = new Label();
        dropShadow0 = new DropShadow();
        btnClose = new Button();
        dropShadow1 = new DropShadow();
        btnMin = new Button();
        dropShadow2 = new DropShadow();
        btnBack = new Button();
        menuButton = new MenuButton();
        profile = new MenuItem();
        unBlock = new MenuItem();
        imageView0 = new ImageView();
        pane = new Pane();
        imageView = new ImageView();
        pane0 = new Pane();
        borderPane = new BorderPane();
        textArea = new TextArea();
        flowPane = new FlowPane();
        tfMessage = new TextField();
        btnSend = new Button();

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
        rectangle.setLayoutX(0.0);
        rectangle.setLayoutY(0.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(700.0);

        label.setLayoutX(32.0);
        label.setLayoutY(87.0);
        label.setPrefHeight(153.0);
        label.setPrefWidth(285.0);
        label.setText("Tic-Tac-Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 64.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.91);
        label.setEffect(dropShadow);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle0.setHeight(188.0);
        rectangle0.setLayoutX(616.0);
        rectangle0.setLayoutY(-7.0);
        rectangle0.setOpacity(0.2);
        rectangle0.setRotate(-50.2);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(29.0);

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

        label0.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        label0.setLayoutX(129.0);
        label0.setLayoutY(25.0);
        label0.setLineSpacing(1.0);
        label0.setPrefHeight(95.0);
        label0.setPrefWidth(399.0);
        label0.setText("Select from available players");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label0.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        label0.setFont(new Font("Franklin Gothic Demi Cond", 35.0));

        dropShadow0.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow0.setSpread(0.91);
        label0.setEffect(dropShadow0);

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

        dropShadow1.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow1.setSpread(0.69);
        btnClose.setEffect(dropShadow1);

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

        dropShadow2.setColor(javafx.scene.paint.Color.valueOf("#fff7f7"));
        dropShadow2.setSpread(0.69);
        btnMin.setEffect(dropShadow2);

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

        menuButton.setLayoutX(60.0);
        menuButton.setLayoutY(10.0);
        menuButton.setMnemonicParsing(false);
        menuButton.setPrefHeight(42.0);
        menuButton.setPrefWidth(50.0);
        menuButton.setStyle("-fx-background-color: #ffbdbd;");
        menuButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffbdbd"));

        profile.setMnemonicParsing(false);
        profile.setText("Profile");

        unBlock.setMnemonicParsing(false);
        unBlock.setText("Un Block");

        imageView0.setFitHeight(31.0);
        imageView0.setFitWidth(24.0);
        imageView0.setImage(new Image(getClass().getResource("images/menu.png").toExternalForm()));
        menuButton.setGraphic(imageView0);

        pane0.setLayoutX(13.0);
        pane0.setLayoutY(200.0);
        pane0.setPrefHeight(384.0);
        textArea.setStyle("-fx-textColor: black; -fx-background-radius: 10;-fx-background-color: white");
        textArea.setDisable(true);

        borderPane.setPrefHeight(385.0);
        borderPane.setPrefWidth(300.0);

        borderPane.setCenter(textArea);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(49.0);
        flowPane.setPrefWidth(600.0);

        tfMessage.setPrefHeight(52.0);
        tfMessage.setPrefWidth(200.0);
        tfMessage.setStyle("-fx-background-radius: 10;");

        btnSend.setMnemonicParsing(false);
        btnSend.setPrefHeight(48.0);
        btnSend.setPrefWidth(96.0);
        btnSend.setStyle("-fx-background-color: #FD6D84; -fx-background-radius: 10;");
        btnSend.setText("Send");
        btnSend.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
        btnSend.setFont(new Font(23.0));
        borderPane.setBottom(flowPane);

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(rectangle0);
        getChildren().add(btnLogin);
        getChildren().add(label0);
        getChildren().add(btnClose);
        getChildren().add(btnMin);
        pane.getChildren().add(imageView);
        getChildren().add(btnBack);
        flowPane.getChildren().add(tfMessage);
        pane.getChildren().add(imageView0);
        menuButton.getItems().add(profile);
        menuButton.getItems().add(unBlock);
        pane.getChildren().add(menuButton);
        flowPane.getChildren().add(btnSend);
        pane0.getChildren().add(borderPane);
        getChildren().add(pane0);

        //______________My Work_______________
        ClientApp.curDisplayedScreen = this;
    }

    public LobbyScreenUI(int playerId) {
        this.playerId = playerId;
        playerListView = new ListView();
        playerListView.setLayoutX(320.0);
        playerListView.setLayoutY(111.0);
        playerListView.setPrefHeight(471.0);
        playerListView.setPrefWidth(355.0);
        playerListView.setStyle("-fx-background-color: #000; -fx-background-radius: 10;");

        getChildren().add(playerListView);

        thread = new Thread(() -> {
            while (isRunning) {
                try {
                    Platform.runLater(() -> {
                        getAvailablePlayers();
                    });
                    Thread.sleep(20000);
                    // Sleep for 10 seconds

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().stop();
                }
            }
        });
        thread.start();

        setListeners();
        //______________My Work_______________
        makePlayerOnline(playerId);

        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 18; -fx-font-type: 'bold';");
    }

    private void setListeners() {

        btnClose.setOnAction((ActionEvent event) -> {
            ClientApp.stage.close();
        });

        btnMin.setOnAction((ActionEvent event) -> {
            ClientApp.stage.setIconified(true);
        });
        btnBack.setOnAction((ActionEvent event) -> {
            Parent root = new ModesScreenUI();
            Util.displayScreen(root);
        });

        btnSend.setOnAction((ActionEvent event) -> {
            String broadcastMessage = tfMessage.getText();
            if (broadcastMessage.trim().isEmpty()) {
                return;
            }
            sendMessageToAll(playerId, broadcastMessage);
            tfMessage.clear();
        });
        profile.setOnAction((ActionEvent e) -> {
            Parent root = new UserProfileUI(playerId);
            Util.displayScreen(root);
            isRunning = false;
            //thread.stop();
        });
        unBlock.setOnAction((e) -> {
            Parent root = new UnBlockUI();
            Util.displayScreen(root);
        });
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

    private void blockPlayer(int playerId, int blockedId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.BLOCK_PLAYER);
        jsonRequest.add(playerId);
        jsonRequest.add(blockedId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
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
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void makePlayerOnline(int playerId) {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.ONLINE);
        jsonRequest.add(playerId);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void displayMessage(String srcPlayerName, String message) {
        textArea.appendText(srcPlayerName + ": " + message + "\n");
    }

    public void addFriend() {
        Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now Is your Friend");
    }

    public void removeFriend() {
        Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now Is Not your Friend");
    }

    public void blockPlayer() {
        Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Blocked Area", "Now In Block List");
    }

    public void unBlockPlayer() {
        Util.showAlertDialog(Alert.AlertType.CONFIRMATION, "Friends Area", "Now You Can Play With Him !");
    }

    private void getAvailablePlayers() {
        Gson gson = new Gson();
        ArrayList jsonRequest = new ArrayList();
        jsonRequest.add(Constants.GET_AVAILIABLE_PLAYERS);

        String gsonRequest = gson.toJson(jsonRequest);
        try {
            Client.getClient().sendRequest(gsonRequest);
        } catch (NotConnectedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void displayAvailablePlayers(ArrayList<Player> availablePlayers) {

        Platform.runLater(() -> {
            playerListView.getItems().clear();

            for (Player player : availablePlayers) {
                if (player.getId() == playerId) {
                    continue;
                }

                HBox playerBox = createPlayerBox(player);
                playerBox.setStyle("-fx-background-color: #a02cda; -fx-background-radius: 10;");
                playerListView.getItems().add(playerBox);
            }
            playerListView.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
        });
    }

    private HBox createPlayerBox(Player player) {
        HBox playerBox = new HBox();
        Label nameLabel = new Label();
        nameLabel.setPrefWidth(100.0);
        // nameLabel.setLayoutX(101.0);
        nameLabel.setLayoutY(27.0);
        nameLabel.setText(player.getName());
        nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        nameLabel.setFont(new Font("Franklin Gothic Demi Cond", 21.0));

        Label scoreLabel = new Label();
        scoreLabel.setPrefWidth(70.0);
        // scoreLabel.setLayoutX(50.0);
        scoreLabel.setLayoutY(51.0);
        scoreLabel.setText("Score:  " + (String.valueOf(player.getScore())));
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        scoreLabel.setFont(new Font("Franklin Gothic Demi Cond", 18.0));

        Button requestButton = new Button("Request");
        requestButton.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        requestButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        requestButton.setFont(new Font("Gill Sans Ultra Bold Condensed", 10.0));
        requestButton.setCursor(Cursor.HAND);
        requestButton.setLayoutX(50.0);
        requestButton.setLayoutY(177.0);
        requestButton.setMnemonicParsing(false);
        requestButton.setPrefHeight(30.0);
        requestButton.setPrefWidth(70.0);

        Button blockButton = new Button("Block");
        blockButton.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        blockButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        blockButton.setFont(new Font("Gill Sans Ultra Bold Condensed", 10.0));
        blockButton.setCursor(Cursor.HAND);
        blockButton.setLayoutX(100.0);
        blockButton.setLayoutY(177.0);
        blockButton.setMnemonicParsing(false);
        blockButton.setPrefHeight(30.0);
        blockButton.setPrefWidth(50.0);

        Button addFriendButton = new Button("Add");
        addFriendButton.setStyle("-fx-background-radius: 100; -fx-background-color: #EA93A3;");
        addFriendButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff"));
        addFriendButton.setFont(new Font("Gill Sans Ultra Bold Condensed", 10.0));
        addFriendButton.setCursor(Cursor.HAND);
        addFriendButton.setLayoutX(145.0);
        addFriendButton.setLayoutY(177.0);
        addFriendButton.setMnemonicParsing(false);
        addFriendButton.setPrefHeight(30.0);
        addFriendButton.setPrefWidth(50.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(60.0);
        imageView.setFitWidth(70.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(353.0);
        imageView.setImage(new Image(getClass().getResource("images/" + ((player.getId()) % 3) + ".png").toExternalForm()));

        requestButton.setOnAction((e) -> {
            Gson gson = new Gson();
            ArrayList<Object> jsonArr = new ArrayList<>();
            jsonArr.add(Constants.GET_PREV_SCORE);

            jsonArr.add(playerId);
            jsonArr.add(player.getId());

            String gsonRequest = gson.toJson(jsonArr);
            try {
                Client.getClient().sendRequest(gsonRequest);
                isRunning = false;
            } catch (NotConnectedException ex) {
                Logger.getLogger(LobbyScreenUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        HBox playerInfo = new HBox(nameLabel, scoreLabel);
        playerInfo.setAlignment(Pos.CENTER_LEFT);
        playerInfo.setSpacing(20);

        HBox buttons = new HBox(requestButton, addFriendButton, blockButton);
        buttons.setAlignment(Pos.CENTER_LEFT);
        buttons.setSpacing(10);

        VBox Data = new VBox(playerInfo, buttons);
        Data.setAlignment(Pos.CENTER_LEFT);
        //Data.setSpacing(10);

        playerBox.getChildren().addAll(imageView, Data);
        playerBox.setSpacing(20);

        return playerBox;
    }

    public void desplayMessage(String srcPlayerName, String message) {
        Platform.runLater(() -> {
            System.out.println("Desplay Message");
            Util.showAlertDialog(Alert.AlertType.CONFIRMATION, srcPlayerName, message);
        });
    }
}
