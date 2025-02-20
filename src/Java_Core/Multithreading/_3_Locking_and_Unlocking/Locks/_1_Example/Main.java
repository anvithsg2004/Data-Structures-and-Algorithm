package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._1_Example;

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
