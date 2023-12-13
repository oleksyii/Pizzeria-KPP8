//TODO: make Task a list and sort through it

package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.CooksManagement.strategies.ThreadStopper.Stopper;
import code.example.demo2.OrdersManagement.OrderManager;
import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.ArrayList;
import java.util.List;

public class FullCook extends Cook{
    private volatile boolean isInterrupted = false;
    private Task currentTask;
    private CookStatus cookStatus;
    private List<PizzaStatus> pizzaStatuses = new ArrayList<>();
    private int id;
    private Stopper stopper;

    public FullCook(Stopper stopper){
        this.pizzaStatuses.add(PizzaStatus.NotTaken);
        this.pizzaStatuses.add(PizzaStatus.ReadyForBaking);
        this.stopper = stopper;
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

                // Spaghetti Code
                stopper.checkForSleep();
                Thread.sleep(1000);
            } catch (InterruptedException e){
                //Processing
                return null;
            }
        }
        return res;
    }


    @Override
    public void processPizza() {

        try {
            if(currentTask.getStatus() == PizzaStatus.Processing ){


                this.cookStatus = CookStatus.Creating;
                System.out.println("FullCook thread " + this.id + " is creating pizza Task: " + this.currentTask);
                PizzeriaController.startCookAnimation(this.id);

                PizzeriaController.setIsCookWorking(id, true);


                // Spaghetti Code
                stopper.checkForSleep();
                Thread.sleep(COOKING_TIME/2); // Simulating some work
//                currentTask.setStatus(PizzaStatus.ReadyForBaking);

                System.out.println("FullCook " + this.id + " thread is baking pizza Task: " + this.currentTask);


                this.cookStatus = CookStatus.Baking;
                currentTask.setStatus(PizzaStatus.Processing);
                PizzeriaController.finishCookAnimation(this.id);


                // Spaghetti Code
                stopper.checkForSleep();
                Thread.sleep(COOKING_TIME/2); // Simulating some work
                currentTask.setStatus(PizzaStatus.Baked);
                currentTask = null;

                PizzeriaController.setIsCookWorking(id, false);
            }
        } catch (InterruptedException e) {
            // Handle InterruptedException if needed
            currentTask = null;
            return;
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
        return "FullCook";
    }

    @Override
    public void execute(){
        System.out.println("Getting the task cook id: " + this.id);
        currentTask = takeTask();
        if(currentTask != null ){
            System.out.println("Got the task cook id: " + this.id);
            processPizza();
        }
    }

}
