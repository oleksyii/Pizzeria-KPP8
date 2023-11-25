package com.example.demo2.MainPage;

import com.example.demo2.PizzaMenu.MenuPage;
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
//    private Animation animationInstance;
    public void start(Stage primaryStage) {
//        animationInstance = new Animation();
        StackPane root = new StackPane();

        HBox header = new HBox();
        header.setMinHeight(70);
        header.setMaxHeight(70);
        header.setAlignment(Pos.TOP_CENTER);
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER_LEFT);

        Button settingsButton = new Button();
        Button menuButton = new Button();
        settingsButton.setOnAction(event -> {
            SettingsPage settings = new SettingsPage();
            settings.start(primaryStage);
        });
        menuButton.setOnAction(event -> {
            MenuPage menu = new MenuPage();
            menu.start(primaryStage);
        });
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

        VBox ovens = generateOvens();
        VBox cooks = generateCooks();
        StackPane table = generateTable();
        VBox cashiers = generateCashiers();
        HBox clients = generateClients();
        VBox clientsDesks = generateClientDesks();

//        Cook targetCook = (Cook) cooks.getChildren().get(0);
//        animationInstance.animateCook(targetCook, 10);


        root.getChildren().addAll(backgroundImageView, ovens, cooks, table, cashiers, clients, clientsDesks);
        root.getChildren().addAll(header, settingsButton, menuButton);

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

    private HBox generateClients() {
        HBox clients = new HBox();
        VBox firstClients = new VBox();
        HBox otherClients = new HBox();

        clients.setAlignment(Pos.TOP_CENTER);
        clients.setPadding(new Insets(80, 0, 0,620));
        clients.setSpacing(40);
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        firstClients.getChildren().addAll(client1, client2, client3);
        firstClients.setSpacing(125);
        firstClients.setAlignment(Pos.CENTER);

        Client client4 = new Client();
        Client client5 = new Client();
        Client client6 = new Client();
        Client client7 = new Client();
        otherClients.getChildren().addAll(client4, client5, client6, client7);
        otherClients.setAlignment(Pos.CENTER);
        otherClients.setSpacing(10);

        clients.getChildren().addAll(firstClients, otherClients);
        return clients;
    }

    private VBox generateClientDesks() {
        VBox clientDesks = new VBox();
        clientDesks.setAlignment(Pos.CENTER);
        clientDesks.setSpacing(300);
        clientDesks.setPadding(new Insets(40, 0, 0,0));
        HBox clientDesks1 = new HBox();
        HBox clientDesks2 = new HBox();
        clientDesks1.setSpacing(80);
        clientDesks1.setAlignment(Pos.CENTER_RIGHT);
        clientDesks1.setPadding(new Insets(0, 60, 0, 0));
        clientDesks2.setSpacing(80);
        clientDesks2.setAlignment(Pos.CENTER_RIGHT);
        clientDesks2.setPadding(new Insets(0, 60, 0, 0));

        ClientDesk clientDesk1 = new ClientDesk();
        ClientDesk clientDesk2 = new ClientDesk();
        ClientDesk clientDesk3 = new ClientDesk();
        ClientDesk clientDesk4 = new ClientDesk();

        clientDesks1.getChildren().addAll(clientDesk1, clientDesk2);
        clientDesks2.getChildren().addAll(clientDesk3, clientDesk4);
        clientDesks.getChildren().addAll(clientDesks1, clientDesks2);

        return clientDesks;
    }

}
