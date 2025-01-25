package Java_Core.MultiThreading;

class MyThr1 extends Thread {

    public void run() {

        int i = 0;

        while (i < 10) {

            System.out.println("Thank You 1.");

            i++;
        }

    }

}

class MyThr2 extends Thread {

    public void run() {

        int i = 0;

        while (i < 10) {

            System.out.println("Thank You 2.");

            try {

                //Stops the thread process for a particular time mentioned in the "Thread.sleep(10000);"
                Thread.sleep(10000);

            } catch (Exception e) {
                e.printStackTrace();
            }

            i++;
        }

    }

}

public class _8_Methods {
    public static void main(String[] args) {

        MyThr1 t1 = new MyThr1();
        MyThr2 t2 = new MyThr2();

        t1.start();
        try {

            //After finishing the first thread, then only the next thread will starts.
            t1.join();

        } catch (Exception e) {
            System.out.println("Some Error");
        }
        t2.start();

    }
}
