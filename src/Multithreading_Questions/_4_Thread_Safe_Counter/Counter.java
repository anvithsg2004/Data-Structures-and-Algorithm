package Multithreading_Questions._4_Thread_Safe_Counter;

public class Counter {

    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " decremented: " + count);
    }

}
