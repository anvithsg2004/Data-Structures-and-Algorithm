package Multithreading_Questions._4_Thread_Safe_Counter;

public class CounterThread implements Runnable {

    private Counter counter;
    private boolean increment;

    public CounterThread(Counter counter, boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            if (increment) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }

    }
}
