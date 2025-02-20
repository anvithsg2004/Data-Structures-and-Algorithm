package Java_Core.Multithreading._2_Synchronization._4_Static_Synchronization;

public class User extends Thread {
    public void run() {
        Printer.printDocuments(Thread.currentThread().getName());
    }
}
