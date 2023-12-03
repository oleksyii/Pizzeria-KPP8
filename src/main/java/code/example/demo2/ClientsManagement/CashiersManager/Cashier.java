package code.example.demo2.ClientsManagement.CashiersManager;

import code.example.demo2.ClientsManagement.PizzeriaClient;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Cashier {

    private static int nextClientId = 1;
    int cashierId;
    Queue<PizzeriaClient> clientsQueue = new ArrayDeque<>();

    public Cashier(){
        this.cashierId = nextClientId++;

    }

    public void addClient(PizzeriaClient pizzeriaClient){

        clientsQueue.add(pizzeriaClient);
    }

    public Queue<PizzeriaClient> getClientsQueue(){
        return clientsQueue;
    }


}
