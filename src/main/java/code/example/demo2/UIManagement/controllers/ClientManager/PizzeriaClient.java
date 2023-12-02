package code.example.demo2.UIManagement.controllers.ClientManager;

import code.example.demo2.UIManagement.controllers.GeneratorManager.ClientGenerator;
import code.example.demo2.UIManagement.controllers.GeneratorManager.RegularDayGenerator;
import code.example.demo2.UIManagement.controllers.OrderManager.Order;

import java.util.*;

public class PizzeriaClient {
    private static int nextClientId = 1;
    int clientId;
    Order order;

    public PizzeriaClient(){

    this.clientId = nextClientId++;

    }

    public void chooseQueue(){


    }

    public String showOrder(){
        return "Order_id: "+ order.getId()+
                "\nOrder_status: " + order.getOrderStatus()+
                "\nOrdered Pizzas:"+ order.getPizzas().size();

    }

    public void makeOrder(){
        Random random = new Random();
        Map<Integer,Integer> pizzas = new HashMap<>();
        for(int i =1; i<11;i++){
            pizzas.put(i, random.nextInt(4));

        }
        order = new Order(pizzas);
        order.setClientId(clientId);



    }

    public void takeOrderAndLeave(){
        order.giveAwayOrder();


    }

}
