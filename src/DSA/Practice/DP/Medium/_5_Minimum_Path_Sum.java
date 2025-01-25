package DSA.Practice.DP.Medium;

import java.util.Arrays;

public class _5_Minimum_Path_Sum {

    //Recursion
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        return helper(0, 0, m - 1, n - 1, grid);

    }

    public int helper(int i, int j, int m, int n, int[][] matrix) {

        if (i == m && j == n) {
            return matrix[i][j];
        }

        if (i > m || j > n) {
            return Integer.MAX_VALUE;
        }

        int right = matrix[i][j] + helper(i, j + 1, m, n, matrix);

        int down = matrix[i][j] + helper(i + 1, j, m, n, matrix);

        return Math.max(right, down);

    }

    //Memoization
    public int minPathSum2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(0, 0, m - 1, n - 1, grid, dp);

    }

    public int helper2(int i, int j, int m, int n, int[][] matrix, int[][] dp) {

        if (i == m && j == n) {
            return matrix[i][j];
        }

        if (i > m || j > n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = matrix[i][j] + helper2(i, j + 1, m, n, matrix, dp);

        int down = matrix[i][j] + helper2(i + 1, j, m, n, matrix, dp);

        return dp[i][j] = Math.max(right, down);

    }
}
