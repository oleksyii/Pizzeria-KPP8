package code.example.demo2.CooksManagement.strategies.ThreadStopper;

public class Stopper {
    private boolean cookHasToSleep = false;

    public synchronized void checkForSleep() throws InterruptedException {
        try{
            if (cookHasToSleep) {
                System.out.println("Having a break...");
//            wait(); // Release the lock and wait for notification
                Thread.sleep(10000);
                System.out.println("Back to work!");
                cookHasToSleep = false;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public synchronized void putCookToSleep() {
        System.out.println("Putting a cook to sleep...");
        cookHasToSleep = true;
//        notify(); // Notify waiting threads that the condition is now met
    }
}
