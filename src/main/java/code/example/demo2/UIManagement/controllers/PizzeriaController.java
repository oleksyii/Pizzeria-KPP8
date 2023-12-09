package code.example.demo2.UIManagement.controllers;

import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import com.example.demo2.MainPage.*;
import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import com.example.demo2.Configuration.PizzaConfiguration;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class PizzeriaController {
    static private double initialDistance = -400;
    static private VBox uiCooks;
    static private StackPane uiTable = new StackPane();
    static private PizzeriaSimulator pizzeriaSimulator;

    static public void handleSettingsButtonClick(Stage primaryStage) {
        SettingsPage settings = new SettingsPage();
        settings.start(primaryStage);
    }

    static public void startCookAnimation(int cookId) {
        Animation.startCookAnimation(cookId - 1);
    }

    static public void finishCookAnimation(int cookId) {
        Animation.finishCookAnimation(cookId - 1);
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
            CookState cookState = CookState.AT_TABLE;
            com.example.demo2.MainPage.Cook cook = new Cook(cookState);
            cooks.getChildren().add(cook);
        }

        uiCooks = cooks;
        return cooks;
    }

    static public StackPane generateTable() {
        uiTable.getChildren().clear();

        Rectangle rectangle = new Rectangle(100, 650);
        rectangle.setFill(Color.SADDLEBROWN);

        Image pizzaImage = new Image("pizza_icon.png");
        VBox pizzaImages = new VBox();

        ObservableList<Node> cooksData = uiCooks.getChildren();
        int numberOfPizzas = cooksData.size();
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

        uiTable.setAlignment(Pos.TOP_LEFT);
        uiTable.setPadding(new Insets(210, 0, 150, 430));
        uiTable.getChildren().addAll(rectangle, pizzaImages);

        return uiTable;
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

    static public void generateClientsForCashiers(List<HBox> cashierQueues, Animation animationInstance, int numberOfClientsPerCashier) {
        for (HBox clientsQueue : cashierQueues) {
            if (clientsQueue.getChildren().size() < 5) {
                Client client = new Client();
                clientsQueue.getChildren().add(client);

                if (getNumberOfCashier() == 5) {
                    initialDistance += 8;
                } else {
                    initialDistance += 10;
                }

                PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.05));
                pauseTransition.setOnFinished(event -> animationInstance.animateClient(client, initialDistance));
                pauseTransition.play();
            }
        }
    }

    public static List<HBox> createClientsQueues(int size) {
        List<HBox> cashierQueues = new ArrayList<>();

        if (size > 2) {
            for (int i = 0; i < size; i++) {
                HBox clients = new HBox();
                clients.setPrefSize(650, 75);
                clients.setSpacing(5);
                clients.setMaxWidth(Region.USE_PREF_SIZE);
                cashierQueues.add(clients);
            }
        } else {
            for (int i = 0; i < size; i++) {
                HBox clients = new HBox();
                clients.setPrefSize(550, 75);
                clients.setSpacing(-2);
                clients.setMaxWidth(Region.USE_PREF_SIZE);
                cashierQueues.add(clients);
            }
        }

        return cashierQueues;
    }

    static public void setClientsSpacing(int numberOfCashiers, VBox cashiersContainer) {
        int defaultSpacing = 300;
        if (numberOfCashiers == 1) {
            cashiersContainer.setSpacing(0);
        }
        else if (numberOfCashiers == 2) {
            double spacingValue = (defaultSpacing / (numberOfCashiers - 1)) - (numberOfCashiers * 50);
            cashiersContainer.setSpacing(spacingValue);
        }
        else if (numberOfCashiers == 3) {
            cashiersContainer.setPadding(new Insets(40, 0, 0, 0));
            double spacingValue = (defaultSpacing / (numberOfCashiers - 1)) - (numberOfCashiers * 10);
            cashiersContainer.setSpacing(spacingValue);
        }
        else if (numberOfCashiers == 4) {
            cashiersContainer.setPadding(new Insets(20, 0, 0, 0));
            double spacingValue = (defaultSpacing / (numberOfCashiers - 1)) - 15;
            cashiersContainer.setSpacing(spacingValue);
        } else {
            cashiersContainer.setPadding(new Insets(30, 0, 0, 0));
            double spacingValue = (defaultSpacing / (numberOfCashiers - 1)) - 20;
            cashiersContainer.setSpacing(spacingValue);
        }
    }

    static public VBox createQueuesBox(List<HBox> clientsQueues) {
        VBox queuesBox = new VBox();
        queuesBox.setAlignment(Pos.CENTER_RIGHT);
        for (int i = 0; i < clientsQueues.size(); i++) {
            HBox queue = clientsQueues.get(i);
            queue.setId("queue" + i);
            queuesBox.getChildren().add(queue);
        }

        return queuesBox;
    }



