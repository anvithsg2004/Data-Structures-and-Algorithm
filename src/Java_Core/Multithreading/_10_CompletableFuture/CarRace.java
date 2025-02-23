package Java_Core.Multithreading._10_CompletableFuture;

import java.util.concurrent.*;

class Racer implements Callable<Void> {
    private CyclicBarrier barrier;
    private String name;

    public Racer(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public Void call() {
        try {
            System.out.println(name + " is getting ready...");
            Thread.sleep((long) (Math.random() * 3000)); // Simulate preparation time
            System.out.println(name + " is ready!");

            barrier.await(); // Wait for all racers to be ready

            System.out.println(name + " starts racing!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class CarRace {
    public static void main(String[] args) {
        // Barrier for 3 racers + a final task
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All racers are ready! The race begins!");
        });

        // ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Creating CompletableFutures for racers
        CompletableFuture<Void> car1 = CompletableFuture.supplyAsync(() -> {
            new Racer(barrier, "Car 1").call();
            return null;
        }, executor);

        CompletableFuture<Void> car2 = CompletableFuture.supplyAsync(() -> {
            new Racer(barrier, "Car 2").call();
            return null;
        }, executor);

        CompletableFuture<Void> car3 = CompletableFuture.supplyAsync(() -> {
            new Racer(barrier, "Car 3").call();
            return null;
        }, executor);

        // Wait for all racers to finish
        CompletableFuture.allOf(car1, car2, car3).join();

        System.out.println("Race finished!");

        // Shutdown executor
        executor.shutdown();
    }
}
