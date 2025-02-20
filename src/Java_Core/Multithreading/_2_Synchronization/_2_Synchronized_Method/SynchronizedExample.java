package Java_Core.Multithreading._2_Synchronization._2_Synchronized_Method;

public class SynchronizedExample {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        User user1 = new User(account, "Alice", 700);
        User user2 = new User(account, "Bob", 700);

        user1.start();
        user2.start();
    }

}
