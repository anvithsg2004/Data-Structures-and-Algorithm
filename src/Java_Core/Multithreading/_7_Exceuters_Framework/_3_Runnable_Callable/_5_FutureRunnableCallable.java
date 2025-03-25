package Java_Core.Multithreading._7_Exceuters_Framework._3_Runnable_Callable;

import java.util.concurrent.*;

public class _5_FutureRunnableCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable: No return value
        Runnable task1 = () -> System.out.println("Runnable task is running...");
        Future<?> future1 = executor.submit(task1); // Returns Future<?> but always null
        System.out.println("Runnable result: " + future1.get()); // Will print "null"

        // Callable: Returns a value
        Callable<Integer> task2 = () -> {
            Thread.sleep(1000);
            return 42; // Returns a value
        };
        Future<Integer> future2 = executor.submit(task2); // Returns Future<Integer>
        System.out.println("Callable result: " + future2.get()); // Prints 42

        executor.shutdown();
    }
}
