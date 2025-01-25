package DSA.Array;

import java.util.Arrays;

public class _22_Longest_Consecutive_Sequence {

    public static int longestSuccessiveElements(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int lastNumber = Integer.MIN_VALUE;
        int length = 1;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {

            // Skip duplicates
            if (nums[i] == lastNumber) {
                continue;
            }

            // Check if the current number is consecutive
            if (nums[i] - 1 == lastNumber) {
                length++;
            } else {
                length = 1;
            }

            lastNumber = nums[i];
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSuccessiveElements(nums)); // Output: 4
    }
}
