package Multithreading_Questions._1_Print_Numbers_Using_Two_Threads;

public class OddThread implements Runnable {
    public Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        try {
            printer.printOdd();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
