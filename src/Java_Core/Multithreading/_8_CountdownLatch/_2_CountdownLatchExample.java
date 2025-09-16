package Java_Core.Multithreading._8_CountdownLatch;

//It has a count that starts from a given number.
//Threads can wait until the count reaches zero.
//Other threads decrement the count when they finish their task.
//Once the count reaches zero, waiting threads continue execution.

import java.util.concurrent.CountDownLatch;

public class _2_CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // Countdown starts from 3

        Thread runner = new Thread(() -> {
            try {
                latch.await(); // Wait for the countdown to finish
                System.out.println("Runner starts running!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        runner.start();

        Thread.sleep(1000);
        System.out.println("3");
        latch.countDown(); // Decrease count

        Thread.sleep(1000);
        System.out.println("2");
        latch.countDown();

        Thread.sleep(1000);
        System.out.println("1");
        latch.countDown(); // Now count reaches 0, runner starts

        runner.join();
    }
}
