package Java_Core.MultiThreading;

class MyThreadRunnable1 implements Runnable {

    public void run() {

        System.out.println("I am Thread 1");

    }

}

class MyThreadRunnable2 implements Runnable {

    public void run() {

        System.out.println("I am Thread 2");

    }

}

public class _5_Creating_a_Thread_Using_Runnable_Interface {
    public static void main(String[] args) {

        MyThreadRunnable1 bullet1 = new MyThreadRunnable1();
        Thread gun1 = new Thread(bullet1);

        gun1.start();


        MyThreadRunnable2 bullet2 = new MyThreadRunnable2();
        Thread gun2 = new Thread(bullet2);

        gun2.start();

    }
}
