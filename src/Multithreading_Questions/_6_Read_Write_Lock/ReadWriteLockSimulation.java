package Multithreading_Questions._6_Read_Write_Lock;

public class ReadWriteLockSimulation {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread r1 = new Thread(new Reader(resource, "Reader1"));
        Thread r2 = new Thread(new Reader(resource, "Reader2"));
        Thread r3 = new Thread(new Reader(resource, "Reader3"));

        Thread w1 = new Thread(new Writer(resource, "Writer1"));
        Thread w2 = new Thread(new Writer(resource, "Writer2"));

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();
    }
}
