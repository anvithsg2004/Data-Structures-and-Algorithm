package DSA.Stack_and_Queue.Implementation;

public class _6_queue_using_LinkedList {
    private Node front, rear; // front = first element, rear = last element

    // Constructor
    public _6_queue_using_LinkedList() {
        this.front = this.rear = null;
    }

    // Enqueue operation
    public void enqueue(int x) {
        Node newNode = new Node(x);

        // If queue is empty, both front and rear are the new node
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Enqueued: " + x);
            return;
        }

        // Add new node at the end and update rear
        rear.next = newNode;
        rear = newNode;
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int val = front.data;
        front = front.next;

        // If queue becomes empty, update rear also to null
        if (front == null) {
            rear = null;
        }
        return val;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}
