package code.example.demo2.ClientsManagement.CashiersManager;

import java.util.ArrayList;
import java.util.List;

public class CashierManager {

    public CashierManager(int cashiersAmount){
        createCashiers(cashiersAmount);
    }
    private List<Cashier> cashiers = new ArrayList<>();

    private int cashierAmount;

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
        this.cashierAmount = cashierAmount;
    }

    public int getCashierAmount(){
        return  cashierAmount;
    }





}
