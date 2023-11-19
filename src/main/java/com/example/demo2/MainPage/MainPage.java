package com.example.demo2.MainPage;

import com.example.demo2.Settings.SettingsPage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainPage {
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        Button settingsButton = new Button();
        settingsButton.setOnAction(event -> {
            SettingsPage settings = new SettingsPage();
            settings.start(primaryStage);
        });
        settingsButton.setGraphic(new ImageView(new Image(getClass().getResource("/settings.png").toExternalForm())));
        settingsButton.setPrefSize(25, 25);
        settingsButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        StackPane.setMargin(settingsButton, new Insets(4, 25, 0, 0));
        StackPane.setAlignment(settingsButton, Pos.TOP_RIGHT);

        Label titleLabel = new Label("PIZZA SIMULATOR");
        titleLabel.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'");
        titleContainer.getChildren().addAll(titleLabel);

        header.getChildren().add(titleContainer);
        header.setStyle("-fx-background-color: #5F2D04;");
        StackPane.setAlignment(header, Pos.TOP_CENTER);

        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1320);
        backgroundImageView.setFitHeight(780);

        VBox ovens = generateOvens();
        VBox cooks = generateCooks();
        StackPane table = generateTable();
        VBox cashiers = generateCashiers();

        root.getChildren().addAll(backgroundImageView, ovens, cooks, table, cashiers);
        root.getChildren().addAll(header, settingsButton);

        Scene scene = new Scene(root, 1320, 780);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Pizza Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox generateOvens() {
        VBox ovens = new VBox();
        ovens.setAlignment(Pos.TOP_LEFT);
        ovens.setPadding(new Insets(220, 0, 150, 100));
        ovens.setSpacing(75);

        Oven oven1 = new Oven();
        Oven oven2 = new Oven();
        Oven oven3 = new Oven();

        ovens.getChildren().addAll(oven1, oven2, oven3);
        return ovens;
    }

    private VBox generateCooks() {
        VBox cooks = new VBox();
        cooks.setAlignment(Pos.TOP_LEFT);
        cooks.setPadding(new Insets(170, 0, 150, 230));
        cooks.setSpacing(60);

        Cook cook1 = new Cook("atTable");
        Cook cook2 = new Cook("atOven");
        Cook cook3 = new Cook("atTable");

        cooks.getChildren().addAll(cook1, cook2, cook3);
        return cooks;
    }

    private StackPane generateTable() {
        Rectangle rectangle = new Rectangle(100, 620);
        rectangle.setFill(Color.SADDLEBROWN);

        Image pizzaImage1 = new Image("pizza_icon.png");
        Image pizzaImage2 = new Image("pizza_icon.png");

        ImageView pizzaImageView1 = new ImageView(pizzaImage1);
        ImageView pizzaImageView2 = new ImageView(pizzaImage2);

        VBox pizzaImages = new VBox();

        pizzaImageView1.setFitHeight(70);
        pizzaImageView1.setFitWidth(70);

        pizzaImageView2.setFitHeight(70);
        pizzaImageView2.setFitWidth(70);

        pizzaImages.setAlignment(Pos.TOP_LEFT);
        pizzaImages.setPadding(new Insets(100, 15, 30, 15));
        pizzaImages.setSpacing(300);

        pizzaImages.getChildren().addAll(pizzaImageView1, pizzaImageView2);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);
        stackPane.setPadding(new Insets(210, 0, 150, 430));
        stackPane.getChildren().addAll(rectangle, pizzaImages);

        return stackPane;
    }

    private VBox generateCashiers() {
        VBox cashiers = new VBox();
        cashiers.setAlignment(Pos.TOP_CENTER);
        cashiers.setPadding(new Insets(220, 0, 150, 50));
        cashiers.setSpacing(75);

        Cashier oven1 = new Cashier();
        Cashier oven2 = new Cashier();
        Cashier oven3 = new Cashier();

        cashiers.getChildren().addAll(oven1, oven2, oven3);
        return cashiers;
    }

}
