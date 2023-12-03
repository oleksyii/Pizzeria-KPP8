package code.example.demo2.OrdersManagement;

public class Task {
    private final int orderId;
    private final int pizzaId;
    private PizzaStatus status;
    private int id = 0;

    public Task(int orderId, int pizzaId, int taskId){
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        status = PizzaStatus.NotTaken;
        id = taskId;
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
