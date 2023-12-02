package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.Cook;

public class SpecificCook {
    static int id = 0;
    Cook strategy;

    SpecificCook(Cook strategy){
        id++;
        strategy.Id(id);
        this.strategy = strategy;
    }
    public void setStrategy(Cook strategy){
        strategy.Id(this.strategy.Id());
        this.strategy.interrupt();
        this.strategy = strategy;
    }
    public void executeStrategy(){
        strategy.setDaemon(true); // Set the thread as daemon
        strategy.start();
    }
    public int Id(){return strategy.Id();}
    public void pause(){
        strategy.pauseCook();
    }
}
