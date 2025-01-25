package Java_Core.MultiThreading;

//The output can vary in order.

public class _2_Creating_a_Thread_by_Extending_Thread_class extends Thread {
    public static void main(String[] args) {


        _2_Creating_a_Thread_by_Extending_Thread_class t1 = new _2_Creating_a_Thread_by_Extending_Thread_class();
        t1.start();
        System.out.println("This code is outside of the thread");


    }

    public void run() {

        System.out.println("This code is running in a thread");

    }
}
