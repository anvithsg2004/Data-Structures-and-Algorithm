package DSA.Dynamic_Programming._4_Subsequences;

import java.util.Arrays;

public class _6_Minimum_Coins {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        return helper(n - 1, amount, coins);
    }

    public int helper(int index, int target, int[] arr) {
        if (index == 0) {
            if (target % arr[0] == 0) {
                return target / arr[0]; // Corrected line
            } else {
                return -1;
            }
        }

        int notTake = helper(index - 1, target, arr);
        int take = Integer.MAX_VALUE;

        if (arr[index] <= target) {
            int temp = helper(index, target - arr[index], arr);
            if (temp != -1) {
                take = 1 + temp;
            }
        }

        if (notTake == -1 && take == Integer.MAX_VALUE) {
            return -1;
        } else if (notTake == -1) {
            return take;
        } else if (take == Integer.MAX_VALUE) {
            return notTake;
        } else {
            return Math.min(notTake, take);
        }
    }

    //Memoization
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper2(n - 1, amount, coins, dp);
    }

    public int helper2(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target % arr[0] == 0) {
                return target / arr[0]; // Corrected line
            } else {
                return -1;
            }
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = helper2(index - 1, target, arr, dp);
        int take = Integer.MAX_VALUE;

        if (arr[index] <= target) {
            int temp = helper2(index, target - arr[index], arr, dp);
            if (temp != -1) {
                take = 1 + temp;
            }
        }

        if (notTake == -1 && take == Integer.MAX_VALUE) {
            return dp[index][target] = -1;
        } else if (notTake == -1) {
            return dp[index][target] = take;
        } else if (take == Integer.MAX_VALUE) {
            return dp[index][target] = notTake;
        } else {
            return dp[index][target] = Math.min(notTake, take);
        }
    }

}
