package Java_Core.Multithreading._8_CountdownLatch;

import java.util.concurrent.*;

public class _1_Main {

    static class DependentService implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " Service Started.");
            Thread.sleep(3000);
            return "ok";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DependentService task1 = new DependentService();
        DependentService task2 = new DependentService();
        DependentService task3 = new DependentService();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);

        future1.get();
        future2.get();
        future3.get();

        System.out.println("Add dependent service finished. Starting some service.");
        executorService.shutdown();

    }
}
