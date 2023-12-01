package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.ArrayList;
import java.util.List;

public class ClientGeneratorContext  {


        private static final ClientGeneratorContext INSTANCE = new ClientGeneratorContext();


        private ClientGenerator strategy;
        private List<PizzeriaClient> currentClients;


        private ClientGeneratorContext() {
            this.strategy = null; // You might want to set a default strategy
            this.currentClients = new ArrayList<>();
        }


        public static ClientGeneratorContext getInstance() {
            return INSTANCE;
        }


        public void setStrategy(ClientGenerator strategy) {
            this.strategy = strategy;
        }


        public void executeStrategy(int numOfCashiers) {
            if (strategy != null) {
                currentClients = strategy.generateClients();
            } else {
                System.out.println("Please set a strategy before executing.");
            }
        }


        public List<PizzeriaClient> getClientsList() {
            return new ArrayList<>(currentClients);
        }
}

