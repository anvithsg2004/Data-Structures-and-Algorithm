package DSA.Stack_and_Queue.Implementation;

import java.util.*;

public class _3_Stack_using_Queue {
    Queue<Integer> q = new LinkedList<>();

    // Push operation (O(n))
    public void push(int x) {
        q.add(x);
        int size = q.size();

        // Rotate elements to make the new element at front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
        System.out.println("Pushed: " + x);
    }

    // Pop operation (O(1))
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.poll();
    }

    // Peek (top element)
    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    // Check empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}
