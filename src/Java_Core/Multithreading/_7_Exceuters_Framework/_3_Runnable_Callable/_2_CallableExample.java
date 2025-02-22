package Java_Core.Multithreading._7_Exceuters_Framework._3_Runnable_Callable;

import java.util.concurrent.*;

public class _2_CallableExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable Task (Returns a Value)
        Callable<Integer> task = () -> {
            System.out.println("Callable Task Executed by: " + Thread.currentThread().getName());
            return 10 + 20; // Returns a result
        };

        // Submitting Callable and getting Future
        Future<Integer> future = executor.submit(task);

        try {
            // Getting result from Future
            Integer result = future.get(); // Blocks until the result is available
            System.out.println("Callable Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }

}
