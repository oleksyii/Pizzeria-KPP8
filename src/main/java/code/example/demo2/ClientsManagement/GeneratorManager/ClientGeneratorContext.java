package code.example.demo2.ClientsManagement.GeneratorManager;

import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;
import code.example.demo2.ClientsManagement.PizzeriaClient;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ClientGeneratorContext  {
    private static ClientGeneratorContext INSTANCE = new ClientGeneratorContext();
    CashierManager cashierManager;

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

    public static void clearInstance() {
        INSTANCE = new ClientGeneratorContext();
    }

    public void setStrategy(ClientGenerationStrategies strategy, CashierManager cashierMan) {
          String strategyWork = strategy.toString();
          this.cashierManager = cashierMan;
          if(Objects.equals(strategyWork, "Regular")){
              this.strategy = new RegularDayGenerator(this.cashierManager);
          } else if (strategyWork == "Weekend") {
              this.strategy = new WeekEndGenerator(this.cashierManager);
          } else if (strategyWork =="PizzaDay") {
              this.strategy=new PizzaDayGenerator(this.cashierManager);
          }else{
              System.out.println("Incorrect strategy");
          }

    }

    public String getStrategy() {
        return strategy.getName();
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

