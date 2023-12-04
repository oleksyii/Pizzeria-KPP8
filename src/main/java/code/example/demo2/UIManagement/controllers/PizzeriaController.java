package code.example.demo2.UIManagement.controllers;

import com.example.demo2.MainPage.*;
import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PizzeriaController {
    static private double initialDistance = -400;
    static private VBox uiCooks;

    static public void handleSettingsButtonClick(Stage primaryStage) {
        SettingsPage settings = new SettingsPage();
        settings.start(primaryStage);
    }

    static public void startCookAnimation(int cookId) {
        System.out.println(uiCooks);
        Cook cook = (Cook) uiCooks.getChildren().get(cookId);
        Animation.animateCook(cook, 10);
    }

    static public void handleMenuButtonClick(Stage primaryStage) {
        MenuPage menu = new MenuPage();
        menu.start(primaryStage);
    }

    static public void handleStartMainPageButtonClick(Stage primaryStage) {
        MainPage mainPage = new MainPage();
        mainPage.start(primaryStage);
    }

    static private void setSpacingDynamically(int numberOfElements, VBox elements, int paddingIfOne) {
        if(numberOfElements == 1) {
            Insets currentInsets = elements.getPadding();
            elements.setPadding(new Insets(paddingIfOne, currentInsets.getRight(), currentInsets.getBottom(), currentInsets.getLeft()));
        } else {
            int defaultSpacing = 300;
            // 2 -> 150
            // 3 -> 75
            // 4 -> 37.5
            // 5 -> 18.75
            elements.setSpacing(defaultSpacing / Math.pow(2, numberOfElements - 1));
        }
    }

    static private void setSpacingDynamically(int numberOfElements, VBox elements) {
        setSpacingDynamically(numberOfElements, elements, 360);
    }

    static public VBox generateOvens(int numberOfOvens) {
        VBox ovens = new VBox();
        ovens.setAlignment(Pos.TOP_LEFT);
        ovens.setPadding(new Insets(220, 0, 150, 100));

        setSpacingDynamically(numberOfOvens, ovens);

        for (int i = 0; i < numberOfOvens; i++) {
            Oven oven = new Oven();
            ovens.getChildren().add(oven);
        }

        return ovens;
    }

    static public VBox getUiCooks() {
        return uiCooks;
    }

    static public VBox generateCooks(int numberOfCooks) {
        VBox cooks = new VBox();
        cooks.setAlignment(Pos.TOP_LEFT);
        cooks.setPadding(new Insets(180, 0, 150, 230));

        setSpacingDynamically(numberOfCooks, cooks, 330);

        for (int i = 0; i < numberOfCooks; i++) {
            CookState cookState = i % 2 == 0 ? CookState.AT_TABLE: CookState.AT_OVEN;
            com.example.demo2.MainPage.Cook cook = new Cook(cookState);
            cooks.getChildren().add(cook);
        }

        uiCooks = cooks;
        return cooks;
    }

    static public StackPane generateTable(int numberOfPizzas, ObservableList<Node> cooksData) {
        Rectangle rectangle = new Rectangle(100, 650);
        rectangle.setFill(Color.SADDLEBROWN);

        Image pizzaImage = new Image("pizza_icon.png");
        VBox pizzaImages = new VBox();

        double paddingTop = (5.5 - numberOfPizzas) * 35;
        pizzaImages.setPadding(new Insets(paddingTop, 15, 0, 15));
        setSpacingDynamically(numberOfPizzas, pizzaImages, 260);

        for (int i = 0; i < numberOfPizzas; i++) {
            Node cookNode = cooksData.get(i);
            Cook cook = (Cook) cookNode;
            CookState cookState = cook.getState();

            HBox pizzaImageHBox = new HBox();
            Image pizzaImageData = cookState == CookState.AT_TABLE ? pizzaImage: null;
            ImageView pizzaImageView = new ImageView(pizzaImageData);
            pizzaImageView.setFitHeight(70);
            pizzaImageView.setFitWidth(70);
            pizzaImageHBox.setPadding(new Insets(22, 0, 20, 0));

            pizzaImageHBox.getChildren().add(pizzaImageView);
            pizzaImages.getChildren().add(pizzaImageHBox);
        }

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);
        stackPane.setPadding(new Insets(210, 0, 150, 430));
        stackPane.getChildren().addAll(rectangle, pizzaImages);

        return stackPane;
    }

    static public VBox generateCashiers(int numberOfCashiers) {
        VBox cashiers = new VBox();
        cashiers.setAlignment(Pos.TOP_CENTER);
        cashiers.setPadding(new Insets(220, 0, 150, 50));

        setSpacingDynamically(numberOfCashiers, cashiers);

        for (int i = 0; i < numberOfCashiers; i++) {
            Cashier cashier = new Cashier();
            cashiers.getChildren().add(cashier);
        }

        return cashiers;
    }

    static public void generateClients(HBox clients, Animation animationInstance) {
        if (clients.getChildren().size() < 5) {
            Client client = new Client();
            clients.getChildren().add(client);
            initialDistance += 10;

            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.05));
            pauseTransition.setOnFinished(event -> animationInstance.animateClient(client, initialDistance));
            pauseTransition.play();
        }
    }

    static public VBox generateClientDesks() {
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

//    private PizzzeriaSimulatorViewModel simulatorViewModel;
//    private SettingsViewModel settingsView;
//
//    /**
//     * Must generate <b>ALL</b> the other classes in here.
//     * */
//    public PizzeriaController(){
//
//    }
//    public displayPizzaDetails(){
//
//    }
//    public displayClients(){
//
//    }
//    public GenerateClients(){
//
//    }
//    public StoreCook(id){
//
//    }
//    public static updateCookStatus(Cook cook)
}