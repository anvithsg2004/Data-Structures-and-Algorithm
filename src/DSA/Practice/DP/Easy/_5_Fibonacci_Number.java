package DSA.Practice.DP.Easy;

import java.util.Arrays;

public class _5_Fibonacci_Number {

    //Recursion
    public int fib(int n) {
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n < 0) {
            return 0;
        }

        return helper(n - 1) + helper(n - 2);
    }

    //Memoization
    public int fib2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper2(n, dp);
    }

    public int helper2(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return helper2(n - 1, dp) + helper2(n - 2, dp);
    }


}
