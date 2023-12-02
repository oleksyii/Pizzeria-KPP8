package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegularDayGenerator implements ClientGenerator {
    private final int interval = 20;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public List<PizzeriaClient> generateClients() {
        scheduler.scheduleAtFixedRate(this::generateClient, 0, interval, TimeUnit.SECONDS);
        return null;
    }

    private void generateClient() {

        PizzeriaClient client = new PizzeriaClient();
        client.makeOrder();

    }
}
