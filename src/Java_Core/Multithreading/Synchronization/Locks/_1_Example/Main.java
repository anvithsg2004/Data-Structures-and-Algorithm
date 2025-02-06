package Java_Core.Multithreading.Synchronization.Locks._1_Example;

public class Main {

    BankAccount account = new BankAccount(5000);
    Runnable task = new Runnable() {
        @Override
        public void run() {
            account.withdraw(800);
        }
    };

    Thread t1 = new Thread();

}
