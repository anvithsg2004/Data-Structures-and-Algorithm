package Java_Core.MultiThreading;

//Concurrency
//when two or more tasks are in progress at the same time, but not necessarily running at the exact same moment.

//Parallelism
//when two or more tasks are actually running at the same time, on different processors or cores.


class MyThread1 extends Thread {

    @Override
    public void run() {

        while (true) {

            System.out.println("My thread 1 is running ");

        }

    }

}

class MyThread2 extends Thread {

    @Override
    public void run() {

        while (true) {

            System.out.println("My thread 2 is running ");

        }

    }

}


public class _1_Creating_a_Thread_by_Extending_Thread_class {
    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.start();
        t2.start();

    }
}
