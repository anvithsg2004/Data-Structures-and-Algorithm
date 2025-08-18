package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _8_Jump_Game_II {

    //Recursion
    public int jump(int[] nums) {
        int n = nums.length;
        return helper(0, 0, nums, n);
    }

    public int helper(int index, int jumps, int[] nums, int n) {

        if (index >= n - 1) {
            return jumps;
        }

        if (nums[index] == 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            int result = helper(index + i, jumps + 1, nums, n);
            mini = Math.min(mini, result);
        }

        return mini;

    }

    //Memoization
    public int jump2(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n]; // Memoization array, initialized with -1
        Arrays.fill(memo, -1);
        return helper(0, nums, n, memo);
    }

    public int helper(int index, int[] nums, int n, int[] memo) {
        // If we've reached or exceeded the last index, no more jumps are needed
        if (index >= n - 1) {
            return 0;
        }

        // If the current position cannot jump further
        if (nums[index] == 0) {
            return Integer.MAX_VALUE; // Impossible to proceed
        }

        // If the result for the current index is already computed, return it
        if (memo[index] != -1) {
            return memo[index];
        }

        int mini = Integer.MAX_VALUE;

        // Explore all possible jumps from the current index
        for (int i = 1; i <= nums[index]; i++) {
            int result = helper(index + i, nums, n, memo);
            if (result != Integer.MAX_VALUE) { // Only consider valid paths
                mini = Math.min(mini, 1 + result);
            }
        }

        // Store the computed result for the current index
        memo[index] = mini;

        return mini;
    }
}
