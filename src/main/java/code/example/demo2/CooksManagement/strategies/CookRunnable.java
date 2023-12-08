package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.PizzaStatus;

public class CookRunnable implements Runnable{
    private Cook strategy;
    private int Id;

    public CookRunnable(Cook strategy, int id) {
        this.strategy = strategy;
        this.Id = id;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            strategy.execute();
        }
    }
    public void pauseCook() {
        try {
            System.out.println("Cook " + this.Id +" is sleeping");
            Thread.sleep(10000); // Pausing

        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
        }
    }


    public String getType(){
        return strategy.getType();
    }
    public CookStatus getStatus() {
        return strategy.Status();
    }

    public Cook getStrategy() {
        return strategy;
    }

    public void setStrategy(Cook strategy) {
        if(this.strategy.getCurrentTask() != null){
            this.strategy.getCurrentTask().setStatus(PizzaStatus.NotTaken);
            strategy.Id(this.Id);
        }
//        strategy.Id(this.Id);
        this.strategy = strategy;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
