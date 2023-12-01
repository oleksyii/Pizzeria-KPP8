package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.CooksManagement.TestTask;

public class BakingCook extends Cook{
    public BakingCook(){
        this.Task = takeTask();
    }

    @Override
    public Task takeTask() {
        return TestTask.getListTasks().get(0);
    }

    @Override
    public void processPizza() {
        try {
            for(int i = 0; i < 6; i++) {
                // Code to be executed in the background
                System.out.println("Baking thread is running. Task: " + this.Task);
                Thread.sleep(1000); // Simulating some work
            }
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
