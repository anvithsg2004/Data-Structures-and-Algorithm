package Java_Core.Multithreading._1_Thread._2_Implementing_Runnable_interface;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        t1.start();
    }

}
