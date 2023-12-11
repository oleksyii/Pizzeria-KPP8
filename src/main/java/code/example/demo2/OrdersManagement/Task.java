package code.example.demo2.OrdersManagement;

import code.example.demo2.Observer.TaskObserver;

public class Task {
    private final int orderId;
    private final int pizzaId;
    private PizzaStatus status;
    private int id = 0;

    public Task(int orderId, int pizzaId, int taskId){
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        id = taskId;
        this.setStatus(PizzaStatus.NotTaken);
    }

    public int getTaskId(){
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
        notifyObserver();
    }

    public void notifyObserver(){
        TaskObserver.addNewRecord(this);
    }

    @Override
    public String toString(){
        return "Task{" +
                "orderId=" + orderId +
                ", pizzaId=" + pizzaId +
                ", status=" + status +
                ", taskId=" + id +
                '}';
    }
}
