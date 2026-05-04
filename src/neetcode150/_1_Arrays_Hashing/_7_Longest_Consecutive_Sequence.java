package neetcode150._1_Arrays_Hashing;

import java.util.*;

public class _7_Longest_Consecutive_Sequence {

    // My Method
    public static int longestConsecutive(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int maxConsecutive = Integer.MIN_VALUE;
        int currentConsecutive = 1;

        int previousElement = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (nums[i] - 1 == previousElement) {
                currentConsecutive = currentConsecutive + 1;
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
            } else if (nums[i] == previousElement) {
                continue;
            } else {
                currentConsecutive = 1;
            }

            previousElement = nums[i];

        }

        return maxConsecutive;

    }

    // O(1)
    public static int longestConsecutive1(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }

        int longest = 1;

        for (int i = 0; i < n; i++) {

            // This is the new beginning

            if (!hashSet.contains(nums[i] - 1)) {

                int currentNum = nums[i];
                int count = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);

            }

        }

        return longest;

    }

}
