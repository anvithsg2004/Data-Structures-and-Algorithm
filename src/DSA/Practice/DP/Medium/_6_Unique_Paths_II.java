package DSA.Practice.DP.Medium;

import java.util.Arrays;

public class _6_Unique_Paths_II {

    //Recursion
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return helper(0, 0, m - 1, n - 1, obstacleGrid);

    }

    public int helper(int i, int j, int m, int n, int[][] matrix) {

        if (i > m || j > n || matrix[i][j] == 1) {
            return 0;
        }

        if (i == m && j == n) {
            return 1;
        }

        int right = 0;

        right = right + helper(i, j + 1, m, n, matrix);

        int down = 0;

        down = down + helper(i + 1, j, m, n, matrix);

        return Math.max(right, down);

    }


    //Memoization
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(0, 0, m - 1, n - 1, obstacleGrid, dp);

    }

    public int helper2(int i, int j, int m, int n, int[][] matrix, int[][] dp) {

        if (i > m || j > n || matrix[i][j] == 1) {
            return 0;
        }

        if (i == m && j == n) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = 0;

        right = right + helper2(i, j + 1, m, n, matrix, dp);

        int down = 0;

        down = down + helper2(i + 1, j, m, n, matrix, dp);

        return dp[i][j] = right + down;

    }

}
