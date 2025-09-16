package Multithreading_Questions._11_Create_and_Run_Simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            SimpleTask simpleTask = new SimpleTask("Task" + i);
            executor.submit(simpleTask);
        }

        executor.shutdown();

        System.out.println("All tasks submitted.");

    }
}
