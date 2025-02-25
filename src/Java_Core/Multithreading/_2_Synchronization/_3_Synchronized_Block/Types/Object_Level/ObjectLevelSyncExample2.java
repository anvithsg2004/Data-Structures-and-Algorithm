package Java_Core.Multithreading._2_Synchronization._3_Synchronized_Block.Types.Object_Level;

class Printer {
    synchronized void printDocuments(int pages) {  // Lock on instance
        for (int i = 1; i <= pages; i++) {
            System.out.println(Thread.currentThread().getName() + " - Printing page " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

public class ObjectLevelSyncExample2 {
    public static void main(String[] args) {
        Printer printer = new Printer();  // One shared object

        Thread t1 = new Thread(() -> printer.printDocuments(5), "Thread-1");
        Thread t2 = new Thread(() -> printer.printDocuments(5), "Thread-2");

        t1.start();
        t2.start();  // Ensures only one thread prints at a time for this printer instance
    }
}
