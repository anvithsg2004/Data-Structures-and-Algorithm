package Java_Core.Multithreading._8_CountdownLatch;


import java.util.concurrent.CountDownLatch;

//A gaming application needs to load three resources
//(textures, sounds, and assets) before the game starts.

class ResourceLoader extends Thread {
    private CountDownLatch latch;
    private String resourceName;

    public ResourceLoader(CountDownLatch latch, String resourceName) {
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

public class _3_Example {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 3 resources to load

        // Start loading resources
        new ResourceLoader(latch, "Textures").start();
        new ResourceLoader(latch, "Sounds").start();
        new ResourceLoader(latch, "Assets").start();

        System.out.println("Waiting for resources to load...");
        latch.await(); // Wait until all resources are loaded

        System.out.println("All resources loaded! Game is starting...");
    }
}
