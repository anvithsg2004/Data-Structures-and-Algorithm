package Java_Core.Multithreading._11_volatile;

class SharedResource {
    volatile boolean running = true; // Now it's volatile!

    void stop() {
        running = false; // Change is now visible to all threads
    }
}

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedResource obj = new SharedResource();

        Thread thread = new Thread(() -> {
            while (obj.running) {
                // Now 'running' is always read from main memory
            }
            System.out.println("Stopped!");
        });

        thread.start();
        Thread.sleep(1000);
        obj.stop(); // Thread will now see this change!
    }
}
