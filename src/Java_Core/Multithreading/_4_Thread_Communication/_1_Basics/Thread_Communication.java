package Java_Core.Multithreading._4_Thread_Communication._1_Basics;

class sharedResource {
    public int data;

    public boolean hasData;

    // Producer method
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        hasData = true;
        notify();  // Wake up Consumer
    }

    // Consumer method
    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasData = false;
        notify();  // Wake up Producer
        return data;
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
        sharedResource resource = new sharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
