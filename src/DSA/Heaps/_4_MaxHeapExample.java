package DSA.Heaps;

import java.util.PriorityQueue;
import java.util.Collections;

public class _4_MaxHeapExample {
    public static void main(String[] args) {
        // Create a Max-Heap (Max-Priority Queue) using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements into the Max-Heap
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(15);
        maxHeap.add(2);

        System.out.println("Max-Heap (Max-Priority Queue):");

        // Peek at the largest element (without removing it)
        System.out.println("Peek: " + maxHeap.peek()); // Output: 15

        // Remove and print elements in descending order
        while (!maxHeap.isEmpty()) {
            System.out.println("Removed: " + maxHeap.remove());
        }

        // Output:
        // Removed: 15
        // Removed: 10
        // Removed: 5
        // Removed: 2
    }
}
