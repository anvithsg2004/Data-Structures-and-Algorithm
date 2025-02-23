package Java_Core.Multithreading._9_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.BrokenBarrierException;

class Racer implements Runnable {
    private CyclicBarrier barrier;
    private String name;

    public Racer(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is getting ready...");
            Thread.sleep((long) (Math.random() * 3000)); // Simulating preparation time
            System.out.println(name + " is ready!");

            barrier.await(); // Wait for all racers to be ready

            System.out.println(name + " starts racing!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
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

        // Submitting racers
        executor.submit(new Racer(barrier, "Car 1"));
        executor.submit(new Racer(barrier, "Car 2"));
        executor.submit(new Racer(barrier, "Car 3"));

        executor.shutdown(); // Shutdown the executor after tasks are completed
    }
}
