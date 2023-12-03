package code.example.demo2.ClientsManagement.GeneratorManager;

import code.example.demo2.ClientsManagement.PizzeriaClient;

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

    public synchronized void addClient(PizzeriaClient pizzeriaClient){
        currentClients.add(pizzeriaClient);
    }


    public static ClientGeneratorContext getInstance() {
        return INSTANCE;
    }


    //TODO: VLAD switch to create a strategy for yourself base on enum
    public void setStrategy(ClientGenerationStrategies strategy) {
//        this.strategy = strategy;
        this.strategy = new WeekEndGenerator();
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

