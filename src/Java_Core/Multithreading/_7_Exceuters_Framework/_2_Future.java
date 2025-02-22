package Java_Core.Multithreading._7_Exceuters_Framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//🔹 What is Future in Simple Words?
//Imagine you order food online. You don’t wait at the restaurant; instead, you continue watching a movie.
//Later, you check your phone to see if the food is delivered.
//In Java, Future works the same way!
//You submit a task (like ordering food).
//The task runs in the background (like the restaurant preparing food).
//You can check if it’s done (isDone()).
//You can wait for the result (get()).
//You can cancel it if needed (cancel()).

public class _2_Future {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Submitting a task that returns a value after 2 seconds
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulate time-consuming task
            return "Task Completed!";
        });

        System.out.println("Doing other work while the task runs...");

        try {
            // Get result when ready (blocks until task is finished)
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}
