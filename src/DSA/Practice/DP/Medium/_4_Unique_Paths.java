package DSA.Practice.DP.Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _4_Unique_Paths {

    //Recursion
    public int uniquePaths(int m, int n) {

        return helper(0, 0, m - 1, n - 1);

    }

    public int helper(int i, int j, int m, int n) {

        if (i == m && j == n) {
            return 1;
        }

        if (i > m || j > n) {
            return 0;
        }

        int right = 0;

        right = right + helper(i, j + 1, m, n);

        int down = 0;

        down = down + helper(i + 1, j, m, n);

        return right + down;

    }


    //Memoization
    public int uniquePaths2(int m, int n) {

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(0, 0, m - 1, n - 1, dp);

    }

    public int helper2(int i, int j, int m, int n, int[][] dp) {

        if (i == m && j == n) {
            return 1;
        }

        if (i > m || j > n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = 0;

        right = right + helper2(i, j + 1, m, n, dp);

        int down = 0;

        down = down + helper2(i + 1, j, m, n, dp);

        return dp[i][j] = right + down;

    }

}
