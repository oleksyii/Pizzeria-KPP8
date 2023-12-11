package code.example.demo2.ClientsManagement;

import code.example.demo2.ClientsManagement.CashiersManager.Cashier;
import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.*;

public class PizzeriaClient {
    private static int nextClientId = 1;
    int clientId;
    Order order;

    public PizzeriaClient(){

    this.clientId = nextClientId++;


    }

    public int getClientId() {
        return this.clientId;
    }

    public Cashier chooseQueue(CashierManager cashierManager){
        Cashier cashier = cashierManager.addClientToCashierWithSmallestQueue(this);

        return cashier;
    }

    public String showOrder(){
        return "Order_id: "+ order.getId()+
                "\nOrder_status: " + order.getOrderStatus()+
                "\nOrdered Pizzas:"+ order.getPizzas().size();

    }

    public Order makeOrder(){
        Random random = new Random();
        Map<Integer,Integer> pizzas = new HashMap<>();
        for(int i =1; i<5;i++){
            pizzas.put(i, random.nextInt(2, 3));

        }
        order = new Order(pizzas);
        order.setClientId(clientId);

        OrderManager.addOrderAndCreateTasks(order);
        return order;
    }

    public void takeOrderAndLeave(){
        order.giveAwayOrder();
    }

}
