package DSA.Stack_and_Queue.Implementation;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class _5_stack_using_LinkedList {
    private Node top;  // top of the stack

    // Constructor
    public _5_stack_using_LinkedList() {
        this.top = null;
    }

    // Push operation
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;  // new node points to old top
        top = newNode;       // update top
        System.out.println("Pushed: " + x);
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;  // move top pointer down
        return popped;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
