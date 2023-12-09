package code.example.demo2.ClientsManagement.GeneratorManager;

import code.example.demo2.ClientsManagement.CashiersManager.Cashier;
import code.example.demo2.ClientsManagement.CashiersManager.CashierManager;

public interface ClientGenerator {

    int interval = 0;
   void generateClients();
   String getName();

}
