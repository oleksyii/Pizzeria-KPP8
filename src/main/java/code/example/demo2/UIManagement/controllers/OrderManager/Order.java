package code.example.demo2.UIManagement.controllers.OrderManager;

import java.util.Dictionary;
import java.util.Map;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private Map<Integer, Integer> pizzaIdAmount;
    private OrderStatus orderStatus;

    private int clientId;

    public Order(Map<Integer, Integer> pizzaIdAmount){

        this.orderId=nextOrderId++;
        this.pizzaIdAmount=pizzaIdAmount;

    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId(){
        return this.clientId;
    }

    public void setStatus(OrderStatus status){
        orderStatus = status;
    }

    public OrderStatus getOrderStatus(){
        return orderStatus;
    }

    public int getId(){
        return orderId;
    }

    public Map<Integer, Integer> getPizzas(){

        return pizzaIdAmount;
    }

    public Order giveAwayOrder(){
        orderStatus = OrderStatus.Completed;

        return this;
    }

    public void registerObserver(){

    }

    public void removeObserver(){

    }

    public void notifyObserver(String newRecord){


    }



}
