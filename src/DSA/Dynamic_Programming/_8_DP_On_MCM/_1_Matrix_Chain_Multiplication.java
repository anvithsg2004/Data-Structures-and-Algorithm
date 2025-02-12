package DSA.Dynamic_Programming._8_DP_On_MCM;

import java.util.Arrays;

public class _1_Matrix_Chain_Multiplication {

    //Recursion
    public static int matrixMultiplication(int[] arr) {
        int n = arr.length;

        return helper(1, n - 1, arr);
    }

    public static int helper(int i, int j, int[] arr) {

        if (i == j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int steps =
                    //Left Partition
                    helper(i, k, arr) +
                    //Right Partition
                    helper(k + 1, j, arr) +
                    //The left resultant matrix has dimensions arr[i−1]×arr[k].
                    //The right resultant matrix has dimensions arr[k]×arr[j].
                    arr[i - 1] * arr[k] * arr[j];
            mini = Math.min(mini, steps);
        }

        return mini;

    }

    //Memoization
    public static int matrixMultiplication2(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(1, n - 1, arr, dp);
    }

    public static int helper2(int i, int j, int[] arr, int[][] dp) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int steps = helper2(i, k, arr, dp) + helper2(k + 1, j, arr, dp) + arr[i - 1] * arr[k] * arr[j];
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;

    }

    //Tabulation
    public static int matrixMultiplication3(int[] arr) {

        int n = arr.length;

        int[][] dp = new int[n][n];

        //arr[i-1] is the number of rows of the ith matrix.
        //arr[i] is the number of columns of the ith matrix.
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill in the dp array using bottom-up approach
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }

        // The result is stored in dp[1][N-1]
        return dp[1][n - 1];
    }
}
