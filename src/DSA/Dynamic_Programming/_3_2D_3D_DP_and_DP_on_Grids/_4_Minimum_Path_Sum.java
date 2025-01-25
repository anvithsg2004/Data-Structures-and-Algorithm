package DSA.Dynamic_Programming._3_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

public class _4_Minimum_Path_Sum {

    //Recursion
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        return helper(row - 1, column - 1, grid);
    }

    public int helper(int row, int column, int[][] grid) {
        // Base case: Top-left cell
        if (row == 0 && column == 0) {
            return grid[row][column];
        }

        // Check for out-of-bounds indices
        if (row < 0 || column < 0) {
            return Integer.MAX_VALUE; // Invalid path
        }

        // Recursive calls for moving up and left
        int up = helper(row - 1, column, grid);
        int left = helper(row, column - 1, grid);

        // Return the minimum path sum to the current cell
        return grid[row][column] + Math.min(up, left);
    }

    //Memoization
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int[][] dp = new int[row][column];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return helper2(row - 1, column - 1, grid, dp);
    }

    public int helper2(int row, int column, int[][] grid, int[][] dp) {
        if (row == 0 && column == 0) {
            return grid[row][column];
        }

        if (row < 0 || column < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        int up = helper2(row - 1, column, grid, dp);
        int left = helper2(row, column - 1, grid, dp);

        return dp[row][column] = grid[row][column] + Math.min(up, left);
    }
}
