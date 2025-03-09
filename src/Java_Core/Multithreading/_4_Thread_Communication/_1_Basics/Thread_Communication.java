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
        System.out.println("Produce: " + value); // Log here
        notify();
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
        int value = data;
        hasData = false;
        System.out.println("Consume: " + value); // Log here
        notify();
        return value;
    }
}

class Producer implements Runnable {

    public sharedResource resource;

    public Producer(sharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // In Producer's run()
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
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
        // In Consumer's run()
        for (int i = 0; i < 10; i++) {
            int value = resource.consume();
        }
    }
}

public class Thread_Communication {
    public static void main(String[] args) {
        sharedResource resource = new sharedResource();

        //It uses wait() and notify() for synchronization
        //between two threads (Producer and Consumer) that share a common resource.
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
