package Java_Core.Multithreading._7_Exceuters_Framework._3_Runnable_Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Runnable;

public class _3_RunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            System.out.println("Runnable Task Executed by: " + Thread.currentThread().getName());
        };

        // Submitting the task
        executor.submit(task);

        executor.shutdown();

    }
}
