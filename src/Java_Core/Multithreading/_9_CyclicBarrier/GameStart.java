package Java_Core.Multithreading._9_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Player extends Thread {
    private CyclicBarrier barrier;
    private String name;

    public Player(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is ready...");
            barrier.await(); // Wait until all players arrive
            System.out.println(name + " starts playing!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class GameStart {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All players are ready! Game is starting...");
        });

        // Creating 3 players (threads)
        new Player(barrier, "Player 1").start();
        new Player(barrier, "Player 2").start();
        new Player(barrier, "Player 3").start();
    }
}
