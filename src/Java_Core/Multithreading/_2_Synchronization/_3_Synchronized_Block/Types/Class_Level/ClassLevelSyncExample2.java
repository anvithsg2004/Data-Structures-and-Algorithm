package Java_Core.Multithreading._2_Synchronization._3_Synchronized_Block.Types.Class_Level;

class Database {
    public void connect() {
        synchronized (Database.class) {  // Lock on Database.class
            System.out.println(Thread.currentThread().getName() + " - Connecting to Database...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName() + " - Connection established.");
        }
    }
}

public class ClassLevelSyncExample2 {
    public static void main(String[] args) {
        Database db1 = new Database();
        Database db2 = new Database();

        Thread t1 = new Thread(() -> db1.connect(), "Thread-1");
        Thread t2 = new Thread(() -> db2.connect(), "Thread-2");

        t1.start();
        t2.start();  // Ensures only one thread can execute connect() across all Database instances
    }
}
