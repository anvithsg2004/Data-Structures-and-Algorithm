package LeetCode_Contest_Questions;

import java.util.HashMap;
import java.util.Map;

public class _6_Maximum_Frequency_After_Subarray_Operation {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        //Initialize variables
        int minFreqNum = Integer.MAX_VALUE; // Number with minimum frequency
        int maxFreqNum = Integer.MIN_VALUE; // Number with maximum frequency
        int minFreq = Integer.MAX_VALUE;    // Minimum frequency value
        int maxFreq = Integer.MIN_VALUE;    // Maximum frequency value

        // Step 3: Find min and max frequency numbers
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            // Update min frequency number
            if (freq < minFreq || (freq == minFreq && num < minFreqNum)) {
                minFreq = freq;
                minFreqNum = num;
            }

            // Update max frequency number
            if (freq > maxFreq || (freq == maxFreq && num > maxFreqNum)) {
                maxFreq = freq;
                maxFreqNum = num;
            }
        }

        // Step 4: Handle case where all frequencies are the same
        if (minFreq == maxFreq) {
            // Find the highest and lowest numbers in the array
            int highestNum = Integer.MIN_VALUE;
            int lowestNum = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num > highestNum) highestNum = num;
                if (num < lowestNum) lowestNum = num;
            }
            minFreqNum = lowestNum;
            maxFreqNum = highestNum;
        }

        // Output results
        System.out.println("Number with minimum frequency: " + minFreqNum);
        System.out.println("Number with maximum frequency: " + maxFreqNum);
        System.out.println("Minimum frequency: " + minFreq);
        System.out.println("Maximum frequency: " + maxFreq);

        int difference = maxFreqNum - minFreqNum;
        int opposite = -difference;

        //If the "minFreq" and "maxFreq" as same.
        if (minFreq == maxFreq) {
            int first = 0;
            int second = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = difference + nums[i];
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == k) {
                    first++;
                }
            }

            for (int i = 0; i < n; i++) {
                nums[i] = opposite + nums[i];
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == k) {
                    second++;
                }
            }

            return Math.max(first, second);

        }

        return minFreq + maxFreq;
    }

    public int findFirst(int[] nums, int target) {

        int n = nums.length;

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        return index;
    }

    public int findLast(int[] nums, int target) {

        int n = nums.length;

        int index = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target) {
                index = i;
            }
        }

        return index;

    }
}
