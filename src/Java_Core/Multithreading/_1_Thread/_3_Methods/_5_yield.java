package Java_Core.Multithreading._1_Thread._3_Methods;

//This method pauses the current thread and allows other threads of the same priority to execute.

class _5_yield extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield(); // Hints that other threads should run
        }
    }

    public static void main(String[] args) {
        _5_yield t1 = new _5_yield();
        _5_yield t2 = new _5_yield();

        t1.start();
        t2.start();
    }
}
