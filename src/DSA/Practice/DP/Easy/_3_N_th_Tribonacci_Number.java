package DSA.Practice.DP.Easy;

import java.util.Arrays;

public class _3_N_th_Tribonacci_Number {

    //Recursion
    public int tribonacci(int n) {
        return helper(n);
    }

    public int helper(int n) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int sum = 0;

        sum = sum + helper(n - 1) + helper(n - 2) + helper(n - 3);

        return sum;

    }

    //Memoization
    public int tribonacci2(int n) {

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return helper2(n, dp);
    }

    public int helper2(int n, int[] dp) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int sum = 0;

        sum = sum + helper2(n - 1, dp) + helper2(n - 2, dp) + helper2(n - 3, dp);

        return dp[n] = sum;

    }

}
