package Multithreading_Questions._5_Producer_Consumer;

import java.util.*;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    // Producer adds item
    public synchronized void produce(int item, String producerName) {
        while (queue.size() == capacity) {
            try {
                System.out.println(producerName + " waiting, buffer full...");
                wait(); // Wait if buffer is full
            } catch (InterruptedException e) {
                System.out.println(producerName + " interrupted.");
            }
        }

        queue.add(item);
        System.out.println(producerName + " produced: " + item + " | Buffer size: " + queue.size());
        notifyAll(); // Notify consumers
    }

    // Consumer removes item
    public synchronized int consume(String consumerName) {
        while (queue.isEmpty()) {
            try {
                System.out.println(consumerName + " waiting, buffer empty...");
                wait(); // Wait if buffer is empty
            } catch (InterruptedException e) {
                System.out.println(consumerName + " interrupted.");
            }
        }

        int item = queue.poll();
        System.out.println(consumerName + " consumed: " + item + " | Buffer size: " + queue.size());
        notifyAll(); // Notify producers
        return item;
    }
}
