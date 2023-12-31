package ui;

import client.ClientApp;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class UnBlockUI extends BorderPane {

    protected final Pane pane;
    protected final Button btnClose;
    protected final DropShadow dropShadow;
    protected final Button btnMin;
    protected final DropShadow dropShadow0;
    protected final ImageView imageView;
    protected final ListView blockList;
    protected final Label label;
    protected final DropShadow dropShadow1;

    public UnBlockUI() {

        pane = new Pane();
        btnClose = new Button();
        dropShadow = new DropShadow();
        btnMin = new Button();
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
        pane.setPrefHeight(60.0);
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
        pane.getChildren().add(imageView);
        pane.getChildren().add(blockList);
        pane.getChildren().add(label);
         ClientApp.curDisplayedScreen=this;

    }
}
