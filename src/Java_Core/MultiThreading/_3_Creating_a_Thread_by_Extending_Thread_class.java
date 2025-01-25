package Java_Core.MultiThreading;


//The output can vary.
///The problems that result from this are called concurrency problems.

public class _3_Creating_a_Thread_by_Extending_Thread_class extends Thread {

    public static int amount = 0;

    public static void main(String[] args) {

        _3_Creating_a_Thread_by_Extending_Thread_class t1 = new _3_Creating_a_Thread_by_Extending_Thread_class();
        t1.start();
        System.out.println(amount);
        amount++;
        System.out.println(amount);

    }

    @Override
    public void run() {

        amount++;

    }
}
