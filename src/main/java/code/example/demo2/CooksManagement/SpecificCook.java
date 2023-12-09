package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.Cook;
import code.example.demo2.CooksManagement.strategies.CookRunnable;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.OrdersManagement.PizzaStatus;

import java.util.ArrayList;


//TODO: separate threads logic from Cook and realizations and put into CookRunnable.

/***
 * Then run a start thread from specific cook and handle
 * strategy changes by using CookRunnable.setStrategy()
 */


public class SpecificCook {
    static int id = 0;
    CookRunnable runningCook;
    Thread workingThread;

    SpecificCook(Cook strategy){
        id++;
        strategy.Id(id);
        runningCook = new CookRunnable(strategy, id);
        this.runningCook.setStrategy(strategy);
    }
    public void setStrategy(Cook strategy){
        System.out.println("Morphing the cook " + this.runningCook.getId());

        this.runningCook.setStrategy(strategy);
        System.out.println("Morphed");
    }
    public String getCookType(){
        return strategy.getType();
    }
    public void executeStrategy(){
        workingThread = new Thread(runningCook, "Thread-"+runningCook.getId());
        workingThread.start();
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
