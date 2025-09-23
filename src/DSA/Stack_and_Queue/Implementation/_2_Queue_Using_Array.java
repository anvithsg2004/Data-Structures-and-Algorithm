package DSA.Stack_and_Queue.Implementation;

public class _2_Queue_Using_Array {
    private int[] arr;   // array to store queue elements
    private int front;   // front points to the first element
    private int rear;    // rear points to the last element
    private int capacity; // maximum capacity of the queue
    private int count;   // current size of the queue

    // Constructor
    public _2_Queue_Using_Array(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Utility function to dequeue the front element
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Removing " + arr[front]);

        front = (front + 1) % capacity;
        count--;
    }

    // Utility function to add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;

        System.out.println("Inserting " + item);
    }

    // Utility function to return front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }

    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return (count == 0);
    }

    // Utility function to check if the queue is full or not
    public boolean isFull() {
        return (count == capacity);
    }
}
