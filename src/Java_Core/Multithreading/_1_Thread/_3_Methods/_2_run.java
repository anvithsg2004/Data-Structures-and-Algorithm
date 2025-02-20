package Java_Core.Multithreading._1_Thread._3_Methods;

//Runs like a normal method call in the main thread

public class _2_run extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        _2_run t1 = new _2_run();
        t1.run(); // This will not create a new thread, it runs in the main thread
    }
}
