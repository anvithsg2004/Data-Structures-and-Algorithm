package Java_Core.Multithreading._10_CompletableFuture.All_Three;

import java.util.concurrent.*;

//2️⃣ CyclicBarrier Example → "Let's all meet here before starting." 🚦
//Threads must wait at a barrier until all arrive
//Can be used multiple times
//Scenario:
//3 players must be ready before a multiplayer game starts.

class Player implements Runnable {
    private CyclicBarrier barrier;
    private String name;

    public Player(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is getting ready...");
            Thread.sleep((long) (Math.random() * 3000)); // Simulate delay
            System.out.println(name + " is ready!");

            barrier.await(); // Wait for all players

            System.out.println(name + " starts playing!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Barrier for 3 players
        //This creates a CyclicBarrier that waits for 3 threads (Player 1, Player 2, Player 3)
        //to call await().
        //The second argument (() -> System.out.println(...)) is a Runnable task that will
        //execute only when all 3 threads reach the barrier.
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All players are ready! Game starts now!");
        });

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Player(barrier, "Player 1"));
        executor.submit(new Player(barrier, "Player 2"));
        executor.submit(new Player(barrier, "Player 3"));

        executor.shutdown();
    }
}
