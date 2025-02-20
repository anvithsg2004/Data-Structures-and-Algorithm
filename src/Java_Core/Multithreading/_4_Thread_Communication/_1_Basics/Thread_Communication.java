package Java_Core.Multithreading._4_Thread_Communication._1_Basics;

class sharedResource {
    public int data;

    public boolean hasData;

    public void produce(int value) {

    }

    public int consume() {

    }
}

class Producer implements Runnable {

    public sharedResource resource;

    public Producer(sharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
            System.out.println("Produce: " + i);
        }
    }
}

class Consumer implements Runnable {

    public sharedResource resource;

    public Consumer(sharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resource.consume();
            System.out.println("Consume: " + value);
        }
    }
}

public class Thread_Communication {
    public static void main(String[] args) {

    }
}
