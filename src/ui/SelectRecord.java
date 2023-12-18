package ui;

import client.ClientApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Util;

public class SelectRecord extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Label label;
    protected final DropShadow dropShadow;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Rectangle btnLogin;
    protected final Circle circle;
    private ListView<Button> recordsListView;
    protected final DropShadow dropShadow0;
    protected final Button back;
    protected final Button btnBack;
    protected final Pane pane;
    protected final ImageView imageView;
    protected final Label label0;
    protected final DropShadow dropShadow1;
    protected final Rectangle backgroundGame;
    protected final DropShadow dropShadow2;
    protected final Rectangle backgroundPosition;
    protected final DropShadow dropShadow3;
    protected final Button btnPosition1;
    protected final DropShadow dropShadow4;
    protected final Button btnPosition2;
    protected final DropShadow dropShadow5;
    protected final Button btnPosition3;
    protected final DropShadow dropShadow6;
    protected final Button btnPosition4;
    protected final DropShadow dropShadow7;
    protected final Button btnPosition5;
    protected final DropShadow dropShadow8;
    protected final Button btnPosition6;
    protected final DropShadow dropShadow9;
    protected final Button btnPosition7;
    protected final DropShadow dropShadow10;
    protected final Button btnPosition8;
    protected final DropShadow dropShadow11;
    protected final Button btnPosition9;
    protected final DropShadow dropShadow12;
    protected final Button btnClose;
    protected final DropShadow dropShadow13;
    protected final Button btnMin;
    protected final DropShadow dropShadow14;
    protected final Circle circle0;
    protected final Label lableTurnPlayer;
    protected final DropShadow dropShadow15;
    private boolean playerXTurn = true;
    private int playerXScore = 0;
    private int playerOScore = 0;
    private StringBuilder movesRecord = new StringBuilder();
    private int gameCounter = 1;
    private List<Button> gameRecords = new ArrayList<>(); // List to store game records
    private int currentMoveIndex = 0;
    private Timeline timeline;
    final long numberOfSeconds = 1L;
    private Button[][] buttons = new Button[3][3];
    private Thread simulationThread;

    public SelectRecord() {

        rectangle = new Rectangle();
        label = new Label();
        dropShadow = new DropShadow();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        btnLogin = new Rectangle();
        circle = new Circle();
        recordsListView = new ListView<>();
        dropShadow0 = new DropShadow();
        back = new Button();
        btnBack = new Button();
        pane = new Pane();
        imageView = new ImageView();
        label0 = new Label();
        dropShadow1 = new DropShadow();
        backgroundGame = new Rectangle();
        dropShadow2 = new DropShadow();
        backgroundPosition = new Rectangle();
        dropShadow3 = new DropShadow();
        btnPosition1 = new Button();
        dropShadow4 = new DropShadow();
        btnPosition2 = new Button();
        dropShadow5 = new DropShadow();
        btnPosition3 = new Button();
        dropShadow6 = new DropShadow();
        btnPosition4 = new Button();
        dropShadow7 = new DropShadow();
        btnPosition5 = new Button();
        dropShadow8 = new DropShadow();
        btnPosition6 = new Button();
        dropShadow9 = new DropShadow();
        btnPosition7 = new Button();
        dropShadow10 = new DropShadow();
        btnPosition8 = new Button();
        dropShadow11 = new DropShadow();
        btnPosition9 = new Button();
        dropShadow12 = new DropShadow();
        btnClose = new Button();
        dropShadow13 = new DropShadow();
        btnMin = new Button();
        dropShadow14 = new DropShadow();
        circle0 = new Circle();
        lableTurnPlayer = new Label();
        dropShadow15 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(700.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#f8baba"));
        rectangle.setHeight(607.0);
        rectangle.setLayoutX(-4.0);
        rectangle.setLayoutY(-3.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(708.0);

        label.setLayoutX(216.0);
        label.setLayoutY(7.0);
        label.setPrefHeight(86.0);
        label.setPrefWidth(269.0);
        label.setText("Tic-Tac-Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label.setFont(new Font("Franklin Gothic Demi Cond", 60.0));

        dropShadow.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow.setSpread(0.91);
        label.setEffect(dropShadow);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#141414"));
        rectangle0.setHeight(188.0);
        rectangle0.setLayoutX(66.0);
        rectangle0.setLayoutY(494.0);
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

        circle.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle.setLayoutX(676.0);
        circle.setLayoutY(600.0);
        circle.setOpacity(0.2);
        circle.setRadius(71.0);
        circle.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        recordsListView.setLayoutX(379.0);
        recordsListView.setLayoutY(155.0);
        recordsListView.setOpacity(0.68);
        recordsListView.setPrefHeight(415.0);
        recordsListView.setPrefWidth(300.0);
        recordsListView.setStyle("-fx-font-size: 24; -fx-background-radius: 30; -fx-background-color: #43115b;");

        dropShadow0.setColor(Color.valueOf("#757575"));
        dropShadow0.setSpread(0.82);
        recordsListView.setEffect(dropShadow0);

        back.setLayoutX(21.0);
        back.setLayoutY(16.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(49.0);
        back.setPrefWidth(64.0);
        back.setStyle("-fx-background-color: f8baba;");
        back.setTextFill(javafx.scene.paint.Color.valueOf("#f8baba"));

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

        label0.setLayoutX(426.0);
        label0.setLayoutY(93.0);
        label0.setPrefHeight(58.0);
        label0.setPrefWidth(207.0);
        label0.setText("Game Records");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        label0.setFont(new Font("Franklin Gothic Demi Cond", 36.0));

        dropShadow1.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow1.setSpread(0.91);
        label0.setEffect(dropShadow1);

        backgroundGame.setArcHeight(25.0);
        backgroundGame.setArcWidth(25.0);
        backgroundGame.setFill(javafx.scene.paint.Color.valueOf("#ca4b62"));
        backgroundGame.setHeight(415.0);
        backgroundGame.setLayoutX(20.0);
        backgroundGame.setLayoutY(158.0);
        backgroundGame.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundGame.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundGame.setStrokeWidth(0.0);
        backgroundGame.setWidth(327.0);

        dropShadow2.setColor(javafx.scene.paint.Color.WHITE);
        dropShadow2.setSpread(0.33);
        backgroundGame.setEffect(dropShadow2);

        backgroundPosition.setArcHeight(20.0);
        backgroundPosition.setArcWidth(20.0);
        backgroundPosition.setFill(javafx.scene.paint.Color.valueOf("#e4e4e4"));
        backgroundPosition.setHeight(300.0);
        backgroundPosition.setLayoutX(33.0);
        backgroundPosition.setLayoutY(259.0);
        backgroundPosition.setStroke(javafx.scene.paint.Color.BLACK);
        backgroundPosition.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        backgroundPosition.setStrokeWidth(0.0);
        backgroundPosition.setWidth(300.0);

        backgroundPosition.setEffect(dropShadow3);

        btnPosition1.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition1.setLayoutX(40.0);
        btnPosition1.setLayoutY(266.0);
        btnPosition1.setMnemonicParsing(false);
        btnPosition1.setPrefHeight(85.0);
        btnPosition1.setPrefWidth(85.0);
        btnPosition1.setStyle("-fx-background-radius: 10;");
        btnPosition1.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition1.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition1.setCursor(Cursor.HAND);

        btnPosition1.setEffect(dropShadow4);

        btnPosition2.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition2.setLayoutX(141.0);
        btnPosition2.setLayoutY(266.0);
        btnPosition2.setMnemonicParsing(false);
        btnPosition2.setPrefHeight(85.0);
        btnPosition2.setPrefWidth(85.0);
        btnPosition2.setStyle("-fx-background-radius: 10;");
        btnPosition2.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition2.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition2.setCursor(Cursor.HAND);

        btnPosition2.setEffect(dropShadow5);

        btnPosition3.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition3.setLayoutX(241.0);
        btnPosition3.setLayoutY(266.0);
        btnPosition3.setMnemonicParsing(false);
        btnPosition3.setPrefHeight(85.0);
        btnPosition3.setPrefWidth(85.0);
        btnPosition3.setStyle("-fx-background-radius: 10;");
        btnPosition3.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition3.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition3.setCursor(Cursor.HAND);

        btnPosition3.setEffect(dropShadow6);

        btnPosition4.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition4.setLayoutX(40.0);
        btnPosition4.setLayoutY(367.0);
        btnPosition4.setMnemonicParsing(false);
        btnPosition4.setPrefHeight(85.0);
        btnPosition4.setPrefWidth(85.0);
        btnPosition4.setStyle("-fx-background-radius: 10;");
        btnPosition4.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition4.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition4.setCursor(Cursor.HAND);

        btnPosition4.setEffect(dropShadow7);

        btnPosition5.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition5.setLayoutX(141.0);
        btnPosition5.setLayoutY(367.0);
        btnPosition5.setMnemonicParsing(false);
        btnPosition5.setPrefHeight(85.0);
        btnPosition5.setPrefWidth(85.0);
        btnPosition5.setStyle("-fx-background-radius: 10;");
        btnPosition5.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition5.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition5.setCursor(Cursor.HAND);

        btnPosition5.setEffect(dropShadow8);

        btnPosition6.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition6.setLayoutX(241.0);
        btnPosition6.setLayoutY(367.0);
        btnPosition6.setMnemonicParsing(false);
        btnPosition6.setPrefHeight(85.0);
        btnPosition6.setPrefWidth(85.0);
        btnPosition6.setStyle("-fx-background-radius: 10;");
        btnPosition6.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition6.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition6.setCursor(Cursor.HAND);

        btnPosition6.setEffect(dropShadow9);

        btnPosition7.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition7.setLayoutX(40.0);
        btnPosition7.setLayoutY(467.0);
        btnPosition7.setMnemonicParsing(false);
        btnPosition7.setPrefHeight(85.0);
        btnPosition7.setPrefWidth(85.0);
        btnPosition7.setStyle("-fx-background-radius: 10;");
        btnPosition7.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition7.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition7.setCursor(Cursor.HAND);

        btnPosition7.setEffect(dropShadow10);

        btnPosition8.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition8.setLayoutX(141.0);
        btnPosition8.setLayoutY(467.0);
        btnPosition8.setMnemonicParsing(false);
        btnPosition8.setPrefHeight(85.0);
        btnPosition8.setPrefWidth(85.0);
        btnPosition8.setStyle("-fx-background-radius: 10;");
        btnPosition8.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition8.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition8.setCursor(Cursor.HAND);

        btnPosition8.setEffect(dropShadow11);

        btnPosition9.setAlignment(javafx.geometry.Pos.CENTER);
        btnPosition9.setLayoutX(241.0);
        btnPosition9.setLayoutY(467.0);
        btnPosition9.setMnemonicParsing(false);
        btnPosition9.setPrefHeight(85.0);
        btnPosition9.setPrefWidth(85.0);
        btnPosition9.setStyle("-fx-background-radius: 10;");
        btnPosition9.setTextFill(javafx.scene.paint.Color.valueOf("#030040"));
        btnPosition9.setFont(new Font("Arial Rounded MT Bold", 36.0));
        btnPosition9.setCursor(Cursor.HAND);

        btnPosition9.setEffect(dropShadow12);

        btnClose.setLayoutX(628.0);
        btnClose.setLayoutY(16.0);
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

        dropShadow13.setColor(Color.valueOf("#fff7f7"));
        dropShadow13.setSpread(0.69);
        btnClose.setEffect(dropShadow13);

        btnMin.setLayoutX(559.0);
        btnMin.setLayoutY(16.0);
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

        dropShadow14.setColor(Color.valueOf("#fff7f7"));
        dropShadow14.setSpread(0.69);
        btnMin.setEffect(dropShadow14);

        circle0.setFill(javafx.scene.paint.Color.valueOf("#00000078"));
        circle0.setLayoutX(63.0);
        circle0.setLayoutY(36.0);
        circle0.setOpacity(0.2);
        circle0.setRadius(120.0);
        circle0.setStroke(javafx.scene.paint.Color.valueOf("#d0cbcb"));
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        lableTurnPlayer.setLayoutX(32.0);
        lableTurnPlayer.setLayoutY(174.0);
        lableTurnPlayer.setPrefHeight(74.0);
        lableTurnPlayer.setPrefWidth(300.0);
        lableTurnPlayer.setStyle("-fx-alignment: center; -fx-background-color: #f4d741; -fx-background-radius: 10;");
        lableTurnPlayer.setText("Label");
        lableTurnPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lableTurnPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        lableTurnPlayer.setFont(new Font("Franklin Gothic Demi Cond", 42.0));

        dropShadow15.setColor(Color.valueOf("#5a5a5e"));
        dropShadow15.setSpread(0.71);
        lableTurnPlayer.setEffect(dropShadow15);

        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(btnLogin);
        getChildren().add(circle);
        getChildren().add(recordsListView);
        getChildren().add(back);
        pane.getChildren().add(imageView);
        getChildren().add(btnBack);
        getChildren().add(label0);
        getChildren().add(backgroundGame);
        getChildren().add(backgroundPosition);
        getChildren().add(btnPosition1);
        getChildren().add(btnPosition2);
        getChildren().add(btnPosition3);
        getChildren().add(btnPosition4);
        getChildren().add(btnPosition5);
        getChildren().add(btnPosition6);
        getChildren().add(btnPosition7);
        getChildren().add(btnPosition8);
        getChildren().add(btnPosition9);
        getChildren().add(btnClose);
        getChildren().add(btnMin);
        getChildren().add(circle0);
        getChildren().add(lableTurnPlayer);

        setListeners(ClientApp.stage);

        lableTurnPlayer.setText("Turn: Player X");
        buttons[0][0] = btnPosition1;
        buttons[0][1] = btnPosition2;
        buttons[0][2] = btnPosition3;
        buttons[1][0] = btnPosition4;
        buttons[1][1] = btnPosition5;
        buttons[1][2] = btnPosition6;
        buttons[2][0] = btnPosition7;
        buttons[2][1] = btnPosition8;
        buttons[2][2] = btnPosition9;
        btnPosition1.setCancelButton(false);
        Button backButton = new Button("Clear");
        backButton.setOnAction(e -> clearBoard());

        String directoryPath = "C:\\files";
        addTextFilesToListView(directoryPath);
    }

    private void setListeners(Stage stage) {
        btnMin.setOnAction(e -> {
            stage.setIconified(true); // This will minimize the window
        });
        btnClose.setOnAction(e -> {
            System.exit(0);
        });
        btnBack.setOnAction((ActionEvent event) -> {
            Parent selectMode = new ModesScreenUI();
            Util.displayScreen(selectMode);
        });
    }

    private void addTextFilesToListView(String path) {
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".bin"));
            if (files != null) {
                for (File file : files) {
                    String fileNameWithExtension = file.getName();
                    int lastDotIndex = fileNameWithExtension.lastIndexOf('.');
                    String fileNameWithoutExtension;
                    if (lastDotIndex > 0) {
                        fileNameWithoutExtension = fileNameWithExtension.substring(0, lastDotIndex);
                    } else {
                        fileNameWithoutExtension = fileNameWithExtension;
                    }
                    Button button = new Button(fileNameWithoutExtension);
                    button.setStyle("-fx-background-radius: 100; -fx-background-color: #EAD3D7;");
                    button.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
                    button.setFont(new Font("Franklin Gothic Demi Cond", 22.0));
                    button.setCursor(Cursor.HAND);
                    button.setOnAction((event) -> {
                        displayFileContent(file.getAbsolutePath());
                        int index = recordsListView.getItems().indexOf(button);
                        recordsListView.getSelectionModel().select(index);
                    });
                    recordsListView.getItems().add(button);
                }
            }
        } else {
            System.out.println("The specified path either doesn't exist or is not a directory.");
        }
    }

    private void displayFileContent(String filePath) {
        recordsListView.setDisable(true);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            simulateMovesFromRecord(content.toString());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private void clearBoard() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
                button.setStyle("-fx-background-color:  #e2e2e2;");
            }
        }
        playerXTurn = true;
        lableTurnPlayer.setText("Turn: Player X");
        movesRecord.setLength(0);
    }

    private void simulateMovesFromRecord(String record) {
        clearBoard(); // Clear the board before simulating moves
        String[] moves = record.split("\n");
        List<String> movesList = Arrays.asList(moves);
        simulationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String move : movesList) {
                    String[] player = move.split(", ");
                    String[] moveDetails = move.split(": ");
                    String[] coordinates = moveDetails[1].split(", ");
                    int rowIndex = Integer.parseInt(coordinates[0]);
                    int columnIndex = Integer.parseInt(coordinates[1]);
                    Button button = buttons[rowIndex][columnIndex];
                    Platform.runLater(() -> {
                        lableTurnPlayer.setText("Turn: " + player[0] + " " + player[1]);
                        button.setText(player[1]);
                    });

                    try {
                        Thread.sleep(1000); // Sleep for 2 seconds between moves
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                Platform.runLater(() -> recordsListView.setDisable(false));
                Platform.runLater(() -> {
                    String type;
                    type = checkWin();
                    if (type.equals("X")) {
                        lableTurnPlayer.setText("You Win");
                    } else if (type.equals("O")) {
                        lableTurnPlayer.setText("You Lose");
                    } else {
                        lableTurnPlayer.setText("You Draw");
                    }
                });
            }
        });
        simulationThread.start();
    }

    private void showAlert(String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(string);
        alert.showAndWait();
    }

    private String checkWin() {
        String type = "Draw";
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }
        // Check rows and columns for a win, set color of winning buttons
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].isEmpty()) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setStyle("-fx-background-color:  #FD6D84;");
                    type = buttons[i][j].getText(); // Corrected indices
                }
            }
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
                for (int j = 0; j < 3; j++) {
                    buttons[j][i].setStyle("-fx-background-color:  #FD6D84;");
                    type = buttons[j][i].getText();
                }
            }
        }

        // Check diagonals for a win, set color of winning buttons
        if ((board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty())
                || (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].isEmpty())) {
            if (board[0][0].equals(board[1][1])) {
                for (int i = 0; i < 3; i++) {
                    buttons[i][i].setStyle("-fx-background-color:  #FD6D84;");
                    type = buttons[i][i].getText();
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    buttons[i][2 - i].setStyle("-fx-background-color:  #FD6D84;");
                    type = buttons[i][2 - i].getText();
                }
            }
        }
        return type;
    }
}
