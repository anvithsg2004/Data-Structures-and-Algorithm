package Java_Core.Multithreading._2_Synchronization._2_Synchronized_Method;

public class BankAccount {

    private int balance = 1000;

    // Synchronized method (only one thread can execute it at a time)
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw. Insufficient balance.");
        }
    }

}
