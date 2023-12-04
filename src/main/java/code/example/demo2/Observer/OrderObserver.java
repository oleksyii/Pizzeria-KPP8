package code.example.demo2.Observer;

import code.example.demo2.ClientsManagement.OrderManager.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderObserver {
    private final String logFilePath;

    public OrderObserver(){
        logFilePath = "log.txt";
    }
    public OrderObserver(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void addNewRecord(Order order) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String eventString = "Order id: " + String.valueOf(order.getId()) + " | status: "  + order.getOrderStatus() + " |";
            String logEntry = "[" + timestamp + "] " + eventString + "\n";
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//[2023-12-12 12:00:00] Order id: 23 | status: Processing |
}
