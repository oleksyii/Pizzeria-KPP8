package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.CooksManagement.TestTask;
import code.example.demo2.OrdersManagement.Task;

public class FullCook extends Cook{

    public FullCook(){
        this.currentTask = takeTask();
    }

    @Override
    public Task takeTask() {
        return new Task(1, 1);
    }

    @Override
    public void processPizza() {
        takeTask();

        try {
            System.out.println("FullCook thread is running. Task: " + this.Task);
            Thread.sleep(COOKING_TIME); // Simulating some work
        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
        }

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

    public void run() {
        processPizza();
    }
}
