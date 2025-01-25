package Java_Core.Java.Old.Threads;

class MyThread extends Thread {
    public MyThread(String name){
        super(name);
    }
    public void run(){
        int i = 15;
        System.out.println("My name is Anvith.");
    }
}

public class _4_Thread_constructors {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Anvith");
        t1.start();
        System.out.println("My ID is " + t1.getId());
        System.out.println("My name is " + t1.getName());
    }
}
