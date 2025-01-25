package DSA.Practice.DP.DP_Study_Plan.General_1D;

import java.util.Arrays;

public class _3_Domino_and_Tromino_Tiling {

    //Recursion
    final int MOD = 1_000_000_007;

    public int numTilings(int n) {

        return helper(n);

    }

    public int helper(int n) {

        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        if (n == 3) {
            return 5;
        }

        return (int) (((2L * helper(n - 1)) % MOD + helper(n - 3)) % MOD);

    }

    //Memoization
    public int numTilings2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper2(n, dp);

    }

    public int helper2(int n, int[] dp) {

        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        if (n == 3) {
            return 5;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = (int) (((2 * helper2(n - 1, dp)) % MOD + helper2(n - 3, dp)) % MOD);

    }


    public static void main(String[] args) {
    }

}
