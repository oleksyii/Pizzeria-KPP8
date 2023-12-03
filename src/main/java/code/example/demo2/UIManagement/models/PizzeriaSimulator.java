package code.example.demo2.UIManagement.models;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.OrdersManagement.Menu;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.Task;
import code.example.demo2.ClientsManagement.CashiersManager.Cashier;
import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGeneratorContext;
import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.ClientsManagement.OrderManager.OrderStatus;

import java.util.List;

public class PizzeriaSimulator {

    private final Menu menu;
    private final KitchenManager kitchenManager;
    private final CashierManager cashierManager;
    private final OrderManager orderManager;
    private final ClientGeneratorContext generatorContext;

    public PizzeriaSimulator(int numOfCooks, int numOfCashiers, List<Integer> pizzasAvailable, ClientGenerationStrategies strategy, int minTimeCooking) {
        this.menu = new Menu();
        // Kitchen initialization
        this.kitchenManager =  new KitchenManager(numOfCooks);

        // Cashiers initialization
        this.cashierManager = new CashierManager(numOfCashiers);
        this.generatorContext = ClientGeneratorContext.getInstance();
        generatorContext.setStrategy(strategy);



        this.orderManager = new OrderManager();

        this.StartJob();
    }

    private void StartJob() {
        generatorContext.executeStrategy();

        kitchenManager.startCooks();
    }

    public void generateClients(){

    }

    public void StopCook(int cookId){

    }

    public String getDetailsAboutOrder(int orderId){
        return "no orders man";
    }

    public OrderStatus getOrderStatus(int orderId){
        return OrderManager.getOrder(orderId).getOrderStatus();
    }

    public List<Cashier> getAllCashiers(){
        return cashierManager.getCashiers();
    }

    public List<Order> getListOfOrders(){
        return OrderManager.getOrderList();
    }

    public List<Task> getAllTasks(){
        return OrderManager.getPizzaTaskList();
    }


}
