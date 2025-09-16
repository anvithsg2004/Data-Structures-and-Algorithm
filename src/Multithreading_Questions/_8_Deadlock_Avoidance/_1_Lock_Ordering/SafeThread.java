package Multithreading_Questions._8_Deadlock_Avoidance._1_Lock_Ordering;

import Multithreading_Questions._7_Deadlock_Demonstration.Resource;

public class SafeThread implements Runnable {
    private Resource r1;
    private Resource r2;

    public SafeThread(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        Resource first = r1.getName().compareTo(r2.getName()) < 0 ? r1 : r2;
        Resource second = r1.getName().compareTo(r2.getName()) < 0 ? r2 : r1;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " locked " + first.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
            }
        }
    }
}
