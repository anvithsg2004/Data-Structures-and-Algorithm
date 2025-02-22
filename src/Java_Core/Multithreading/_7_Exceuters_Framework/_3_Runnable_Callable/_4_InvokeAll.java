package Java_Core.Multithreading._7_Exceuters_Framework._3_Runnable_Callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _4_InvokeAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1 ");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2 ");
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3 ");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        //Until all the tasks given would not complete then it won't go to next tasks.
        //This will block all others.
        List<Future<Integer>> futures = executor.invokeAll(list);

        executor.shutdown();

    }

}
