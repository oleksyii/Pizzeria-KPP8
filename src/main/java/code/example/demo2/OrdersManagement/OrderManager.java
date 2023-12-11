package code.example.demo2.OrdersManagement;

import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.ClientsManagement.OrderManager.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderManager {

    private static List<Order> orders;
    private static List<Task> pizzaTaskList;
    private static int tasksIds = 0;


    public OrderManager(){
        orders = new ArrayList<>();
        pizzaTaskList = new ArrayList<>();
    }

    /***
     * check if all tasks from order are in Baked status
     * if yes -> mark Order as completed -> call giveAwayOrder
     *  -> remove tasks and orders from lists
     * @return List of tasks available for cooks
     */
    public static synchronized List<Task>  getPizzaTaskList() {

        List<Order> ordersToRemove = new ArrayList<>();
        List<Task> tasksToRemove = new ArrayList<>();

        Map<Order, List<Task>> mapOrderTasks = pizzaTaskList.stream()
                .collect(Collectors.groupingBy(task -> getOrder(task.getOrderId())));
                mapOrderTasks.forEach((order, tasks) -> {
            if (tasks.stream().allMatch(task -> task.getStatus() == PizzaStatus.Baked)) {
//                order.setStatus(OrderStatus.Completed);
                order.giveAwayOrder();

                System.out.println("Removed order " + order);
                ordersToRemove.add(order);
                tasksToRemove.addAll(tasks);
            }
        });

        pizzaTaskList.removeAll(tasksToRemove);
        orders.removeAll(ordersToRemove);

        System.out.println("There are tasks " + pizzaTaskList);

        return pizzaTaskList;
    }

    public void setPizzaTaskList(List<Task> pizzaTaskList) {
        OrderManager.pizzaTaskList = pizzaTaskList;
    }

    public static List<Order> getOrderList(){
        return orders;
    }

    public static Order getOrder(int orderId){
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public static synchronized void addOrderAndCreateTasks(Order order) {
        if (order == null){
            return;
        }

        order.setStatus(OrderStatus.Procesing);
        orders.add(order);

        order.getPizzas().forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                pizzaTaskList.add(new Task(order.getId(), key, tasksIds++));
            }
        });

        System.out.println("Received order,sliced by tasks: " + order);
    }
}
