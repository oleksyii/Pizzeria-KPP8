package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PizzaDayGenerator implements ClientGenerator,Runnable{
    private final int interval = 5;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private ClientGeneratorContext clientGeneratorContext = ClientGeneratorContext.getInstance();
    @Override
    public void generateClients() {
        scheduler.scheduleAtFixedRate(this::generateClient, 0, interval, TimeUnit.SECONDS);

    }

    private void generateClient() {

        PizzeriaClient client = new PizzeriaClient();
        client.makeOrder();
        clientGeneratorContext.addClient(client);

    }

    @Override
    public void run() {

    }
}
