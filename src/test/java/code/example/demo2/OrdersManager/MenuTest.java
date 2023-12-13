package code.example.demo2.OrdersManager;

import code.example.demo2.OrdersManagement.Menu;
import code.example.demo2.OrdersManagement.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {


        @Test
        void testGetPizzaById() {
            // Arrange

            List<Integer> ids = new ArrayList<>();
            ids.add(2);
            ids.add(4);
            ids.add(6);
            Menu menu = new Menu(ids);
            menu.setPizzas(List.of(
                     "Margherita",
                     "Pepperoni",
                    "Vegetarian"
            ));

            // Act
            String foundPizza = menu.getPizzaById(2);

            // Assert
            assertEquals("Pepperoni", foundPizza);
        }

        @Test
        void testGetPizzaByIdNotFound() {
            List<Integer> ids = new ArrayList<>();
            ids.add(2);
            ids.add(4);
            Menu menu = new Menu(ids);
            menu.setPizzas(List.of(
                    "Margherita",
                    "Vegetarian"
            ));

            String foundPizza = menu.getPizzaById(3);

            assertEquals("",  foundPizza);
        }

    @Test
    void testGetIdByName() {
        // Arrange
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(4);
        Menu menu = new Menu(ids);        menu.setPizzas(List.of(
                "Margherita",
                 "Pepperoni",
                 "Vegetarian"
        ));

        // Act
        int foundPizzaId = menu.getIdByName("Pepperoni");

        // Assert
        assertEquals(2, foundPizzaId);
    }

    @Test
    void testGetIdByNameNotFound() {
        // Arrange
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(4);
        Menu menu = new Menu(ids);
        menu.setPizzas(List.of(
                 "Margherita",
                "Vegetarian"
        ));

        // Act
        Integer foundPizzaId = menu.getIdByName("Hawaiian");

        // Assert
        assertEquals(0, foundPizzaId);
    }

    @Test
    void testGetCurrentState() {
        // Arrange
        Task task = new Task(1, 2, 1);

        // Act
        String currentState = task.toString();

        System.out.println(currentState);
        // Assert
        assertEquals("Task{orderId=1, pizzaId=2, status=NotTaken}", currentState);
    }

}