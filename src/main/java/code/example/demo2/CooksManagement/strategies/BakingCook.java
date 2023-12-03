package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;

import java.util.ArrayList;
import java.util.List;

public class BakingCook extends Cook{
    private Task currentTask;
    private CookStatus cookStatus;
    private List<PizzaStatus> pizzaStatuses = new ArrayList<>();
    private int id;

    public BakingCook(){
        this.pizzaStatuses.add(PizzaStatus.ReadyForBaking);
        this.currentTask = takeTask();

    }


    @Override
    public Task takeTask() {
        Task res = new Task(-1,-1);
        List<Task> tasks =  OrderManager.getPizzaTaskList();
        while(res.getOrderId() == -1){

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
            if(currentTask.getStatus() == PizzaStatus.ReadyForBaking){
                System.out.println("CreatingCook thread is creating pizza Task: " + this.currentTask);
                this.cookStatus = CookStatus.Creating;
                currentTask.setStatus(PizzaStatus.Processing);

                //SEND SIGNAL HERE

                Thread.sleep(COOKING_TIME/3); // Simulating some work
                currentTask.setStatus(PizzaStatus.Baked);

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
            takeTask();
            processPizza();
        }
    }
}
