package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._5_Read_And_Write_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteExample {

    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = new ReentrantLock();

    private final Lock writeLock = new ReentrantLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        writeLock.lock();
        try {
            return count;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadAndWriteExample counter = new ReadAndWriteExample();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read : " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
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
        } catch (Exception e) {
            System.out.println("Some Error...");
        }

        System.out.println("Final Count : " + counter.getCount());

    }

}
