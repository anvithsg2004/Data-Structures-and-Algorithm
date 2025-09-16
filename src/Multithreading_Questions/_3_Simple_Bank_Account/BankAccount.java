package Multithreading_Questions._3_Simple_Bank_Account;

public class BankAccount {

    public int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    // Withdraw money, wait if not enough balance
    public synchronized void withdraw(int amount, String user) {
        System.out.println(user + " is trying to withdraw: " + amount);

        while (balance < amount) {
            System.out.println(user + " waiting for sufficient balance...");
            try {
                wait(); // Wait until enough balance is deposited
            } catch (InterruptedException e) {
                System.out.println(user + " was interrupted while waiting.");
                return;
            }
        }

        // Proceed to withdraw
        balance -= amount;
        System.out.println(user + " withdrew " + amount + ". Current balance: " + balance);
    }

    public synchronized void deposit(int amount, String user) {
        System.out.println(user + " is depositing: " + amount);
        balance += amount;
        System.out.println(user + " deposited. Current balance: " + balance);
        notifyAll(); // Notify all waiting threads that funds are available
    }

}
