package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._3_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

//This program demonstrates ReentrantLock, which allows a thread to acquire the same
//lock multiple times without getting stuck. This is why it's called "reentrant".
//Because the same thread holds it.

//A normal (non-reentrant) lock would block when trying to lock again in innerLock(),
//because the thread already holds the lock.
//But ReentrantLock allows the same thread to lock again without waiting.

public class ReentrantLockExample {

    public final ReentrantLock lock = new ReentrantLock();

    public void outerLock() {
        lock.lock();

        try {
            System.out.println("Outer Method Inside");
            innerLock();
            System.out.println("Outer Method Outside");
        } finally {
            lock.unlock();
        }

    }

    public void innerLock() {
        lock.lock();

        try {
            System.out.println("Inner Method Inside");
            System.out.println("Inner Method Outside");
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.outerLock();
    }

}
