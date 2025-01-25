package DSA.Practice.DP.Easy;

import java.util.Arrays;

public class _4_Climbing_Stairs {

    //Recursion
    public int climbStairs(int n) {
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int count = 0;

        count = count + helper(n - 1) + helper(n - 2);

        return count;
    }

    //Memoization
    public int climbStairs2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper2(n, dp);
    }

    public int helper2(int n, int[] dp) {

        if (dp[n] != -1) {
            return dp[n];
        }

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int count = 0;

        count = count + helper2(n - 1, dp) + helper2(n - 2, dp);

        return count;

    }

}
