package DSA.Dynamic_Programming._2_1D_Array_DP;

import java.util.Arrays;

public class _4_Maximum_sum_of_non_adjacent_elements {

    //Recursion
    public int rob(int[] nums) {
        return helper(nums.length, nums);
    }

    //Here we are not allowed to take adjacent house.

    public int helper(int index, int[] nums) {

        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        //Pick the current and skip the next and take next next index.
        int pick = nums[index] + helper(index - 2, nums);

        //Do not take the current and take the next.
        int nonPick = 0 + helper(index - 1, nums);

        return Math.min(pick, nonPick);

    }

    //Memoization
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper2(n - 1, nums, dp);
    }

    public int helper2(int index, int[] arr, int[] dp) {

        if (index == 0) {
            return arr[index];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = arr[index] + helper2(index - 2, arr, dp);

        int notPick = 0 + helper2(index - 1, arr, dp);

        return dp[index] = Math.max(pick, notPick);

    }

    //Tabulation
    public int rob3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];

            if (i > 1) {
                pick = pick + dp[i - 2];
            }

            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

}
