package Java_Core.Multithreading.Synchronization.Basics;

public class Test {

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            //waits until the thread finishes execution before allowing the next line of code to run.
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Exception is there.");
        }

        System.out.println(counter.getId());
    }
}
