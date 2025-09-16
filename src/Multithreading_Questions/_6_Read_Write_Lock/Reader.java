package Multithreading_Questions._6_Read_Write_Lock;

public class Reader implements Runnable {

    public SharedResource resource;
    public String name;

    public Reader(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            resource.read(name);
            try {
                Thread.sleep((int) (Math.random() * 1000)); // random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
