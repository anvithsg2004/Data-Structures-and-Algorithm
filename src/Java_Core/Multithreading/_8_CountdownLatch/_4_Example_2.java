package Java_Core.Multithreading._8_CountdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ResourceLoader2 implements Runnable {
    private CountDownLatch latch;
    private String resourceName;

    public ResourceLoader2(CountDownLatch latch, String resourceName) {
        this.latch = latch;
        this.resourceName = resourceName;
    }

    @Override
    public void run() {
        try {
            System.out.println(resourceName + " loading...");
            Thread.sleep((long) (Math.random() * 3000)); // Simulate loading time
            System.out.println(resourceName + " loaded!");
            latch.countDown(); // Decrement the latch count
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class _4_Example_2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 3 resources to load

        // Use ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks
        executor.submit(new ResourceLoader(latch, "Textures"));
        executor.submit(new ResourceLoader(latch, "Sounds"));
        executor.submit(new ResourceLoader(latch, "Assets"));

        System.out.println("Waiting for resources to load...");
        latch.await(); // Wait until all resources are loaded

        System.out.println("All resources loaded! Game is starting...");

        // Shutdown executor
        executor.shutdown();
    }
}
