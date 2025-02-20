package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._2_Lock_Example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    public int balance;

    //This is like user created a personal lock instead of using synchronised.
    public Lock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    //This is what lock is.
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw" + amount);

        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + "proceeding to withdrawal");
                    try {
                        Thread.sleep(10000);
                        balance = balance - amount;
                        System.out.println(Thread.currentThread().getName() + "Completed withdrawal");
                        System.out.println(Thread.currentThread().getName() + "remaining balance " + balance);
                    } catch (Exception e) {
                        //If a thread remembers it was interrupted, it can stop safely, exit loops, or clean up resources.
                        //If a thread forgets it was interrupted, it might continue running even when it should stop.
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "No sufficient balance.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock, will try later");
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        //Here is the use of remembering the status.
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Get Out!!!");
        }
    }
}
