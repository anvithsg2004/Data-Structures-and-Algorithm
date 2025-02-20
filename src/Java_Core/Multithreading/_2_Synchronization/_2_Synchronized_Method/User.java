package Java_Core.Multithreading._2_Synchronization._2_Synchronized_Method;

public class User extends Thread {

    BankAccount account;
    String name;
    int amount;

    public User(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(name, amount);
    }

}
