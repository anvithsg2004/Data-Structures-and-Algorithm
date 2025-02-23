package Java_Core.Multithreading._10_CompletableFuture.All_Three;

import java.util.concurrent.*;

//3️⃣ CountDownLatch Example → "Wait until 3...2...1... GO!" ⏳
//A thread waits until a count reaches zero
//One-time use only
//Scenario:
//A car race only starts when all 3 lights turn green (countdown reaches 0).

class TrafficLight implements Runnable {
    private CountDownLatch latch;
    private String light;

    public TrafficLight(CountDownLatch latch, String light) {
        this.latch = latch;
        this.light = light;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 2000)); // Simulate delay
            System.out.println(light + " light is ON!");
            latch.countDown(); // Decrease count
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // Countdown from 3

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new TrafficLight(latch, "Red"));
        executor.submit(new TrafficLight(latch, "Yellow"));
        executor.submit(new TrafficLight(latch, "Green"));

        latch.await(); // Wait until countdown reaches 0

        System.out.println("All lights are ON! Race starts!");
        executor.shutdown();
    }
}
