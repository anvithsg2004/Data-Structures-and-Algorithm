package Multithreading_Questions._11_Create_and_Run_Simple;

public class SimpleTask implements Runnable {

    private String message;

    public SimpleTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running: " + message);
        try {
            Thread.sleep(1000); // Simulate work by sleeping for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished: " + message);
    }
}
