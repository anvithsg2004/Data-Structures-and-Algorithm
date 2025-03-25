package Java_Core.Multithreading._10_CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Start a background task
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate work
                return 42;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 2. Apply a transformation when the task is done
        CompletableFuture<String> result = future.thenApply(value -> "The answer is " + value);

        // 3. Handle the result once it's ready
        result.thenAccept(System.out::println);  // Will print: The answer is 42

        // 4. Block until the result is available (optional, for waiting for the result)
        result.get();  // This makes the program wait for the result
    }
}
