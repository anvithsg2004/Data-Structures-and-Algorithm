package Multithreading_Questions._1_Print_Numbers_Using_Two_Threads;

public class EvenOddThreads {
    public static void main(String[] args) {
        Printer printer = new Printer(10);

        Thread oddThread = new Thread(new OddThread(printer));
        Thread evenThread = new Thread(new EvenThread(printer));

        oddThread.start();
        evenThread.start();
    }
}
