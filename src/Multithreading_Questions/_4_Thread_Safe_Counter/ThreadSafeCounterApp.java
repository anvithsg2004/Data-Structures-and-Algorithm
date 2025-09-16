package Multithreading_Questions._4_Thread_Safe_Counter;

public class ThreadSafeCounterApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new CounterThread(counter, true), "IncrementThread1");
        Thread t2 = new Thread(new CounterThread(counter, true), "IncrementThread2");
        Thread t3 = new Thread(new CounterThread(counter, false), "DecrementThread1");
        Thread t4 = new Thread(new CounterThread(counter, false), "DecrementThread2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
