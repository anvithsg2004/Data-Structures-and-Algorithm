package Java_Core.MultiThreading;

class MyTask implements Runnable {

    public void run() {

        System.out.println("Running in thread: " + Thread.currentThread().getName());

    }

}

public class _6_Threads_Constructors_Types {
    public static void main(String[] args) {


        // 1. Using default constructor (Extending Thread)
        Thread bullet1 = new Thread() {
            @Override
            public void run() {

                System.out.println("Bullet 1 is running: " + Thread.currentThread().getName());

            }
        };
        bullet1.start();


        // 2. Using constructor with Runnable target
        //Runnable task = new MyTask();: Shows that task can be any Runnable object, not just MyTask. This is more flexible and promotes good design practices.
        //MyTask task = new MyTask();: Locks the reference to only MyTask objects, reducing flexibility.
        Runnable gun1 = new MyTask();
        Thread bullet2 = new Thread(gun1);
        bullet2.start();   // This will call the run() method of MyTask


        // 3. Using constructor with Runnable target and a name
        Thread bullet3 = new Thread(gun1, "Anvith Thread");
        bullet3.start();
        System.out.println("Started thread with name: " + bullet3.getName());


        // 4. Using ThreadGroup with Runnable and name
        ThreadGroup machineGun = new ThreadGroup("Machine Gun 1");
        Thread bullet4 = new Thread(machineGun, gun1, "Anvith's Group");
        bullet4.start();
        System.out.println("Started thread in group: " + bullet4.getName());


        // 5. Using ThreadGroup, Runnable, name, and custom stack size
        Thread bullet5 = new Thread(machineGun, gun1, "Stack Size Thread", 1024);
        bullet5.start();
        System.out.println("Started thread with custom stack size: " + bullet5.getName());


    }
}
