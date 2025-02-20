package Java_Core.Multithreading._1_Thread._3_Methods;

//The start() method creates a new thread and calls the run() method asynchronously.

//Even though your MyThread class extends Thread, a new thread is not created automatically.
//A thread is created only when you instantiate an object of MyThread and call the .start() method.

//java.lang.Object
//   └── java.lang.Thread (Has start(), run(), sleep(), join(), yield(), etc.)
//          └── MyThread (Inherits these methods but overrides run())

public class _1_start extends Thread {

    public void run() {
        System.out.println("Hi Anvith, you are running.");
    }

    public static void main(String[] args) {
        _1_start t1 = new _1_start();
        t1.start();
    }

}
