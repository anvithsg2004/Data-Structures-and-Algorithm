package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks._2_Lock_Example;

public class Main {

    public static void main(String[] args) {
        BankAccount sbi = new BankAccount(5000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(800);
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
