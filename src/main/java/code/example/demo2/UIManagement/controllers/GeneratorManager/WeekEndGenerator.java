package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeekEndGenerator implements ClientGenerator{
    private final int interval = 10;
    private ClientGeneratorContext clientGeneratorContext = ClientGeneratorContext.getInstance();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void generateClients() {
        scheduler.scheduleAtFixedRate(this::generateClient, 0, interval, TimeUnit.SECONDS);

    }

    private void generateClient() {

        PizzeriaClient client = new PizzeriaClient();
        client.makeOrder();
        clientGeneratorContext.addClient(client);

    }
}
