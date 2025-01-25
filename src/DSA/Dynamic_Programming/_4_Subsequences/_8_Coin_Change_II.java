package DSA.Dynamic_Programming._4_Subsequences;

import java.util.Arrays;

public class _8_Coin_Change_II {
    //Recursion
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return helper(n - 1, amount, coins);
    }

    public int helper(int index, int amount, int[] arr) {

        if (index == 0) {
            if (amount % arr[index] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int notTaken = helper(index - 1, amount, arr);

        int taken = 0;

        if (arr[index] <= amount) {
            taken = helper(index, amount - arr[index], arr);
        }

        return taken + notTaken;

    }

    //Memoization
    public int change2(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(n - 1, amount, coins, dp);
    }

    public int helper2(int index, int target, int[] arr, int[][] dp) {

        if (index == 0) {
            if (target % arr[index] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTaken = helper2(index - 1, target, arr, dp);

        int taken = 0;

        if (arr[index] <= target) {
            taken = helper2(index, target - arr[index], arr, dp);
        }

        return dp[index][target] = taken + notTaken;

    }
}
