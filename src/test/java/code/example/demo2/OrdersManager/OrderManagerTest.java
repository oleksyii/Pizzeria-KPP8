package code.example.demo2.OrdersManager;

import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.ClientsManagement.OrderManager.OrderStatus;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {
    @Test
    void testAddOrderAndCreateTasks() {
        // Arrange
        OrderManager orderManager = new OrderManager();
        List<Task> pizzaTaskList = OrderManager.getPizzaTaskList();
        Map<Integer, Integer> pizzaIdAmount = new HashMap<>();
        pizzaIdAmount.put(1, 2); // Sample pizza ID and amount
        pizzaIdAmount.put(9, 4);

        // Act

        Order order = new Order(pizzaIdAmount);
        OrderManager.addOrderAndCreateTasks(order);

        List<Task> updatedPizzaTaskList = OrderManager.getPizzaTaskList();

        // Assert

        assertEquals(6, updatedPizzaTaskList.size()); // Assuming the sample pizza ID is added twice
        assertEquals(OrderStatus.Procesing, order.getOrderStatus()); // Assuming initial order status is PENDING

    }

    @Test
    public void getAllPizzasTest(){
        // Arrange
        OrderManager orderManager = new OrderManager();
        List<Task> pizzaTaskList = OrderManager.getPizzaTaskList();
        Map<Integer, Integer> pizzaIdAmount = new HashMap<>();
        pizzaIdAmount.put(1, 2); // Sample pizza ID and amount
        pizzaIdAmount.put(9, 4);
        Order order = new Order(pizzaIdAmount);
        OrderManager.addOrderAndCreateTasks(order);

        // Act

        OrderManager.getPizzaTaskList().forEach(p -> p.setStatus(PizzaStatus.Baked));
        List<Task> updatedPizzaTaskList = OrderManager.getPizzaTaskList();

        // Assert
        assertEquals(OrderStatus.Completed, order.getOrderStatus());

        assertTrue(OrderManager.getOrderList().isEmpty());
        assertTrue(OrderManager.getPizzaTaskList().isEmpty());

    }

}