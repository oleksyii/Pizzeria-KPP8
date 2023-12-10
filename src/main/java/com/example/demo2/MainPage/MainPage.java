package com.example.demo2.MainPage;

import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
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
import java.util.List;
import java.util.ArrayList;
import javafx.scene.Node;


public class MainPage {
    private Animation animationInstance;

    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        Button settingsButton = new Button();
        Button menuButton = new Button();
        settingsButton.setOnAction(event -> Platform.runLater(() -> PizzeriaController.handleSettingsButtonClick(primaryStage)));
        menuButton.setOnAction(event ->  Platform.runLater(() -> PizzeriaController.handleMenuButtonClick(primaryStage)));
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

        int numberOfCooks = PizzeriaController.getNumberOfCooks();
        int numberOfCashiers = PizzeriaController.getNumberOfCashier();
        VBox ovens = PizzeriaController.generateOvens(numberOfCooks);
        VBox cooks = PizzeriaController.generateCooks(numberOfCooks);
        StackPane table = PizzeriaController.generateTable();
        VBox cashiers = PizzeriaController.generateCashiers(numberOfCashiers);
        StackPane clientsContainer = new StackPane();
        List<HBox> clientsQueues = PizzeriaController.createClientsQueues(numberOfCashiers);
        clientsContainer.setAlignment(Pos.CENTER_RIGHT);
        clientsContainer.setPadding(new Insets(80, -500, 0, -100));
        VBox queuesBox = PizzeriaController.createQueuesBox(clientsQueues);
        PizzeriaController.setClientsSpacing(numberOfCashiers, queuesBox);

        clientsContainer.getChildren().add(queuesBox);
        root.getChildren().addAll(backgroundImageView, ovens, cooks, table, cashiers, clientsContainer);
        root.getChildren().addAll(header, settingsButton, menuButton);

        Scene scene = new Scene(root,  1320, 780);
        scene.getStylesheets().add(getClass().getResource("/styles/tooltip_style.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pizza Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> PizzeriaController.generateClientsForCashiers(1)));
//        timeline.setCycleCount(timeline.INDEFINITE);
//        timeline.play();
    }
}