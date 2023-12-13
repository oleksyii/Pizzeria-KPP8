package code.example.demo2.CooksManagement;

import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.ClientsManagement.GeneratorManager.ClientGeneratorContext;
import code.example.demo2.OrdersManagement.Menu;
import code.example.demo2.OrdersManagement.OrderManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitchenManagerTest {

    @Test
    void stopCooks() {
        // Order Manager initialization
        OrderManager orderManager = new OrderManager();

        // Cashiers initialization
        CashierManager cashierManager = new CashierManager(5);
        ClientGeneratorContext generatorContext = ClientGeneratorContext.getInstance();
        generatorContext.setStrategy(ClientGenerationStrategies.PizzaDay, cashierManager);

        generatorContext.executeStrategy();

        // Kitchen initialization
        KitchenManager kitchenManager =  new KitchenManager(5, 10000);
        kitchenManager.startCooks();
        try {
            Thread.sleep(10000);
            System.out.println("About to stop cooks");

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        generatorContext.stopClientGeneration();
        kitchenManager.stopCooks();
        generatorContext = null;
        kitchenManager = null;

        try {
            Thread.sleep(20000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}