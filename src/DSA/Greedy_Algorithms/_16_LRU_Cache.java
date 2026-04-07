package DSA.Greedy_Algorithms;

import java.util.*;

public class _16_LRU_Cache {
    public int lruPageFaults(int[] pages, int capacity) {

        int n = pages.length;

        Set<Integer> lru = new LinkedHashSet<>();

        int faults = 0;

        for (int i = 0; i < n; i++) {

            int number = pages[i];

            // Hit
            if (lru.contains(number)) {
                lru.remove(number);
                lru.add(number);
            }
            // Miss
            else {
                faults++;

                if (lru.size() == capacity) {
                    int leftestNumber = lru.iterator().next();
                    lru.remove(leftestNumber);
                }

                lru.add(number);

            }

        }

        return faults;

    }
}
