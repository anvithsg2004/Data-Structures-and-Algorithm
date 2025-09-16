package Multithreading_Questions._1_Print_Numbers_Using_Two_Threads;

public class EvenThread implements Runnable {
    public Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        try {
            printer.printEven();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
