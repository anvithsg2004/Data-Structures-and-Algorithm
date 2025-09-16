package Multithreading_Questions._6_Read_Write_Lock;

public class Writer implements Runnable {
    public SharedResource resource;
    public String name;
    public int value;

    public Writer(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.write(i * 10, name);
            try {
                Thread.sleep((int) (Math.random() * 1500)); // random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
