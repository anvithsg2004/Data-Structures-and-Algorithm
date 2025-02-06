package Java_Core.Multithreading.Synchronization.Locks._2_Lock_Example;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                account.withdraw(800);
            }
        };

        Thread t1 = new Thread(task, "T1 ");
        Thread t2 = new Thread(task, "T2 ");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Not Possible !!!");
        }
    }

}
