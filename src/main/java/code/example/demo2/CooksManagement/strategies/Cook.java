package code.example.demo2.CooksManagement.strategies;

import code.example.demo2.OrdersManagement.Task;

public abstract class Cook extends Thread {
    public static final int COOKING_TIME = 40000;
    protected Task currentTask;


    /***
     * Sort out the tasks based by a cook. For Full cook it could be anything
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
}



