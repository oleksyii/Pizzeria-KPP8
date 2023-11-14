package com.example.demo2.PizzaMenu;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.paint.Color;

public class MenuApplication {
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1500);
        backgroundImageView.setFitHeight(800);

        GridPane pizzaGrid = new GridPane();

        pizzaGrid.setHgap(310);
        pizzaGrid.setVgap(50);

        Line verticalLine = new Line();
        verticalLine.setStartX(0);
        verticalLine.setStartY(960);
        verticalLine.setEndX(0);
        verticalLine.setEndY(root.getHeight());
        verticalLine.setStrokeWidth(12);
        verticalLine.setStroke(Color.rgb(0x5F, 0x2D, 0x04));

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        pizzaGrid.getColumnConstraints().addAll(column1, column2);

        List<PizzaComponent> pizzas = PizzasList.getPizzas();

        int row = 0;
        int col = 0;

        for (PizzaComponent pizza : pizzas) {
            pizzaGrid.add(pizza, col, row);

            col++;
            if (col > 1) {
                col = 0;
                row++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(pizzaGrid);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; ");
        scrollPane.setPadding(new Insets(20));

        root.getChildren().addAll(backgroundImageView, verticalLine, scrollPane);

        Scene scene = new Scene(root, 1920, 1080);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
