package Java_Core.Multithreading._2_Synchronization._3_Synchronized_Block.Types.Object_Level;

class SharedResource {
    void printMessage() {
        synchronized (this) {  // Lock on current object instance
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}

public class ObjectLevelSyncExample1 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();  // One shared object

        Thread t1 = new Thread(resource::printMessage, "Thread-1");
        Thread t2 = new Thread(() -> resource.printMessage(), "Thread-2");

        t1.start();
        t2.start();  // Both threads use the same object, ensuring synchronization
    }
}
