//TODO: make Task a list and sort through it

package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;

import java.util.ArrayList;
import java.util.List;

public class FullCook extends Cook{

    private Task currentTask;
    private CookStatus cookStatus;
    private List<PizzaStatus> pizzaStatuses = new ArrayList<>();
    private int id;

    public FullCook(){
        this.pizzaStatuses.add(PizzaStatus.NotTaken);
        this.pizzaStatuses.add(PizzaStatus.ReadyForBaking);
        this.currentTask = takeTask();

    }


    @Override
    public Task takeTask() {
        Task res = new Task(-1,-1);
        List<Task> tasks;
        while(res.getOrderId() == -1 ){
            tasks =  OrderManager.getPizzaTaskList();

            for (Task task :
                    tasks) {
                if(pizzaStatuses.contains(task.getStatus())){
                    res = task;
                    break;
                }
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                //Processing
            }
        }
        return res;
    }

    //TODO: CONTROLLER send signal to
    @Override
    public void processPizza() {

        try {
            if(currentTask.getStatus() == PizzaStatus.NotTaken){
                this.cookStatus = CookStatus.Creating;
                currentTask.setStatus(PizzaStatus.Processing);
                System.out.println("FullCook thread " + this.id + " is creating pizza Task: " + this.currentTask);

                //SEND SIGNAL HERE

                Thread.sleep(COOKING_TIME/2); // Simulating some work
                currentTask.setStatus(PizzaStatus.ReadyForBaking);

                System.out.println("FullCook thread is baking pizza Task: " + this.currentTask);
                this.cookStatus = CookStatus.Baking;
                currentTask.setStatus(PizzaStatus.Processing);

                //SEND SIGNAL HERE

                Thread.sleep(COOKING_TIME/2); // Simulating some work
                currentTask.setStatus(PizzaStatus.Baked);
                currentTask = null;
            }
        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
        }


    }

    @Override
    public void pauseCook() {
        try {
            System.out.println("Cook " + this.Id() +" is sleeping");
            Thread.sleep(10000); // Pausing

        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
        }
    }

    @Override
    public CookStatus Status() {return this.cookStatus;}

    @Override
    public int Id() {
        return this.id;
    }

    @Override
    public void Id(int id) {
        this.id = id;
    }

    public void run() {
        while(true){
            System.out.println("Getting the task cook id: " + this.id);
            currentTask = takeTask();
            System.out.println("Got the task cook id: " + this.id);
            processPizza();
        }
    }
}
