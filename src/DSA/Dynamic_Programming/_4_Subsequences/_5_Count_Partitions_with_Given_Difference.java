package DSA.Dynamic_Programming._4_Subsequences;

import java.util.Arrays;

public class _5_Count_Partitions_with_Given_Difference {
    //Recursion
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int totalSum = 0;
        for (int it : arr) {
            totalSum = totalSum + it;
        }

        // Corrected formula for target_S2
        if ((totalSum + d) % 2 != 0 || totalSum < d) {
            return 0; // No valid partition exists
        }

        int target_S2 = (totalSum + d) / 2;

        return helper(n - 1, target_S2, arr);
    }

    public int helper(int index, int target, int[] arr) {
        if (index == 0) {
            if (target == 0 && arr[index] == 0) {
                return 2;
            }

            if (target == 0 || arr[index] == target) {
                return 1;
            }

            return 0;
        }

        int notPick = helper(index - 1, target, arr);

        int pick = 0;

        if (arr[index] <= target) {
            pick = helper(index - 1, target - arr[index], arr);
        }

        return pick + notPick;
    }

    public int countPartitions2(int[] arr, int d) {
        int n = arr.length;
        int totalSum = 0;
        for (int it : arr) {
            totalSum = totalSum + it;
        }

        // Corrected formula for target_S2
        if ((totalSum + d) % 2 != 0 || totalSum < d) {
            return 0; // No valid partition exists
        }

        int target_S2 = (totalSum + d) / 2;

        int[][] dp = new int[n][target_S2 + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper2(n - 1, target_S2, arr, dp);
    }

    public int helper2(int index, int target, int[] arr, int[][] dp) {

        if (index == 0) {
            if (target == 0 && arr[index] == 0) {
                return 2;
            }

            if (target == 0 || arr[index] == target) {
                return 1;
            }

            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = helper2(index - 1, target, arr, dp);

        int pick = 0;

        if (arr[index] <= target) {
            pick = helper2(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = pick + notPick;

    }
}
