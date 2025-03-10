package Java_Core.Multithreading._7_Exceuters_Framework._2_With_Exceutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Method	                                Description
//execute(Runnable task)	                Executes a Runnable task.
//submit(Callable<T> task)	                Submits a task and returns a Future.
//shutdown()	                            Initiates an orderly shutdown.
//shutdownNow()	                            Attempts to stop all executing tasks immediately.
//invokeAll(Collection<Callable<T>> tasks)	Executes multiple tasks and waits for all to finish.
//invokeAny(Collection<Callable<T>> tasks)	Executes multiple tasks and returns the first completed result.

public class Main {

    public static long factorial(int n) {
        if (n == 0) return 1; // Handle factorial(0)

        long result = 1; // Use long to prevent overflow
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println("Factorial of " + finalI + " is: " + result);
            });
        }

//        executor.shutdown();

        try {
            // Wait for all tasks to finish
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Some tasks are still running...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total Time : " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
