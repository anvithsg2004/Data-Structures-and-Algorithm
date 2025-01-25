package DSA.Practice.DP.Medium;

import java.util.Arrays;

public class _3_House_Robber {

    //Recursion
    public int rob(int[] nums) {

        int n = nums.length;

        return helper(0, n - 1, nums);

    }

    public int helper(int index, int n, int[] values) {

        if (index > n) {
            return 0;
        }

        if (index == n) {
            return values[n];
        }

        int rob = values[index] + helper(index + 2, n, values);

        int doNotRob = helper(index + 1, n, values);

        return Math.max(rob, doNotRob);

    }

    //Memoization

    public int rob2(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return helper2(0, n - 1, nums, dp);

    }

    public int helper2(int index, int n, int[] values, int[] dp) {

        if (index > n) {
            return 0;
        }

        if (index == n) {
            return values[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int rob = values[index] + helper2(index + 2, n, values, dp);

        int doNotRob = helper2(index + 1, n, values, dp);

        return dp[index] = Math.max(rob, doNotRob);

    }
}
