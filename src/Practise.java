import java.util.HashMap;
import java.util.Map;

public class Practise {

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

        if (minFreq == maxFreq) {
            // Calculate potential x values based on highest and lowest numbers
            int difference = maxFreqNum - minFreqNum;
            int opposite = -difference;

            // Compute maximum gains for both x values
            int gainDifference = computeMaxGain(nums, k, difference);
            int gainOpposite = computeMaxGain(nums, k, opposite);

            // Take the best gain and add to the original count of k
            return originalKCount + Math.max(gainDifference, gainOpposite);
        }

        int diff = maxFreqNum - k;
        int oppDiff = -diff;

        int[] first = new int[nums.length];
        System.arraycopy(nums, 0, first, 0, nums.length);
        int[] second = new int[nums.length];
        System.arraycopy(nums, 0, second, 0, nums.length);

        int diffFirstIndex = findFirst(nums, diff);
        int diffLastIndex = findLast(nums, diff);
        int oppDiffFirstIndex = findFirst(nums, oppDiff);
        int oppDiffLastIndex = findLast(nums, oppDiff);

        for (int i = diffFirstIndex; i <= diffLastIndex; i++) {
            if (diff + first[i] == k) {
                continue;
            }
            first[i] = diff + first[i];
        }

        for (int i = oppDiffFirstIndex; i <= oppDiffLastIndex; i++) {
            if (diff + second[i] == k) {
                continue;
            }
            second[i] = oppDiff + second[i];
        }


        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < n; i++) {
            if (first[i] == k) {
                firstNum++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (second[i] == k) {
                secondNum++;
            }
        }

        return Math.max(firstNum, secondNum);
    }

    private int computeMaxGain(int[] nums, int k, int x) {
        int currentSum = 0;
        int maxSum = 0;
        for (int num : nums) {
            // Calculate contribution: +1 if becomes k, -1 if was k and changes
            int value = (num + x == k) ? 1 : (num == k) ? -1 : 0;
            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum > 0 ? maxSum : 0; // Ensure no negative contribution
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
