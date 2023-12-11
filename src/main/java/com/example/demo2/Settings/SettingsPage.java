package com.example.demo2.Settings;

import code.example.demo2.CooksManagement.SpecificCook;
import code.example.demo2.CooksManagement.strategies.Cook;
import code.example.demo2.UIManagement.controllers.PizzeriaController;
import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import com.example.demo2.Configuration.PizzaConfiguration;
import com.example.demo2.MainPage.MainPage;
import com.example.demo2.PizzaMenu.PizzaComponent;
import com.example.demo2.PizzaMenu.PizzasList;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

public class SettingsPage {
    public void start(Stage primaryStage) {

        Scene savedScene = PizzeriaSimulator.getInstance().getSettingsScene();

        if(savedScene != null) {
            primaryStage.setResizable(false);
            primaryStage.setTitle("Settings");
            primaryStage.setScene(savedScene);
            primaryStage.show();
            return;
        }

        StackPane root = new StackPane();

        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1500);
        backgroundImageView.setFitHeight(800);

        VBox mainLayout = new VBox();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        ImageView iconImageView = new ImageView(new Image(getClass().getResource("/settings.png").toExternalForm()));
        iconImageView.setFitHeight(40);
        iconImageView.setFitWidth(40);

        Label titleLabel = new Label("SETTINGS");
        titleLabel.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'");
        titleContainer.getChildren().addAll(iconImageView, titleLabel);

        header.getChildren().add(titleContainer);

        // Додаємо колір до хедеру
        header.setStyle("-fx-background-color: #5F2D04;");


        GridPane settingsGrid = new GridPane();

        settingsGrid.setHgap(100);
        settingsGrid.setVgap(50);

        Line verticalLine = new Line();
        verticalLine.setStartX(0);
        verticalLine.setStartY(1200);
        verticalLine.setEndX(0);
        verticalLine.setEndY(root.getHeight());
        verticalLine.setStrokeWidth(12);
        verticalLine.setStroke(Color.rgb(0x5F, 0x2D, 0x04));

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        settingsGrid.getColumnConstraints().addAll(column1, column2);

        ArrayList<SpecificCook> cooks = PizzeriaSimulator.getInstance().getKitchenManager().getCooks();

        List<ChiefItem> chiefsItems = cooks.stream()
                .map(cook -> new ChiefItem(cook.Id()))
                .toList();


        for (int i = 0; i < chiefsItems.size(); i++) {
            ChiefItem chiefItem = chiefsItems.get(i);
            settingsGrid.add(chiefItem, 0, i);
        }

        settingsGrid.setPadding(new Insets(10));
        settingsGrid.setMaxHeight(300);

        // Додаємо скролл до settingsGrid
        ScrollPane scrollPane = new ScrollPane(settingsGrid);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; ");
        scrollPane.setPadding(new Insets(130, 0, 150, 50));



        // Додаємо поля вводу та кнопки до другої колонки
        TextField kucharsInput = createTextInput("KUCHARS", String.valueOf(PizzeriaSimulator.getInstance().getAllCooks().size()));
        TextField cashersInput = createTextInput("CASHERS", String.valueOf(PizzeriaSimulator.getInstance().getAllCashiers().size()));
        TextField minTimeInput = createTextInput("MIN.TIME", String.valueOf(Cook.COOKING_TIME) + "ms");
        TextField strategyInput = createTextInput("STRATEGY", PizzeriaSimulator.getInstance().getPizzaSimulatorStrategy());

        Button newGameButton = createButton("NEW GAME");
        Button quitButton = createButton("QUIT");

        quitButton.setOnAction(event -> primaryStage.close());
        newGameButton.setOnAction(event -> {
            PizzaConfiguration configaration = new PizzaConfiguration();
            configaration.start(primaryStage);
        });

        newGameButton.setStyle("-fx-font-size: 20; -fx-min-height: 45px; -fx-min-width: 200px; -fx-max-width: 170px; -fx-font-weight: bold; -fx-text-fill: #AF5D26; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'; -fx-background-color: #ffffff; -fx-border-radius: 20px");
        quitButton.setStyle("-fx-font-size: 20; -fx-min-height: 45px; -fx-min-width: 200px; -fx-max-width: 170px; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'; -fx-background-color: #890303; -fx-border-radius: 20px");

