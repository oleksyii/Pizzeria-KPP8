package com.example.demo2.Settings;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ChiefItem extends StackPane {
    private ImageView chefImage;
    private Label chefNameLabel;
    private Line verticalLine;
    private ComboBox<String> optionsComboBox;

    public ChiefItem(String chefName) {
        // Ініціалізація елементів
        chefImage = new ImageView(new Image(getClass().getResource("/test.png").toExternalForm()));
        chefNameLabel = new Label(chefName);
        verticalLine = new Line();
        optionsComboBox = new ComboBox<>();
        optionsComboBox.getItems().addAll("Option 1", "Option 2", "Option 3");

        optionsComboBox.setValue("Option 1");

        // Встановлюємо білий колір стріли

        // Налаштування розмірів та вирівнювання
        chefImage.setFitHeight(80);
        chefImage.setFitWidth(80);
        chefNameLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 0 0 15; -fx-font-family: 'Comic Sans MS';");
        verticalLine.setStartX(0);
        verticalLine.setStartY(0);
        verticalLine.setEndX(0);
        verticalLine.setEndY(80);
        verticalLine.setStrokeWidth(3);
        verticalLine.setStroke(Color.WHITE);
        optionsComboBox.setMinWidth(100);
        optionsComboBox.setStyle("-fx-background-color: transparent; -fx-font-size: 22; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 0 0 15; -fx-font-family: 'Comic Sans MS';");

        // Задання мінімальної ширини ChiefItem
        setMinWidth(550);

        // Задання заднього кольору, обводки та заокруглення
        Rectangle background = new Rectangle(550, 120);
        background.setFill(Color.web("#AF5D26"));
        background.setStroke(Color.web("#5F2D04"));
        background.setStrokeWidth(5);
        background.setArcWidth(15);
        background.setArcHeight(15);

        // Розміщення елементів у GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setHgap(45);
        gridPane.add(chefImage, 0, 0);
        gridPane.add(chefNameLabel, 1, 0);
        gridPane.add(verticalLine, 2, 0);
        gridPane.add(optionsComboBox, 3, 0);

        optionsComboBox.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        setMargin(gridPane, new javafx.geometry.Insets(0, 20, 0, 0)); // Відступ зліва

        getChildren().addAll(background, gridPane);
    }
}
