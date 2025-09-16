package Multithreading_Questions._8_Deadlock_Avoidance._2_tryLockwithTimeout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class SafeLockThread implements Runnable {
    private Lock lock1;
    private Lock lock2;

    public SafeLockThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                Thread.sleep(100);

                if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    lock2.unlock();
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire lock2, releasing lock1");
                }
                lock1.unlock();
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
