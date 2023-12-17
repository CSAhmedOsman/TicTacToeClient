package ui;

import client.ClientApp;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    protected final Button btnOnlie;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final Button back;
    protected final ImageView imageView5;
    protected final Button btnClose;
    protected final DropShadow dropShadow;
    protected final Button btnMinimize;
    protected final DropShadow dropShadow0;

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
        btnOnlie = new Button();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();
        back = new Button();
        imageView5 = new ImageView();
        btnClose = new Button();
        dropShadow = new DropShadow();
        btnMinimize = new Button();
        dropShadow0 = new DropShadow();
        
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
        btnWithPc.setStyle("-fx-background-radius: 30; -fx-background-color: white;");
        btnWithPc.setText("VS");
        btnWithPc.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnWithPc.setFont(new Font("Arial Rounded MT Bold", 35.0));

        btnOfline.setLayoutX(260.0);
        btnOfline.setLayoutY(256.0);
        btnOfline.setMnemonicParsing(false);
        btnOfline.setPrefHeight(160.0);
        btnOfline.setPrefWidth(181.0);
        btnOfline.setStyle("-fx-background-radius: 30; -fx-background-color: white;");
        btnOfline.setText("VS");
        btnOfline.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOfline.setFont(new Font("Arial Rounded MT Bold", 34.0));

        btnOnlie.setLayoutX(472.0);
        btnOnlie.setLayoutY(256.0);
        btnOnlie.setMnemonicParsing(false);
        btnOnlie.setPrefHeight(160.0);
        btnOnlie.setPrefWidth(181.0);
        btnOnlie.setStyle("-fx-background-radius: 30; -fx-background-color: white;");
        btnOnlie.setText("VS");
        btnOnlie.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        btnOnlie.setFont(new Font("Arial Rounded MT Bold", 35.0));

        imageView.setFitHeight(60.0);
        imageView.setFitWidth(92.0);
        imageView.setLayoutX(119.0);
        imageView.setLayoutY(353.0);
        imageView.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.51.35%20PM%20(1).jpeg").toExternalForm()));

        imageView0.setFitHeight(60.0);
        imageView0.setFitWidth(64.0);
        imageView0.setLayoutX(274.0);
        imageView0.setLayoutY(264.0);
        imageView0.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.24.46%20PM.jpeg").toExternalForm()));

        imageView1.setFitHeight(60.0);
        imageView1.setFitWidth(64.0);
        imageView1.setLayoutX(60.0);
        imageView1.setLayoutY(264.0);
        imageView1.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.24.46%20PM.jpeg").toExternalForm()));

        imageView2.setFitHeight(60.0);
        imageView2.setFitWidth(73.0);
        imageView2.setLayoutX(351.0);
        imageView2.setLayoutY(353.0);
        imageView2.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.24.45%20PM.jpeg").toExternalForm()));

        imageView3.setFitHeight(60.0);
        imageView3.setFitWidth(81.0);
        imageView3.setLayoutX(556.0);
        imageView3.setLayoutY(353.0);
        imageView3.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.24.42%20PM%20(1).jpeg").toExternalForm()));

        imageView4.setFitHeight(60.0);
        imageView4.setFitWidth(64.0);
        imageView4.setLayoutX(481.0);
        imageView4.setLayoutY(264.0);
        imageView4.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-12%20at%202.24.46%20PM.jpeg").toExternalForm()));

        back.setLayoutX(15.0);
        back.setLayoutY(11.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(40.0);
        back.setPrefWidth(55.0);
        back.setStyle("-fx-background-color: F1AAAA;");
        back.setTextFill(javafx.scene.paint.Color.valueOf("#f8baba"));

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(40.0);
        imageView5.setLayoutX(17.0);
        imageView5.setLayoutY(11.0);
        imageView5.setImage(new Image(getClass().getResource("../../../../../Downloads/back.png").toExternalForm()));

        btnClose.setLayoutX(616.0);
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

        btnClose.setEffect(dropShadow);

        btnMinimize.setLayoutX(547.0);
        btnMinimize.setLayoutY(23.0);
        btnMinimize.setMinHeight(USE_PREF_SIZE);
        btnMinimize.setMinWidth(50.0);
        btnMinimize.setMnemonicParsing(false);
        btnMinimize.setPrefHeight(40.0);
        btnMinimize.setPrefWidth(20.0);
        btnMinimize.setStyle("-fx-background-radius: 10; -fx-font-size: 20; -fx-font-weight: bold; -fx-background-color: #FD6D84;");
        btnMinimize.setText("-");
        btnMinimize.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        btnMinimize.setTextFill(javafx.scene.paint.Color.WHITE);
        btnMinimize.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btnMinimize.setFont(new Font("Franklin Gothic Demi Cond", 43.0));
        btnMinimize.setCursor(Cursor.HAND);

        btnMinimize.setEffect(dropShadow0);

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
        getChildren().add(btnOnlie);
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView4);
        getChildren().add(back);
        getChildren().add(imageView5);
        getChildren().add(btnClose);
        getChildren().add(btnMinimize);
        
        //_____________________My Work_______________________
        setListeners(ClientApp.stage);
    }
    
    public ModesScreenUI(int playerId) {
    }
    
    public ModesScreenUI() {
    }

    private void setListeners(Stage stage) {
        
        btnClose.setOnAction((ActionEvent event) -> {
            stage.close();
        });
        
        btnMinimize.setOnAction((ActionEvent event) -> {
            stage.setIconified(true);
        });
    }
}
