package code.example.demo2.ClientsManagement.GeneratorManager;

import code.example.demo2.ClientsManagement.CashiersManager.Cashier;
import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.OrderManager.Order;
import code.example.demo2.ClientsManagement.PizzeriaClient;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeekEndGenerator implements ClientGenerator{
    private final int interval = 40;
    private ClientGeneratorContext clientGeneratorContext = ClientGeneratorContext.getInstance();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    CashierManager cashierManager;

    public WeekEndGenerator(){

    }

    public String getName() {
        return "WeekEndDay";
    }

    @Override
    public void stopGeneration() {
        scheduler.shutdownNow();
    }

    public WeekEndGenerator(CashierManager cashierManager){

        this.cashierManager = cashierManager;
    }
    @Override
    public void generateClients() {
        scheduler.scheduleAtFixedRate(this::generateClient, 0, interval, TimeUnit.SECONDS);

    }

    public void processClient(PizzeriaClient client) {
        Order order = client.makeOrder();
        Cashier cashier = client.chooseQueue(this.cashierManager);
        PizzeriaController.generateClientsForCashiers(order.getId(), cashier.getId());
    }

    private void generateClient() {

        PizzeriaClient client = new PizzeriaClient();
        processClient(client);
        clientGeneratorContext.addClient(client);

    }


}
