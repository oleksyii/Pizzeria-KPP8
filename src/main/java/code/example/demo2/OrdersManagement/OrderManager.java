package code.example.demo2.OrdersManagement;

import code.example.demo2.UIManagement.controllers.OrderManager.Order;
import code.example.demo2.UIManagement.controllers.OrderManager.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders;
    private List<Task> pizzaTaskList;

    public OrderManager(){
        orders = new ArrayList<>();
        pizzaTaskList = new ArrayList<>();
    }

    public  List<Task> getPizzaTaskList() {

        List<Integer> completedOrdersId = orders.stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.Completed)
                .map(Order::getId)
                .toList();

        pizzaTaskList.removeIf((task -> completedOrdersId.contains(task.getOrderId())));

        orders.removeIf(order -> order.getOrderStatus() == OrderStatus.Completed);

        return pizzaTaskList;
    }

    public void setPizzaTaskList(List<Task> pizzaTaskList) {
        this.pizzaTaskList = pizzaTaskList;
    }

    public Order getOrder(int orderId){
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public void addOrderAndCreateTasks(Order order) {
        order.setStatus(OrderStatus.Procesing);
        orders.add(order);

        order.getPizzas().forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                pizzaTaskList.add(new Task(order.getId(), key));
            }
        });
    }
}
