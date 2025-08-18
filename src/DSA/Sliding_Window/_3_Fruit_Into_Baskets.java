package DSA.Sliding_Window;

//Problem Statement
//You are given an array arr[], where each element represents a type of fruit.
//Your goal is to determine the maximum number of fruits you can collect in a single pass,
//if you can carry at most two different types of fruits at a time.

//Same as the question "Find length of the longest subarray containing atmost two distinct integers".

//We can say this question as = Max Length Sub Array with atmost 2 types of number.

import java.util.*;

public class _3_Fruit_Into_Baskets {

    //Optimised Solution
    public static int totalElements2(Integer[] arr) {

        int maxLen = 0;
        int n = arr.length;
        int left = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            // Add the current element to the frequency map
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            // Shrink the window until there are at most 2 unique elements
            while (freqMap.size() > 2) {
                // Remove the element at the left pointer
                int leftElement = arr[left];
                freqMap.put(leftElement, freqMap.get(leftElement) - 1);
                if (freqMap.get(leftElement) == 0) {
                    freqMap.remove(leftElement);
                }
                left++;
            }

            // Update the maximum window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}
