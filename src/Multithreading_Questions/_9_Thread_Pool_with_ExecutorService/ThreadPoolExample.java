package Multithreading_Questions._9_Thread_Pool_with_ExecutorService;

import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 5; i++) {
            Task task = new Task(i);
            Future<?> submit = executor.submit(task);
        }

        // Initiate shutdown after tasks are submitted
        executor.shutdown();

        try {
            // Wait until all tasks are finished or timeout occurs
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks are not completed
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed, executor shut down.");

        Callable<Integer> callable = () -> {
            System.out.println("Task Completed");
            return 1;
        };
    }
}
