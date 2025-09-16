package Multithreading_Questions._3_Simple_Bank_Account;

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); // Initial balance is 100

        // Create multiple threads simulating deposits and withdrawals
        Thread t1 = new Thread(new TransactionThread(account, "Alice", false, 150)); // withdraw
        Thread t2 = new Thread(new TransactionThread(account, "Bob", true, 100));    // deposit
        Thread t3 = new Thread(new TransactionThread(account, "Charlie", false, 50)); // withdraw
        Thread t4 = new Thread(new TransactionThread(account, "Diana", true, 200));  // deposit

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Optional: wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
