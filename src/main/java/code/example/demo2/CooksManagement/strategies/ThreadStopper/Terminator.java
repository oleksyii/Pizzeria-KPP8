package code.example.demo2.CooksManagement.strategies.ThreadStopper;

public class Terminator {
    private boolean threadHasToStop = false;

    public synchronized boolean checkForStop() {
        return threadHasToStop;

    }

    public synchronized void putCookToStop() {
        threadHasToStop = true;
    }
}
