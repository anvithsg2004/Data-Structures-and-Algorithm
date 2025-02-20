package Java_Core.Multithreading._2_Synchronization.Basics;

public class MyThread extends Thread {

    public Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