        Label kucharsLabel = new Label("KUCHARS");
        kucharsLabel.setAlignment(Pos.CENTER);
        kucharsLabel.setStyle("-fx-min-width: 200; -fx-font-weight: bold; -fx-font-size: 25; -fx-font-family: 'Comic Sans MS'; -fx-padding: 5 40 0 0");

        Label cahersLabel = new Label("CASHERS");
        cahersLabel.setAlignment(Pos.CENTER);
        cahersLabel.setStyle("-fx-min-width: 200; -fx-font-weight: bold; -fx-font-size: 25; -fx-font-family: 'Comic Sans MS'; -fx-padding: 5 40 0 0");

        Label minTimeLabel = new Label("MIN. TIME");
        minTimeLabel.setAlignment(Pos.CENTER);
        minTimeLabel.setStyle("-fx-min-width: 200; -fx-font-weight: bold; -fx-font-size: 25; -fx-font-family: 'Comic Sans MS'; -fx-padding: 5 40 0 0");

        Label strategyLabel = new Label("STRATEGY");
        strategyLabel.setAlignment(Pos.CENTER);
        strategyLabel.setStyle("-fx-min-width: 200; -fx-font-weight: bold; -fx-font-size: 25; -fx-font-family: 'Comic Sans MS'; -fx-padding: 5 40 0 0");

        VBox row0 = new VBox(new HBox(kucharsLabel, kucharsInput), new HBox(cahersLabel, cashersInput));
        VBox row1 = new VBox(new HBox(minTimeLabel, minTimeInput), new HBox(strategyLabel, strategyInput));
        VBox row2 = new VBox(newGameButton, quitButton);

        row2.setMinWidth(550);
        row1.setMinWidth(550);
        row0.setMinWidth(550);

        row2.setAlignment(Pos.CENTER);
        row2.setSpacing(15);
        row1.setAlignment(Pos.CENTER);
        row1.setSpacing(25);
        row0.setAlignment(Pos.CENTER);
        row0.setSpacing(25);

        settingsGrid.addRow(0, row0);
        settingsGrid.addRow(1, row1);
        settingsGrid.addRow(2, row2);

        // Розміщуємо header зверху
        StackPane.setAlignment(header, Pos.TOP_CENTER);

        // Додаємо всі елементи до mainLayout
        mainLayout.getChildren().addAll(header, scrollPane, verticalLine);

        Button closeButton = new Button("CLOSE");
        closeButton.setStyle("-fx-font-size: 27; -fx-min-height: 50px; -fx-min-width: 140px; -fx-font-weight: bold; -fx-text-fill: white; -fx-padding: 0 15 0 15; -fx-font-family: 'Comic Sans MS'; -fx-background-color: #5F2D04; -fx-border-radius: 15px");

        closeButton.setOnAction(event -> {
            PizzeriaController.handleCloseButtonClick(primaryStage);
        });


        StackPane.setAlignment(closeButton, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(closeButton, new Insets(0, 50, 30, 240));  // Відстань зліва

        // Додаємо backgroundImageView та mainLayout до кореневого вузла
        root.getChildren().addAll(backgroundImageView, scrollPane, verticalLine, closeButton);

        root.getChildren().add(header);

        Scene scene = new Scene(root, 1320, 780);

        PizzeriaSimulator.getInstance().setSettingsScene(scene);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Settings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TextField createTextInput(String label, String defaultValue) {
        TextField textField = new TextField(defaultValue);
        textField.setPromptText(label);
        textField.setStyle("-fx-font-size: 20; -fx-background-color: #AF5D26; -fx-text-fill: #ffffff; -fx-text-alignment: center; -fx-min-height: 50; -fx-min-width: 200; -fx-border-radius: 25; -fx-padding: 10 20 ");
        return textField;
    }

    private Button createButton(String label) {
        Button button = new Button(label);
        return button;
    }
}
