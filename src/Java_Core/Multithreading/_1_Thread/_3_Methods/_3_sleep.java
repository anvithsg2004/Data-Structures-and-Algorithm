package Java_Core.Multithreading._1_Thread._3_Methods;

class _3_sleep extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
            try {
                System.out.println("Going to sleep");
                Thread.sleep(5000);
                // Pauses the thread for 1 second
                //It only pauses the current thread, other threads keep running.
                System.out.println("Woke up");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        _3_sleep t1 = new _3_sleep();
        t1.start();
    }
}
