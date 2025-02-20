package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._2_Lock_Example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    public int balance;

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

        }
    }
}
