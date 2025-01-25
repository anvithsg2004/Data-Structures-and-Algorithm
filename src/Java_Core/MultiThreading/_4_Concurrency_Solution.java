package Java_Core.MultiThreading;

public class _4_Concurrency_Solution extends Thread {

    public static int amount = 0;

    public static void main(String[] args) {

        _4_Concurrency_Solution t1 = new _4_Concurrency_Solution();
        t1.start();

        while (t1.isAlive()) {

            System.out.println("Waiting...");

        }

        System.out.println("Main: " + amount);

        amount++;

        System.out.println("Main: " + amount);

    }

    public void run() {

        amount++;

    }
}
