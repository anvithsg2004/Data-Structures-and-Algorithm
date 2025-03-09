package Java_Core.Multithreading._2_Synchronization._3_Synchronized_Block.Types.Class_Level;

class Logger {
    //Put the "synchronized" for the "static".
    public static synchronized void logMessage(String message) {  // Lock on Logger.class
        System.out.println(Thread.currentThread().getName() + " - Logging: " + message);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}

public class ClassLevelSyncExample1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> Logger.logMessage("System started"), "Thread-1");
        Thread t2 = new Thread(() -> Logger.logMessage("User logged in"), "Thread-2");

        t1.start();
        t2.start();  // Ensures only one thread can execute logMessage() at a time
    }
}
