package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.FullCook;

public class CooksMain {
    public static void main(String[] args){
        FullCook daemonThread = new FullCook();
        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start();

        // Main thread continues its execution
        System.out.println("Main thread continues...");

        // Allow some time for the daemon thread to run
        try {
            for(int i = 0; i < 8; i++){
                System.out.println("Hello from main thread");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the daemon thread by interrupting it
        daemonThread.interrupt();
    }
}
