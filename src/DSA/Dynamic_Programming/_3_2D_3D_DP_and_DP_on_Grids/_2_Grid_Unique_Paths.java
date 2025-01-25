package DSA.Dynamic_Programming._3_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

public class _2_Grid_Unique_Paths {

    //Recursion
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }

    public int helper(int row, int column) {
        if (row == 0 && column == 0) {
            return 1;
        }

        if (row < 0 || column < 0) {
            return 0;
        }

        int up = helper(row - 1, column);
        int left = helper(row, column - 1);

        return up + left;
    }

    //Memoization
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(m - 1, n - 1, dp);

    }

    public int helper2(int row, int column, int[][] dp) {

        if (row == 0 && column == 0) {
            return 1;
        }

        if (row < 0 || column < 0) {
            return 0;
        }

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        int up = helper2(row - 1, column, dp);
        int left = helper2(row, column - 1, dp);

        return dp[row][column] = up + left;

    }

}
