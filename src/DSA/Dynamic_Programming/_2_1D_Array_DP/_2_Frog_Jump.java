package DSA.Dynamic_Programming._2_1D_Array_DP;

import java.util.Arrays;

public class _2_Frog_Jump {

    //Recursion
    public int minimumEnergy(int[] arr, int n) {
        return helper(arr, n - 1);
    }

    //A frog can can jump by either taking a 1-step or 2-step jump.
    public int helper(int[] arr, int index) {

        if (index == 0) {
            return 0;
        }

        int left = helper(arr, index - 1) + Math.abs(arr[index] - arr[index - 1]);

        int right = Integer.MAX_VALUE;

        //Here this condition is compulsory to make sure that it won't make an exception.
        if (index >= 2) {
            right = helper(arr, index - 2) + Math.abs(arr[index] - arr[index - 2]);
        }

        return Math.min(left, right);

    }

    //Memoization
    public int minimumEnergy2(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper2(n - 1, arr, dp);
    }

    public int helper2(int index, int[] arr, int[] dp) {

        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int jumpTwo = Integer.MAX_VALUE;

        int jumpOne = helper2(index - 1, arr, dp) + Math.abs(arr[index] - arr[index - 1]);

        if (index > 1) {
            jumpTwo = helper2(index - 2, arr, dp) + Math.abs(arr[index] - arr[index - 2]);
        }

        return dp[index] = Math.min(jumpOne, jumpTwo);

    }

    //Tabulation
    public int minimumEnergy3(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);

            if (i > 1) {
                jumpTwo = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }

            dp[i] = Math.min(jumpOne, jumpTwo);

        }

        return dp[n - 1];
    }
}
