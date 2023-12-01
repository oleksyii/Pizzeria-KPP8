package code.example.demo2.OrdersManagement;

public class Task {
    private int orderId;
    private int pizzaId;
    private PizzaStatus status;

    public Task(int orderId, int pizzaId){
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        status = PizzaStatus.NotTaken;
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

    public String getDescription(){
        return "Task{" +
                "orderId=" + orderId +
                ", pizzaId=" + pizzaId +
                ", status=" + status +
                '}';
    }
}
