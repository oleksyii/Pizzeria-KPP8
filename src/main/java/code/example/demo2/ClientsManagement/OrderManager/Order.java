package code.example.demo2.ClientsManagement.OrderManager;

import code.example.demo2.Observer.OrderObserver;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.Map;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private Map<Integer, Integer> pizzaIdAmount;
    OrderObserver observer;
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

        //TODO: NOTIFY CONTROLLER ORDER FINISHED
        PizzeriaController.orderFinished(orderId);

        return this;
    }

    public void registerObserver(OrderObserver orderObserver){
        observer = orderObserver;
    }

    public void removeObserver(){

    }

    public void notifyObserver(Order newRecord){


    observer.addNewRecord(newRecord);

    }

    @Override
    public String toString(){
        return "Order{" +
                "\norderId=" + orderId +
                ", \norderStatus=" + orderStatus +
                ", \npizzas and ids=" + pizzaIdAmount +
                '}';
    }



}
