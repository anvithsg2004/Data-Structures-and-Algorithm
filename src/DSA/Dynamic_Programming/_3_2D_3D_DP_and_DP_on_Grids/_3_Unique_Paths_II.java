package DSA.Dynamic_Programming._3_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

public class _3_Unique_Paths_II {

    //Recursion
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        return helper(row - 1, column - 1, obstacleGrid);
    }

    public int helper(int row, int column, int[][] obstacleGrid) {

        if (row >= 0 && column >= 0 && obstacleGrid[row][column] == 1) {
            return 0;
        }

        if (row == 0 && column == 0) {
            return 1;
        }

        if (row < 0 || column < 0) {
            return 0;
        }

        int up = helper(row - 1, column, obstacleGrid);
        int left = helper(row, column - 1, obstacleGrid);

        return up + left;

    }

    //Memoization
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        int[][] dp = new int[row][column];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return helper2(row - 1, column - 1, obstacleGrid, dp);
    }

    public int helper2(int row, int column, int[][] obstacleGrid, int[][] dp) {

        if (row >= 0 && column >= 0 && obstacleGrid[row][column] == 1) {
            return 0;
        }

        if (row == 0 && column == 0) {
            return 1;
        }

        if (row < 0 || column < 0) {
            return 0;
        }

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        int up = helper(row - 1, column, obstacleGrid);
        int left = helper(row, column - 1, obstacleGrid);

        return dp[row][column] = up + left;

    }

}
