package Java_Core.Multithreading._2_Synchronization._3_Synchronized_Block;

public class BankAccount {

    private int balance = 10000;

    // Synchronized method (only one thread can execute it at a time)
    public void withdraw(String name, int amount) {

        synchronized (this) {
            if (balance >= amount) {
                System.out.println(name + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("Remaining Balance: " + balance);
            } else {
                System.out.println(name + " cannot withdraw. Insufficient balance.");
            }
        }
    }

}
