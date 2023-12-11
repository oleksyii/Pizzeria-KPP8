package code.example.demo2.UIManagement.controllers;

import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.Observer.OrderObserver;
import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import com.example.demo2.MainPage.*;
import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import com.example.demo2.Configuration.PizzaConfiguration;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
import java.util.Iterator;
import java.util.List;

public class PizzeriaController {
    static private VBox uiCooks;
    static private StackPane uiTable = new StackPane();
    static private List<HBox> cashierQueuesUi;
    static private PizzeriaSimulator pizzeriaSimulator;
    private static long lastClickTime = 0;
    private static final long DOUBLE_CLICK_TIME_DELTA = 30000;

    static public void handleSettingsButtonClick(Stage primaryStage) {
        SettingsPage settings = PizzeriaSimulator.getInstance().getSettingsPage();
        settings.start(primaryStage);
    }

    static public void handleCloseButtonClick(Stage primaryStage) {
        MainPage main = PizzeriaSimulator.getInstance().getMainPage();
        main.start(primaryStage);
    }

    static public void startCookAnimation(int cookId) {
        Animation.startCookAnimation(cookId - 1);
    }

    static public void finishCookAnimation(int cookId) {
        Animation.finishCookAnimation(cookId - 1);
    }

    static public void handleMenuButtonClick(Stage primaryStage) {
        MenuPage menu = PizzeriaSimulator.getInstance().getMenuPage();
        menu.start(primaryStage);
    }

    static public void handleStartMainPageButtonClick(Stage primaryStage) {
        MainPage main = PizzeriaSimulator.getInstance().getMainPage();
        main.start(primaryStage);
    }

    static public void orderCreated(int id) {
        System.out.println("Order created" + id);
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
            CookState cookState = KitchenManager.getCookStatus(i + 1) == CookStatus.Baking ?
                    CookState.AT_OVEN:
                    CookState.AT_TABLE;
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

    static public void generateClientsForCashiers(int orderId, int cashierId) {

        double initialDistance = -400;

        List<HBox> cashierQueues = PizzeriaController.getCashierQueuesUi();
        if(cashierQueues == null) return;
        for (int i = 0; i < cashierQueues.size(); i++) {
            HBox clientsQueue = cashierQueues.get(i);
            if (i + 1 == cashierId) {
                Platform.runLater(() -> {
                    Client client = new Client(orderId);
                    client.setOnMouseEntered(event -> {
                        client.showDetailsPopup(pizzeriaSimulator.showOrderByClientId(client.getOrderId()));
                    });
                    client.setOnMouseExited(event -> {
                        client.hideTooltip(client.getTooltip());
                    });
                    clientsQueue.getChildren().add(client);

                    double finalInitialDistance = initialDistance;
                    Animation.animateClient(client, finalInitialDistance);
                });
            }
        }
    }

    static public void orderFinished(int orderId) {

        System.out.println("orderFinished invoked " + orderId);
        List<HBox> cashierQueues = PizzeriaController.getCashierQueuesUi();
        if (cashierQueues == null) return;

        for (HBox clientsQueue : cashierQueues) {
            Platform.runLater(() -> {
                int indexToRemove = -1;
                for (int i = 0; i < clientsQueue.getChildren().size(); i++) {
                    Node node = clientsQueue.getChildren().get(i);
                    if (node instanceof Client) {
                        Client client = (Client) node;
                        if (orderId == client.getOrderId()) {
                            indexToRemove = i;
                            Animation.animateClientRemoval(client, clientsQueue, indexToRemove);

                            break;
                        }
                    }
                }
            });
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

        cashierQueuesUi = cashierQueues;

        return cashierQueues;
    }

    public static List<HBox> getCashierQueuesUi() {
        return cashierQueuesUi;
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

    static public void handlePizzaConfigurationButtonClick(Stage primaryStage, TextField numberOfCooks, TextField numberOfCashiers, TextField numberOfPizza, ChoiceBox<String> strategy, TextField minTime) {

        String selectedStrategy = (strategy != null && strategy.getValue() != null && !strategy.getValue().isEmpty())
                ? strategy.getValue()
                : "Regular Day";
        PizzeriaSimulator.setInstance(
                Integer.parseInt(numberOfCooks.getText()),
                Integer.parseInt(numberOfCashiers.getText()),
                new ArrayList<>(List.of(1)),
                convertToClientGenerationStrategy(selectedStrategy),
                Integer.parseInt(minTime.getText())* 500);
        pizzeriaSimulator = PizzeriaSimulator.getInstance();
        MainPage mainPage = pizzeriaSimulator.getMainPage();
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

    static public void setIsCookWorking(Integer index, boolean isCookWorking) {
        Platform.runLater(() -> {
            Cook cook = (Cook) uiCooks.getChildren().get(index - 1);
            cook.setIsCookWorking(isCookWorking);
        });
    }
}