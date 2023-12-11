package code.example.demo2.Observer;

import code.example.demo2.OrdersManagement.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskObserver {

    private static String logFilePath = "log.txt";

    public TaskObserver(){
    }
    public TaskObserver(String logFilePath) {
        TaskObserver.logFilePath = logFilePath;
    }

    public static void addNewRecord(Task task) {
        try {
            File file = new File(logFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String eventString = "Order id: "+ task.getOrderId() + "\t| task id: " + task.getTaskId() + "\t| pizza id: " + task.getPizzaId()  +  "\t| status: "  + task.getStatus() + " |";
            String logEntry = "[" + timestamp + "] " + eventString + "\n";
            writer.write(logEntry);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
