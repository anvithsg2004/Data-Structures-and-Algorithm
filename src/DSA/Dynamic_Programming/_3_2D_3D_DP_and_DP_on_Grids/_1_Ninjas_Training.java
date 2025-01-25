package DSA.Dynamic_Programming._3_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

public class _1_Ninjas_Training {

    //Recursion
    public int maximumPoints(int[][] arr, int N) {
        return helper(N - 1, 3, arr);
    }

    public int helper(int day, int last, int[][] points) {

        if (day == 0) {
            int maxiIndex0 = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxiIndex0 = Math.max(maxiIndex0, points[0][i]);
                }
            }
            return maxiIndex0;
        }

        int maxi = 0;

        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + helper(day - 1, i, points);
                maxi = Math.max(maxi, activity);
            }
        }

        return maxi;

    }

    //Memoization
    public int maximumPoints2(int[][] arr, int N) {

        //Here the 4 is the last visited.
        int[][] dp = new int[N][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(N - 1, 3, arr, dp);
    }

    public int helper2(int day, int last, int[][] points, int[][] dp) {

        if (day == 0) {
            int maxiIndex0 = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxiIndex0 = Math.max(maxiIndex0, points[0][i]);
                }
            }
            return dp[day][last] = maxiIndex0;
        }

        if (dp[day][last] != -1) return dp[day][last];

        int maxi = 0;

        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + helper2(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

}
