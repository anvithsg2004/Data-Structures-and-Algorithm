package DSA.Stack_and_Queue.Implementation;

import java.util.*;

public class _4_Queue_using_Stack {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        inStack.push(x);
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // Check empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
