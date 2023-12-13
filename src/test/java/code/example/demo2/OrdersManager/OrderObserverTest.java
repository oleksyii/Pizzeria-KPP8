package code.example.demo2.OrdersManager;

import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.Observer.OrderObserver;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class OrderObserverTest {

    @Test
    public void testLogAdding(){
        OrderObserver o = new OrderObserver();
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        Order order = new Order(m);

        o.addNewRecord(order);
    }
}
