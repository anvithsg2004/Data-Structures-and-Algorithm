package Java_Core.Multithreading._1_Thread._3_Methods;

//Strong Concept
//The reason Thread 3 ran first, even though t1.start() was called before t2.start() and t3.start()
//is because thread execution order is not determined by the order of start() calls.

//When you call:
//t1.start();
//t2.start();
//t3.start();
//This requests the JVM to create and start three separate threads.
//However, the JVM and the Operating System (OS) control thread scheduling, not your program.
//The actual execution order depends on the CPU scheduler, which decides which thread gets CPU time first.

//Key Factors Affecting Thread Execution Order
//1) Thread Scheduling in Java
//2) Thread Priorities
//   Each thread has a priority (default: Thread.NORM_PRIORITY).
//   Higher-priority threads may run first, but it’s not guaranteed.
//3) Race Conditions in Scheduling
//   Multiple threads are started almost simultaneously, and the OS decides which one gets CPU time first.
//   Even if t1.start() is called first, it might be paused while t2 or t3 gets CPU time.

//This method makes the main thread wait until the specified thread finishes execution.

class _4_join extends Thread {
    private String threadName;

    public _4_join(String name) {
        this.threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " running: " + i);
            try {
                Thread.sleep(1000); // Each thread sleeps for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        _4_join t1 = new _4_join("Thread 1");
        _4_join t2 = new _4_join("Thread 2");
        _4_join t3 = new _4_join("Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join(); // Main thread waits for t1 to finish
            t2.join(); // Main thread waits for t2 to finish
            t3.join(); // Main thread waits for t3 to finish
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread resumes after t1, t2, and t3 complete.");
    }
}
