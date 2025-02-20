package Java_Core.Multithreading._1_Thread._3_Methods;

//The isAlive() method checks whether a thread is still running.

class _6_isAlive extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread finished executing.");
    }

    public static void main(String[] args) {
        _6_isAlive t1 = new _6_isAlive();
        t1.start();

        System.out.println("Is thread alive? " + t1.isAlive());

        try {
            t1.join(); // Wait for t1 to finish
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Is thread alive? " + t1.isAlive());
    }
}
