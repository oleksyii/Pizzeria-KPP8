package code.example.demo2.ClientsManagement.GeneratorManager;

import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.PizzeriaClient;

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
    public WeekEndGenerator(CashierManager cashierManager){

        this.cashierManager = cashierManager;
    }
    @Override
    public void generateClients() {
        scheduler.scheduleAtFixedRate(this::generateClient, 0, interval, TimeUnit.SECONDS);

    }

    private void generateClient() {

        PizzeriaClient client = new PizzeriaClient();
        client.makeOrder();
        client.chooseQueue(this.cashierManager);
        clientGeneratorContext.addClient(client);

    }
}
