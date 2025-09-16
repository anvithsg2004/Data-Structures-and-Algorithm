package Multithreading_Questions._7_Deadlock_Demonstration;

public class DeadlockThread implements Runnable {

    public Resource first;
    public Resource second;

    public DeadlockThread(Resource first, Resource second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " locked " + first.getName());
            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
            }
        }

    }
}
