package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.Cook;
import code.example.demo2.OrdersManagement.PizzaStatus;

public class SpecificCook {
    static int id = 0;
    Cook strategy;

    SpecificCook(Cook strategy){
        id++;
        strategy.Id(id);
        this.strategy = strategy;
    }
    public void setStrategy(Cook strategy){
        System.out.println("Morphing the cook " + this.strategy.Id());
        strategy.Id(this.strategy.Id());
        this.strategy.interrupt();
        System.out.println("Morphed");
        this.strategy = strategy;
//        this.executeStrategy();
    }
    public void executeStrategy(){
        strategy.setDaemon(true); // Set the thread as daemon
        strategy.start();
    }
    public int Id(){return strategy.Id();}
    public void pause(){
        strategy.pauseCook();
    }

    @Override
    public String toString(){
        return "SpecificCook{" +
                "cookID=" + strategy.Id() +
                ", CookType=" + strategy.getType() +
                '}';
    }
}
