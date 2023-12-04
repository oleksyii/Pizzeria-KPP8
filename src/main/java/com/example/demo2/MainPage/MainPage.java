package com.example.demo2.MainPage;

import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainPage {
    private Animation animationInstance;

    public void start(Stage primaryStage) {
        animationInstance = new Animation();
        StackPane root = new StackPane();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        Button settingsButton = new Button();
        Button menuButton = new Button();
        settingsButton.setOnAction(event -> PizzeriaController.handleSettingsButtonClick(primaryStage));
        menuButton.setOnAction(event -> PizzeriaController.handleMenuButtonClick(primaryStage));
        ImageView menuIconImageView = new ImageView(new Image(getClass().getResource("/menu.png").toExternalForm()));
        menuIconImageView.setFitHeight(40);
        menuIconImageView.setFitWidth(40);
        menuButton.setGraphic(menuIconImageView);
        menuButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        settingsButton.setGraphic(new ImageView(new Image(getClass().getResource("/settings.png").toExternalForm())));
        settingsButton.setPrefSize(20, 20);
        settingsButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        StackPane.setMargin(settingsButton, new Insets(4, 25, 0, 0));
        StackPane.setMargin(menuButton, new Insets(10, 100, 0, 0));

        StackPane.setAlignment(settingsButton, Pos.TOP_RIGHT);
        StackPane.setAlignment(menuButton, Pos.TOP_RIGHT);

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

        int numberOfCooks = 4;
        int numberOfCashiers = 2;
        VBox ovens = PizzeriaController.generateOvens(numberOfCooks);
        VBox cooks = PizzeriaController.generateCooks(numberOfCooks);
        StackPane table = PizzeriaController.generateTable(numberOfCooks);
        VBox cashiers = PizzeriaController.generateCashiers(numberOfCashiers);
        StackPane clientsContainer = new StackPane();
        HBox clients = new HBox();
        clients.setPrefSize(550, 75);
        clients.setSpacing(10);
        clients.setMaxWidth(Region.USE_PREF_SIZE);
        clientsContainer.setAlignment(Pos.CENTER_RIGHT);
        clientsContainer.setPadding(new Insets(0, -500, 0, -100));
        clients.setPadding(new Insets(380, 0, 0, 0));
        clientsContainer.getChildren().add(clients);
        VBox clientsDesks = PizzeriaController.generateClientDesks();

        Cook targetCook = (Cook) cooks.getChildren().get(0);
        targetCook.animateCook(animationInstance, 10);

        root.getChildren().addAll(backgroundImageView, ovens, cooks, table, cashiers, clientsContainer, clientsDesks);
        root.getChildren().addAll(header, settingsButton, menuButton);

        Scene scene = new Scene(root,  1320, 780);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Pizza Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e->PizzeriaController.generateClients(clients, animationInstance)));
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }
}
