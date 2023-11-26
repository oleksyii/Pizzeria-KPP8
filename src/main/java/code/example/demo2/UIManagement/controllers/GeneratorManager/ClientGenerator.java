package code.example.demo2.UIManagement.controllers.GeneratorManager;

import code.example.demo2.UIManagement.controllers.ClientManager.PizzeriaClient;

import java.util.List;

public interface ClientGenerator {

    int interval = 0;
   List<PizzeriaClient> generateClients();

}
