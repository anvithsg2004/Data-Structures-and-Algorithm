package Multithreading_Questions._12_Create_and_Run_Simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            SimpleTask task = new SimpleTask("Task " + i);
            Future<String> submit = executor.submit(task);
            try {
                System.out.println(submit.get());
            } catch (Exception ignored) {

            }

        }

        executor.shutdown();

        System.out.println("All completed.");
    }
}
