package DSA.Dynamic_Programming._2_1D_Array_DP;

import java.util.Arrays;

public class _3_Frog_Jump_with_k_Distances {

    //Recursion
    public int minimizeCost(int k, int[] arr) {
        return helper(arr.length - 1, k, arr);
    }

    //A frog can can jump by either taking a kth-step jump.
    public int helper(int index, int k, int[] arr) {

        if (index == 0) {
            return 0;
        }

        int minimumSteps = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {

            if (index - i >= 0) {
                int jump = helper(index - i, k, arr) + Math.abs(arr[index] - arr[index - i]);
                minimumSteps = Math.min(jump, minimumSteps);
            }

        }

        return minimumSteps;

    }

    //Memoization
    public int minimizeCost2(int k, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper2(n - 1, k, arr, dp);
    }

    public int helper2(int index, int k, int[] arr, int[] dp) {

        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minimumSteps = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {

            if (index - i >= 0) {
                int jump = helper(index - i, k, arr) + Math.abs(arr[index] - arr[index - i]);
                minimumSteps = Math.min(jump, minimumSteps);
            }

        }

        return dp[index] = minimumSteps;

    }

    //Tabulation
    public int minimizeCost3(int k, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minimumSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minimumSteps = Math.min(jump, minimumSteps);
                }
            }

            dp[i] = minimumSteps;
        }

        return dp[n - 1];
    }

}
