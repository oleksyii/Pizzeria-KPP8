package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.Cook;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.OrdersManagement.PizzaStatus;

public class SpecificCook {
    static int id = 0;
    Cook strategy;
    Thread workingThread;

    SpecificCook(Cook strategy){
        id++;
        strategy.Id(id);
        this.strategy = strategy;
    }
    public void setStrategy(Cook strategy){
        System.out.println("Morphing the cook " + this.strategy.Id());

        strategy.Id(this.strategy.Id());
        this.workingThread.interrupt();

        System.out.println("Morphed");
        this.strategy = strategy;

        this.executeStrategy();
    }
    public void executeStrategy(){
//        strategy.setDaemon(true); // Set the thread as daemon
//        strategy.start();
        workingThread = new Thread(strategy, "Thread-"+strategy.Id());
    }
    public int Id(){return runningCook.getId();}

    public CookStatus getCookStatus(){return runningCook.getStatus();}
    public void pause(){
        runningCook.pauseCook();
    }

    @Override
    public String toString(){
        return "SpecificCook{" +
                "cookID=" + runningCook.getId() +
                ", CookType=" + runningCook.getType() +
                '}';
    }
}
