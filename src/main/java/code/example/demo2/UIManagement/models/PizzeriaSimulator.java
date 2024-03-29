package code.example.demo2.UIManagement.models;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.ClientsManagement.PizzeriaClient;
import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.CooksManagement.SpecificCook;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.OrdersManagement.Menu;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.Task;
import code.example.demo2.ClientsManagement.CashiersManager.Cashier;
import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGeneratorContext;
import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.ClientsManagement.OrderManager.OrderStatus;
import com.example.demo2.MainPage.MainPage;
import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PizzeriaSimulator {

    private static PizzeriaSimulator instance;

    private Menu menu;
    private KitchenManager kitchenManager;
    private CashierManager cashierManager;
    private OrderManager orderManager;
    private ClientGeneratorContext generatorContext;

    private static MainPage mainPage;
    private static Scene mainPageScene;
    private static Scene menuPageScene;
    private static Scene settingsPageScene;
    private static SettingsPage settingsPage;
    private static MenuPage menuPage;

    private PizzeriaSimulator(int numOfCooks, int numOfCashiers, List<Integer> pizzasAvailable, ClientGenerationStrategies strategy, int minTimeCooking) {
        mainPage = null;
        mainPageScene = null;
        menuPageScene = null;
        settingsPageScene = null;
        settingsPage = null;
        menuPage = null;
        this.generateScreens();
        // Order Manager initialization
        this.orderManager = new OrderManager();
        this.menu = new Menu(pizzasAvailable);

        // Cashiers initialization
        this.cashierManager = new CashierManager(numOfCashiers);
        this.generatorContext = ClientGeneratorContext.getInstance();
        generatorContext.setStrategy(strategy, this.cashierManager);

        generatorContext.executeStrategy();

        // Kitchen initialization
        this.kitchenManager =  new KitchenManager(numOfCooks, minTimeCooking);

        this.StartJob();
    }

    public static synchronized PizzeriaSimulator setInstance(int numOfCooks, int numOfCashiers, List<Integer> pizzasAvailable, ClientGenerationStrategies strategy, int minTimeCooking) {
        instance = new PizzeriaSimulator(numOfCooks, numOfCashiers, pizzasAvailable, strategy, minTimeCooking);
        return instance;
    }

    public static synchronized PizzeriaSimulator getInstance() {
        return instance;
    }

    public String getPizzaSimulatorStrategy() {
        return generatorContext.getStrategy();
    }

    public Menu getMenu(){
        return menu;
    }

    public void setMainScene(Scene scene) {
        mainPageScene = scene;
    }

    public Scene getMainScene() {
        return  mainPageScene;
    }

    public Scene getMenuScene() {
        return  menuPageScene;
    }

    public void setMenuScene(Scene scene) {
        menuPageScene = scene;
    }

    public void setSettingsScene(Scene scene) {
        settingsPageScene = scene;
    }

    public Scene getSettingsScene() {
        return  settingsPageScene;
    }

    public void generateScreens() {
        mainPage = new MainPage();
        settingsPage = new SettingsPage();
        menuPage = new MenuPage();
    }

    public MainPage getMainPage() {
        return this.mainPage;
    }

    public SettingsPage getSettingsPage() {
        return this.settingsPage;
    }

    public MenuPage getMenuPage() {
        return this.menuPage;
    }

    public void addPizza(Integer id) {
        Set<Integer> pizzasIds = new HashSet<>(menu.getIdsSet());
        pizzasIds.add(id);
        menu = new Menu(new ArrayList<>(pizzasIds));
    }

    public void removePizza(Integer id) {
        Set<Integer> pizzasIds = new HashSet<>(menu.getIdsSet());
        pizzasIds.remove(id);
        menu = new Menu(new ArrayList<>(pizzasIds));
    }

    private void StartJob() {
        kitchenManager.startCooks();
    }

    public void generateClients() {
        // Implementation of client generation
    }

    public void StopCook(int cookId) {
        // Implementation of cook stopping
    }

    public String getDetailsAboutOrder(int orderId) {
        return "no orders man";
    }

    public OrderStatus getOrderStatus(int orderId) {
        return OrderManager.getOrder(orderId).getOrderStatus();
    }

    public CookStatus getCookStatus(int cookId) {
        return KitchenManager.getCookStatus(cookId);
    }

    public List<Cashier> getAllCashiers() {
        return cashierManager.getCashiers();
    }

    public List<Order> getListOfOrders() {
        return OrderManager.getOrderList();
    }

    public synchronized List<Task> getAllTasks() {
        return OrderManager.getPizzaTaskList();
    }

    public KitchenManager getKitchenManager() {
        return kitchenManager;
    }

    public List<SpecificCook> getAllCooks() {
        return kitchenManager.getCooks();
    }

    public String showOrderByClientId(int clientId) {
        return this.orderManager.getOrder(clientId).toString();
    }

    /**
     * <p>Clears cook threads and client generation</p>
     * NECESSARY to call before starting a new game
     */
    public void stopThreadsAndCleanResources(){
        generatorContext.stopClientGeneration();
        kitchenManager.stopCooks();

        //those are superstitions, idk if they're necessary
        generatorContext = null;
        kitchenManager = null;
        orderManager = null;
        cashierManager = null;

        // Threads are shut, restart this instance now
    }
}
