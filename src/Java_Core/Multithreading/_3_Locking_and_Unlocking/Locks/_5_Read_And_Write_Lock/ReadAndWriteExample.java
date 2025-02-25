package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._5_Read_And_Write_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteExample {

    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock(); // Correct lock
    private final Lock readLock = lock.readLock(); // Get read lock from ReadWriteLock
    private final Lock writeLock = lock.writeLock(); // Get write lock from ReadWriteLock

    public void increment() {
        writeLock.lock(); // Correctly uses write lock for modification
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock(); // Correctly uses read lock for reading
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadAndWriteExample counter = new ReadAndWriteExample();

        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
            }
        };

        Runnable writeTask = () -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " incremented");
            }
        };

        Thread writerThread = new Thread(writeTask, "Write Thread");
        Thread readerThread1 = new Thread(readTask, "Read Thread 1");
        Thread readerThread2 = new Thread(readTask, "Read Thread 2");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        try {
            writerThread.join();
            readerThread1.join();
            readerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted...");
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}
