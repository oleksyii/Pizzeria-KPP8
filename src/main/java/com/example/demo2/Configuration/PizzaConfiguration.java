package com.example.demo2.Configuration;

import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.paint.Color;

public class PizzaConfiguration {
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        //Add background
        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1320);
        backgroundImageView.setFitHeight(780);

        //Add title
        Label simulatorTitle = new Label("Pizza Simulator");
        simulatorTitle.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 50));
        simulatorTitle.setTextFill(Color.WHITE);
        simulatorTitle.setTranslateX(0);
        simulatorTitle.setTranslateY(22);

        Image pizzaTitleImage = new Image(getClass().getResource("/pizza_chunk.png").toExternalForm());
        ImageView pizzaTitleView = new ImageView(pizzaTitleImage);
        pizzaTitleView.setFitWidth(140);
        pizzaTitleView.setFitHeight(140);
        pizzaTitleView.setTranslateX(-140);
        pizzaTitleView.setTranslateY(-20);
        Group pizzaTitleGroup = new Group(simulatorTitle, pizzaTitleView);
        pizzaTitleGroup.setTranslateX(0);
        pizzaTitleGroup.setTranslateY(-260);

        //Add input fields
        Image cookImage = new Image(getClass().getResource("/cook_icon.png").toExternalForm());
        ImageView cookImageView = new ImageView(cookImage);
        cookImageView.setFitHeight(70);
        cookImageView.setFitWidth(70);
        TextField numberOfCooks = new TextField("5");
        PizzeriaController.setTextFieldLimit(numberOfCooks, 1, 5);
        numberOfCooks.setAlignment(Pos.CENTER);
        numberOfCooks.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        numberOfCooks.setMinSize(240, 30);
        numberOfCooks.setStyle(
                "-fx-background-color: #AF5D26; " +
                        "-fx-text-fill: white;" +
                        "-fx-border-radius: 20;"
        );

        StackPane.setMargin(cookImageView, new Insets(0, 0, 0, 20));


        Image cashierImage = new Image(getClass().getResource("/cashier_icon.png").toExternalForm());
        ImageView cashierImageView = new ImageView(cashierImage);
        cashierImageView.setFitHeight(70);
        cashierImageView.setFitWidth(70);
        TextField numberOfCashiers = new TextField("5");
        PizzeriaController.setTextFieldLimit(numberOfCashiers, 1, 5);
        numberOfCashiers.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        numberOfCashiers.setStyle(
                "-fx-background-color: #AF5D26; " +
                        "-fx-text-fill: white;"
        );
        numberOfCashiers.setAlignment(Pos.CENTER);
        numberOfCashiers.setMinSize(240, 30);

        Image pizzaImage = new Image(getClass().getResource("/pizza_icon.png").toExternalForm());
        ImageView pizzaImageView = new ImageView(pizzaImage);
        pizzaImageView.setFitHeight(70);
        pizzaImageView.setFitWidth(70);
        TextField numberOfPizza = new TextField("5");
        numberOfPizza.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        numberOfPizza.setStyle(
                "-fx-background-color: #AF5D26; " +
                        "-fx-text-fill: white;"
        );
        numberOfPizza.setAlignment(Pos.CENTER);
        numberOfPizza.setMinSize(240, 30);

        Label textStrategy = new Label("STRATEGY");
        textStrategy.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        ChoiceBox<String> strategy = new ChoiceBox<>();
        strategy.getItems().addAll("Regular Day", "Pizza Day", "Weekend");
        textStrategy.setStyle("-fx-text-fill: white;");
        strategy.setStyle(
                "-fx-background-color: #AF5D26; " +
                        "-fx-text-fill: white;" +
                        "-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 20;"+
                        "-fx-font-weight: 400;" +
                        "-fx-text-fill: white;"
        );
        strategy.setMinSize(274, 25);

        Label textMinTime = new Label("MIN.TIME");
        textMinTime.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        TextField minTime = new TextField ("10");
        minTime.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        textMinTime.setStyle("-fx-text-fill: white;");
        minTime.setStyle(
                "-fx-background-color: #AF5D26; " +
                        "-fx-text-fill: white;"
        );
        minTime.setMinSize(240, 30);
        minTime.setAlignment(Pos.CENTER);

        HBox cooksBox = new HBox(cookImageView, numberOfCooks);
        cooksBox.setAlignment(Pos.CENTER);
        cooksBox.setSpacing(50);

        HBox cashiersBox = new HBox(cashierImageView, numberOfCashiers);
        cashiersBox.setAlignment(Pos.CENTER);
        cashiersBox.setSpacing(50);

        HBox pizzasBox = new HBox(pizzaImageView, numberOfPizza);
        pizzasBox.setAlignment(Pos.CENTER);
        pizzasBox.setSpacing(50);

        HBox strategyBox = new HBox(textStrategy, strategy);
        Insets marginInsetsStrategy = new Insets(0, 39, 0, 0);
        HBox.setMargin(textStrategy, marginInsetsStrategy);
        Insets marginInsetsStrategy2 = new Insets(0, 21, 0, 0);
        HBox.setMargin(strategy, marginInsetsStrategy2);

        HBox minTimeBox = new HBox(textMinTime, minTime);
        Insets marginInsetsTimeBox = new Insets(0, 39, 0, 0);
        HBox.setMargin(textMinTime, marginInsetsTimeBox);
        Insets marginInsetsTimeBox2 = new Insets(0, 21, 0, 0);
        HBox.setMargin(minTime, marginInsetsTimeBox2);

        VBox inputFields = new VBox(cooksBox, cashiersBox, pizzasBox, strategyBox, minTimeBox);
        inputFields.setSpacing(10);
        Group fields = new Group(inputFields);
        fields.setTranslateY(-20);


        //Add start button
        Image buttonImage = new Image(getClass().getResource("/start_game_button.png").toExternalForm());
        ImageView buttonImageView = new ImageView(buttonImage);
        buttonImageView.setFitHeight(80);
        buttonImageView.setPreserveRatio(true);
        Button startButton = new Button();
        startButton.setGraphic(buttonImageView);
        startButton.setTranslateX(0);
        startButton.setTranslateY(220);
        startButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 3px; " +
                        "-fx-min-height: 3px; " +
                        "-fx-max-width: 3px; " +
                        "-fx-max-height: 3px;"
        );

        startButton.setOnAction(event -> PizzeriaController.handlePizzaConfigurationButtonClick(primaryStage, numberOfCooks, numberOfCashiers, numberOfPizza, strategy, minTime));

        //Add button animation
        ScaleTransition pressTransition = new ScaleTransition(Duration.millis(50), startButton);
        pressTransition.setToX(1.05);
        pressTransition.setToY(1.05);

        ScaleTransition releaseTransition = new ScaleTransition(Duration.millis(50), startButton);
        releaseTransition.setToX(1.0);
        releaseTransition.setToY(1.0);

        root.getChildren().addAll(backgroundImageView, startButton, pizzaTitleGroup, fields);
        Scene scene = new Scene(root,  1320, 780);
        primaryStage.getIcons().add(new Image("/pizza-box.png"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Configuration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}