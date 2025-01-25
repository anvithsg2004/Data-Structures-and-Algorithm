package DSA.Heaps;

import java.util.PriorityQueue;

public class _3_MinHeapExample {
    public static void main(String[] args) {
        // Create a Min-Heap (Min-Priority Queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements into the Min-Heap
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(15);
        minHeap.add(2);

        System.out.println("Min-Heap (Min-Priority Queue):");

        // Peek at the smallest element (without removing it)
        System.out.println("Peek: " + minHeap.peek()); // Output: 2

        // Remove and print elements in ascending order
        while (!minHeap.isEmpty()) {
            System.out.println("Removed: " + minHeap.remove());
        }

        // Output:
        // Removed: 2
        // Removed: 5
        // Removed: 10
        // Removed: 15
    }
}