//    static public void generateClients(HBox clients, Animation animationInstance, numberOfCashiers) {
//        if (clients.getChildren().size() < 5) {
//            Client client = new Client();
//            clients.getChildren().add(client);
//            initialDistance += 10;
//
//            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.05));
//            pauseTransition.setOnFinished(event -> animationInstance.animateClient(client, initialDistance));
//            pauseTransition.play();
//        }
//    }
//    static public VBox generateClientDesks() {
//        VBox clientDesks = new VBox();
//        clientDesks.setAlignment(Pos.CENTER);
//        clientDesks.setSpacing(300);
//        clientDesks.setPadding(new Insets(40, 0, 0,0));
//        HBox clientDesks1 = new HBox();
//        HBox clientDesks2 = new HBox();
//        clientDesks1.setSpacing(80);
//        clientDesks1.setAlignment(Pos.CENTER_RIGHT);
//        clientDesks1.setPadding(new Insets(0, 60, 0, 0));
//        clientDesks2.setSpacing(80);
//        clientDesks2.setAlignment(Pos.CENTER_RIGHT);
//        clientDesks2.setPadding(new Insets(0, 60, 0, 0));
//
//        ClientDesk clientDesk1 = new ClientDesk();
//        ClientDesk clientDesk2 = new ClientDesk();
//        ClientDesk clientDesk3 = new ClientDesk();
//        ClientDesk clientDesk4 = new ClientDesk();
//
//        clientDesks1.getChildren().addAll(clientDesk1, clientDesk2);
//        clientDesks2.getChildren().addAll(clientDesk3, clientDesk4);
//        clientDesks.getChildren().addAll(clientDesks1, clientDesks2);
//
//        return clientDesks;
//    }
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

    static public void handlePizzaConfigurationButtonClick(Stage primaryStage, TextField numberOfCooks, TextField numberOfCashiers, TextField numberOfPizza, ChoiceBox<String> strategy, TextField minTime) {
        String selectedStrategy = strategy.getValue();
        pizzeriaSimulator = new PizzeriaSimulator(
                Integer.parseInt(numberOfCooks.getText()),
                Integer.parseInt(numberOfCashiers.getText()),
                new ArrayList<>(List.of(1)),
                convertToClientGenerationStrategy(selectedStrategy),
                Integer.parseInt(minTime.getText()));
        MainPage mainPage = new MainPage();
        mainPage.start(primaryStage);
    }


    private static ClientGenerationStrategies convertToClientGenerationStrategy(String selectedStrategy) {
        switch (selectedStrategy) {
            case "Regular Day":
                return ClientGenerationStrategies.Regular;
            case "Pizza Day":
                return ClientGenerationStrategies.PizzaDay;
            case "Weekend":
                return ClientGenerationStrategies.Weekend;
            default:
                return null;
        }
    }

    static public void setTextFieldLimit(TextField textField, int minValue, int maxValue) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                if (value < minValue) {
                    textField.setText(String.valueOf(minValue));
                } else if (value > maxValue) {
                    textField.setText(String.valueOf(maxValue));
                }
            } catch (NumberFormatException e) {
                textField.clear();
            }
        });
    }

    static public int getNumberOfCashier() {
        return pizzeriaSimulator.getAllCashiers().size();
    }

    static public int getNumberOfCooks() {
        return pizzeriaSimulator.getAllCooks().size();
    }
}