package Java_Core.MultiThreading;

class MyThr extends Thread {

    public MyThr(String name) {

        super(name);

    }

    public void run() {

        int i = 34;

        System.out.println("Thank You" + this.getName());

    }

}

public class _7_Priorities {
    public static void main(String[] args) {

        MyThr t1 = new MyThr("Anvith.");
        MyThr t2 = new MyThr("The Best.");
        MyThr t3 = new MyThr("I'm not the worst.");
        MyThr t4 = new MyThr("The Best in the world.");
        MyThr t5 = new MyThr("The Best in the class. (Important for me.)");
        MyThr t6 = new MyThr("The Best in Mandya.");
        MyThr t7 = new MyThr("The Best in bengaluru.");
        MyThr t8 = new MyThr("The Best in India.");

        //Setting Priority
        t5.setPriority(Thread.MAX_PRIORITY);

        //In Java_Core.Java, thread priorities don't guarantee the order in which threads will execute.
        //The priority hints to the JVM scheduler which thread is more important, but it doesn't enforce that higher-priority threads will always run before lower-priority threads.
        //Thread scheduling is platform-dependent and might not strictly follow priorities.
        //This is also dependent on the OS also.
        //We can not believe this.

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        //Before setting the priority, it will run in its own order.

    }
}
