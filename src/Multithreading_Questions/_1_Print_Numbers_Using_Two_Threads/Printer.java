package Multithreading_Questions._1_Print_Numbers_Using_Two_Threads;

public class Printer {

    public int count = 1;
    public int max;

    public Printer(int max) {
        this.max = max;
    }

    public synchronized void printOdd() throws InterruptedException {
        while (count <= max) {
            if (count % 2 == 0) {
                wait();
            } else {
                System.out.println("Odd Thread: " + count);
                count++;
                notify();
            }
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (count <= max) {
            if (count % 2 != 0) {
                wait();
            } else {
                System.out.println("Odd Thread: " + count);
                count++;
                notify();
            }
        }
    }

}
