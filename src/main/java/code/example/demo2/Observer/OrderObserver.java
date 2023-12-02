package code.example.demo2.Observer;

import java.io.FileWriter;
import java.io.IOException;

public class OrderObserver {
    private final String logFilePath;

    public OrderObserver(){
        logFilePath = "log.txt";
    }
    public OrderObserver(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void addNewRecord(String event) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            String logEntry = event + "\n";
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
