package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._6_Producer_Consumer_Problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExample {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    //🔹 What is a Condition Variable?
    //A Condition in Java is used with a ReentrantLock to allow threads to wait
    //and be notified when a certain condition is met.
    //Similar to wait() and notify() in synchronized, but more powerful and flexible.
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public ProducerConsumerExample(int capacity) {
        this.capacity = capacity;
    }

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                notFull.await(); // Wait if buffer is full
            }
            buffer.add(value);
            System.out.println("Produced: " + value);
            notEmpty.signal(); // Notify consumer
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                notEmpty.await(); // Wait if buffer is empty
            }
            int value = buffer.poll();
            System.out.println("Consumed: " + value);
            notFull.signal(); // Notify producer
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample(5);

        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    example.produce(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Producer interrupted");
                }
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    example.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Consumer interrupted");
                }
            }
        };

        Thread producerThread = new Thread(producerTask, "Producer Thread");
        Thread consumerThread = new Thread(consumerTask, "Consumer Thread");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }
    }
}
