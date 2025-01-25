package DSA.Practice.DP.Medium;

import java.util.Arrays;

public class _1_Best_Sightseeing_Pair {

    //Brute Force
    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    maxi = Math.max(maxi, values[i] + values[j] + i - j);
                }
            }
        }

        return maxi;

    }

    //Better Solution
    public static int maxScoreSightseeingPair2(int[] values) {
        int n = values.length;
        return helper(0, 1, n, values);
    }

    public static int helper(int index, int nextIndex, int n, int[] values) {

        if (index >= n || nextIndex >= n) {
            return 0;
        }

        int first = 0;

        if (index < n && nextIndex < n) {
            first = Math.max(values[index] + values[nextIndex] + index - nextIndex, helper(index, nextIndex + 1, n, values));
        }

        int second = 0;

        if (index < n && nextIndex < n) {
            second = Math.max(values[index] + values[nextIndex] + index - nextIndex, helper(index + 1, nextIndex + 1, n, values));
        }

        return Math.max(first, second);

    }

    //Memoization
    public static int maxScoreSightseeingPair3(int[] values) {
        int n = values.length;

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(0, 1, n, values, dp);
    }

    public static int helper2(int index, int nextIndex, int n, int[] values, int[][] dp) {

        if (index >= n || nextIndex >= n) {
            return 0;
        }

        if (dp[index][nextIndex] != -1) {
            return dp[index][nextIndex];
        }

        int first = 0;

        if (index < n && nextIndex < n) {
            first = Math.max(values[index] + values[nextIndex] + index - nextIndex, helper(index, nextIndex + 1, n, values));
        }

        int second = 0;

        if (index < n && nextIndex < n) {
            second = Math.max(values[index] + values[nextIndex] + index - nextIndex, helper(index + 1, nextIndex + 1, n, values));
        }

        return dp[index][nextIndex] = Math.max(first, second);

    }
}
