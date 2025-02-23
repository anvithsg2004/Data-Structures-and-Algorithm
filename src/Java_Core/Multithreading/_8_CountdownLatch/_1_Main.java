package Java_Core.Multithreading._8_CountdownLatch;

import java.util.concurrent.*;

public class _1_Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());

        future1.get();
        future2.get();
        future3.get();

        System.out.println("Add dependent service finished. Starting some service.");
        executorService.shutdown();

    }
}

class DependentService implements Callable<String> {
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Service Started.");
        Thread.sleep(3000);
        return "ok";
    }
}
