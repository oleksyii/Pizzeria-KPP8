package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.PizzaStatus;
import code.example.demo2.OrdersManagement.Task;

import java.util.List;

public abstract class Cook extends Thread {
    public static int COOKING_TIME = 0;


    /***
     * Sort out the tasks based by a cook from OrderManager. For Full cook it could be anything
     * for a baking or creating cook, there are some limitations
     * @return Task, that should be processed by cook.
     */
    public abstract Task takeTask();

    /***
     * Make the cook sleep for n seconds.
     */
    public abstract void processPizza();
    /**
     * Function to pause a thread
     * */
    public abstract void pauseCook();
//    public abstract void notifyControllerWithStatus();
    public abstract CookStatus Status();
    public abstract int Id();
    public abstract void Id(int id);
    public abstract Task getCurrentTask();
    public abstract void customInterrupt();
    public abstract String getType();
}



