package Multithreading_Questions._9_Thread_Pool_with_ExecutorService;

public class Task implements Runnable {
    private int taskId;

    public Task(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being processed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate task execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " is completed by " + Thread.currentThread().getName());
    }
}
