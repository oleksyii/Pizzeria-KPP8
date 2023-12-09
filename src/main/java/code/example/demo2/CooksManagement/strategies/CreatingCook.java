package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.ArrayList;
import java.util.List;

public class CreatingCook extends Cook{
    private volatile boolean isInterrupted = false;
    private Task currentTask;
    private CookStatus cookStatus;
    private List<PizzaStatus> pizzaStatuses = new ArrayList<>();
    private int id;

    public CreatingCook(){
        this.pizzaStatuses.add(PizzaStatus.NotTaken);

    }


@Override
public Task takeTask() {
    Task res = null;
    List<Task> tasks;
    while(res == null ){
        tasks =  OrderManager.getPizzaTaskList();

        for (Task task :
                tasks) {
            if(pizzaStatuses.contains(task.getStatus())){
                res = task;
                res.setStatus(PizzaStatus.Processing);
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

    @Override
    public void processPizza() {
        try {
            if(currentTask.getStatus() == PizzaStatus.Processing){
                System.out.println("CreatingCook thread "  + this.id + " is creating pizza Task: " + this.currentTask);
                this.cookStatus = CookStatus.Creating;

                PizzeriaController.setIsCookWorking(id, true);

                Thread.sleep(COOKING_TIME/3); // Simulating some work
                currentTask.setStatus(PizzaStatus.ReadyForBaking);
                currentTask = null;

                PizzeriaController.setIsCookWorking(id, false);
            }
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

    @Override
    public Task getCurrentTask(){
        return currentTask;
    }
    @Override
    public String getType(){
        return "CreatingCook";
    }

    @Override
    public void execute(){
        System.out.println("Getting the task cook id: " + this.id);
        currentTask = takeTask();
        if(currentTask != null){
            System.out.println("Got the task cook id: " + this.id);
            processPizza();
        }
    }

}
