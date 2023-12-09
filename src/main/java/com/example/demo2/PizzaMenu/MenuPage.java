package com.example.demo2.PizzaMenu;

import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.paint.Color;

public class MenuPage {
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        ImageView menuIconImageView = new ImageView(new Image(getClass().getResource("/menu.png").toExternalForm()));
        menuIconImageView.setFitHeight(40);
        menuIconImageView.setFitWidth(40);

        ImageView backIconImageView = new ImageView(new Image(getClass().getResource("/back-icon.png").toExternalForm()));
        backIconImageView.setFitHeight(40);
        backIconImageView.setFitWidth(40);

        Button backButton = new Button();
        backButton.setGraphic(backIconImageView);
        backButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        StackPane.setMargin(backButton, new Insets(7, 0, 0, 7));
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        backButton.setOnAction(event -> Platform.runLater(() -> PizzeriaController.handleStartMainPageButtonClick(primaryStage)));

        Label titleLabel = new Label("MENU");
        titleLabel.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'");
        titleContainer.getChildren().addAll(menuIconImageView, titleLabel);

        header.getChildren().add(titleContainer);

        header.setStyle("-fx-background-color: #5F2D04;");

        StackPane.setAlignment(header, Pos.TOP_CENTER);

        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1320);
        backgroundImageView.setFitHeight(780);

        GridPane pizzaGrid = new GridPane();

        pizzaGrid.setHgap(250);

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
        scrollPane.setPadding(new Insets(70, 20, 0, 20));

        root.getChildren().addAll(backgroundImageView, verticalLine, scrollPane);

        root.getChildren().addAll(header, backButton);

        Scene scene = new Scene(root, 1320, 780);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
