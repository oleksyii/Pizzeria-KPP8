package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.ArrayList;
import java.util.List;

public class ClientGeneratorContext  {


    private static final ClientGeneratorContext INSTANCE = new ClientGeneratorContext();


    private ClientGenerator strategy;
    private List<PizzeriaClient> currentClients;


    private ClientGeneratorContext() {
        this.strategy = null;
        this.currentClients = new ArrayList<>();
    }

    public void addClient(PizzeriaClient pizzeriaClient){
        currentClients.add(pizzeriaClient);
    }


    public static ClientGeneratorContext getInstance() {
        return INSTANCE;
    }


    public void setStrategy(ClientGenerator strategy) {
        this.strategy = strategy;
    }


    public void executeStrategy() {
        if (strategy != null) {
            strategy.generateClients();
        } else {
            System.out.println("Please set a strategy before executing.");
        }
    }


    public List<PizzeriaClient> getClientsList() {
        return new ArrayList<>(currentClients);
    }
}

