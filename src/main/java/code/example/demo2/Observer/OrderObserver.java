package code.example.demo2.Observer;

import code.example.demo2.ClientsManagement.OrderManager.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderObserver {
    private static String logFilePath = "log.txt";

    public OrderObserver(){
    }
    public OrderObserver(String logFilePath) {
        OrderObserver.logFilePath = logFilePath;
    }

    public static void addNewRecord(Order order) {
        try {
            File file = new File(logFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String eventString = "Order id: " + String.valueOf(order.getId()) + " | status: "  + order.getOrderStatus() + "\t|";
            String logEntry = "[" + timestamp + "] " + eventString + "\n";
            writer.write(logEntry);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
