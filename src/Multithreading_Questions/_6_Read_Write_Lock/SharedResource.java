package Multithreading_Questions._6_Read_Write_Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    public int data = 0;
    public ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(String readerName) {
        lock.readLock().lock();
        try {
            System.out.println(readerName + " is reading data: " + data);
            Thread.sleep(500); // simulate reading time
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int value, String writerName) {

        lock.writeLock().lock();
        try {
            data = value;
            System.out.println(writerName + " is writing data: " + data);
            Thread.sleep(500); // simulate reading time
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

}
