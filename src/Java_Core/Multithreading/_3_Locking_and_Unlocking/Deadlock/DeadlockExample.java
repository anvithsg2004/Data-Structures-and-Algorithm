package Java_Core.Multithreading._3_Locking_and_Unlocking.Deadlock;

class Resource {
    static final Object PEN = new Object();
    static final Object PAPER = new Object();
}

class Task1 extends Thread {
    public void run() {
        synchronized (Resource.PEN) {
            System.out.println("Thread-1: Holding PEN...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            System.out.println("Thread-1: Waiting for PAPER...");
            synchronized (Resource.PAPER) {
                System.out.println("Thread-1: Got PAPER and PEN!");
            }
        }
    }
}

class Task2 extends Thread {
    public void run() {
        synchronized (Resource.PAPER) {
            System.out.println("Thread-2: Holding PAPER...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            System.out.println("Thread-2: Waiting for PEN...");
            synchronized (Resource.PEN) {
                System.out.println("Thread-2: Got PEN and PAPER!");
            }
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();

        t1.start();
        t2.start();
    }
}
