package Multithreading_Questions._8_Deadlock_Avoidance._1_Lock_Ordering;

import Multithreading_Questions._7_Deadlock_Demonstration.Resource;

public class DeadlockAvoidance {
    public static void main(String[] args) {
        Resource r1 = new Resource("Resource1");
        Resource r2 = new Resource("Resource2");

        Thread t1 = new Thread(new SafeThread(r1, r2), "ThreadA");
        Thread t2 = new Thread(new SafeThread(r2, r1), "ThreadB");

        t1.start();
        t2.start();
    }
}
