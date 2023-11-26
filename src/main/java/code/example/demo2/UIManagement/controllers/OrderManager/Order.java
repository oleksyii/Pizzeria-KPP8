package code.example.demo2.UIManagement.controllers.OrderManager;

import java.util.Dictionary;

public class Order {
    int orderId;
    Dictionary<Integer,Dictionary<Integer, Integer>> pizzaIdAmount;
    OrderStatus orderStatus;

    int clientId;

    public Order(int orderId,Dictionary<Integer,Dictionary<Integer, Integer>> pizzaIdAmount){

        this.orderId=orderId;
        this.pizzaIdAmount=pizzaIdAmount;

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

    public Dictionary<Integer,Dictionary<Integer, Integer>> getPizzas(){

        return pizzaIdAmount;
    }

    public Order giveAwayOrder(){
        return this;
    }

    public void registerObserver(){

    }

    public void removeObserver(){

    }

    public void notifyObserver(String newRecord){


    }



}
