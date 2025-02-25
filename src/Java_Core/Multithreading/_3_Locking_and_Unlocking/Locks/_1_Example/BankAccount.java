package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._1_Example;

public class BankAccount {

    public int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    //This is what lock is.
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + " proceeding to withdrawal");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " Completed withdrawal");
            System.out.println(Thread.currentThread().getName() + " remaining balance " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " No sufficient balance.");
        }
    }
}
