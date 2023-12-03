package code.example.demo2.UIManagement.models;

import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.OrdersManagement.Menu;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.Task;
import code.example.demo2.UIManagement.controllers.CashiersManager.Cashier;
import code.example.demo2.UIManagement.controllers.CashiersManager.CashierManager;
import code.example.demo2.UIManagement.controllers.GeneratorManager.ClientGeneratorContext;
import code.example.demo2.UIManagement.controllers.OrderManager.Order;
import code.example.demo2.UIManagement.controllers.OrderManager.OrderStatus;

import java.util.List;

public class PizzeriaSimulator {

    private final Menu menu;
    private KitchenManager kitchenManager;
    private final CashierManager cashierManager;
    private final OrderManager orderManager;
    private ClientGeneratorContext generatorContext;

    public PizzeriaSimulator() {
        this.menu = new Menu();
        this.kitchenManager =  new KitchenManager() ;
        this.cashierManager = new CashierManager();
        this.orderManager = new OrderManager();
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
        return orderManager.getOrderList();
    }

    public List<Task> getAllTasks(){
        return OrderManager.getPizzaTaskList();
    }


}
