package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.CooksManagement.TestTask;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;

public class BakingCook extends Cook{
    public BakingCook(){
        this.currentTask = takeTask();
    }

    @Override
    public Task takeTask() {
        return new Task(1, 1);
    }

    @Override
    public void processPizza() {
        takeTask();
        // If slice or bake correspondingly to the pizza status
        while(currentTask.getStatus() != PizzaStatus.Baked){
            try {
                if(currentTask.getStatus() == PizzaStatus.ReadyForBaking){
                    System.out.println("FullCook thread is creating pizza Task: " + this.currentTask);
                    this.cookStatus = CookStatus.Creating;
                    currentTask.setStatus(PizzaStatus.Processing);
                    Thread.sleep(COOKING_TIME); // Simulating some work
                    currentTask.setStatus(PizzaStatus.Baked);
                }
            } catch (InterruptedException e) {
                // Handle InterruptedException if needed
            }
        }
        currentTask.setStatus(PizzaStatus.Baked);

    }

    @Override
    public void pauseCook() {
        try {
            System.out.println("Cook is sleeping");
            Thread.sleep(10000); // Pausing

        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
        }
    }

    @Override
    public CookStatus Status() {return this.cookStatus;}

    public void run() {
        processPizza();
    }
}
