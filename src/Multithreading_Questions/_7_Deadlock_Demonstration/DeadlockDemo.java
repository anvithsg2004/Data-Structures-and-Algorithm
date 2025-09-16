package Multithreading_Questions._7_Deadlock_Demonstration;

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource r1 = new Resource("Resource1");
        Resource r2 = new Resource("Resource2");

        Thread t1 = new Thread(new DeadlockThread(r1, r2), "ThreadA");
        Thread t2 = new Thread(new DeadlockThread(r2, r1), "ThreadB");

        t1.start();
        t2.start();
    }
}
