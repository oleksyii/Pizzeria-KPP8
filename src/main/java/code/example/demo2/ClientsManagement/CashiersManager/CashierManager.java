package code.example.demo2.ClientsManagement.CashiersManager;

import code.example.demo2.ClientsManagement.PizzeriaClient;

import java.util.ArrayList;
import java.util.List;

public class CashierManager {


    private static List<Cashier> cashiers = new ArrayList<>();

    private static int cashierAmount;

    public CashierManager(int cashiersAmount){
        createCashiers(cashiersAmount);
    }


    public Cashier getCashierWithSmallestQueue() {
        if (cashiers.isEmpty()) {
            return null; // No cashiers available
        }

        Cashier smallestQueueCashier = cashiers.get(0);

        for (Cashier cashier : cashiers) {
            if (cashier.getClientsQueue().size() < smallestQueueCashier.getClientsQueue().size()) {
                smallestQueueCashier = cashier;
            }
        }

        return smallestQueueCashier;
    }

    public void addClientToCashierWithSmallestQueue(PizzeriaClient pizzeriaClient) {
        Cashier smallestQueueCashier = getCashierWithSmallestQueue();

        if (smallestQueueCashier != null) {
            smallestQueueCashier.addClient(pizzeriaClient);
        } else {
            System.out.println("No cashiers available.");
        }

        // TODO: call controller and send a cashier that was chosen
    }

    public void createCashiers(int amount){
        cashierAmount = amount;
        for(int i = 0;i<amount;i++){
            Cashier cashier = new Cashier();
            cashiers.add(cashier);
        }

    }

    public List<Cashier> getCashiers(){

        return cashiers;
    }

    public void addCashier(Cashier cashier){
        cashiers.add(cashier);
    }

    public void setCashierAmount(int cashierAmount){
        cashierAmount = cashierAmount;
    }

    public int getCashierAmount(){
        return  cashierAmount;
    }





}
