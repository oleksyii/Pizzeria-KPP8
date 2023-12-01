package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.Cook;

public class SpecificCook {
    static int id = 0;
    Cook strategy;

    SpecificCook(Cook strategy){
        id++;
        this.strategy = strategy;
    }
    public void setStrategy(Cook strategy){
        this.strategy.interrupt();
        this.strategy = strategy;
    }
    public void executeStrategy(){
        strategy.setDaemon(true); // Set the thread as daemon
        strategy.start();
    }
    public int Id(){return id;}
    public void pause(){
        strategy.pauseCook();
    }
}
