package DSA.Dynamic_Programming._8_DP_On_MCM;

import java.util.ArrayList;
import java.util.Arrays;

public class _3_Burst_Balloons {

    //Recursion
    public int maxCoins(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        for (int i = 0; i < n; i++) {
            array.add(i + 1, nums[i]);
        }
        array.add(1);

        return helper(1, n, array);
    }

    public int helper(int i, int j, ArrayList<Integer> array) {

        if (i > j) {
            return 0;
        }

        int maxi = Integer.MIN_VALUE;

        for (int index = i; index <= j; index++) {
            int cost = (array.get(i - 1) * array.get(index) * array.get(j + 1)) +
                    helper(i, index - 1, array) +
                    helper(index + 1, j, array);

            maxi = Math.max(maxi, cost);
        }

        return maxi;

    }

    //Memoization
    public int maxCoins2(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        for (int i = 0; i < n; i++) {
            array.add(i + 1, nums[i]);
        }
        array.add(1);

        int[][] dp = new int[n + 2][n + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(1, n, array, dp);

    }

    public int helper2(int i, int j, ArrayList<Integer> array, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;

        for (int index = i; index <= j; index++) {
            int cost = (array.get(i - 1) * array.get(index) * array.get(j + 1)) +
                    helper2(i, index - 1, array, dp) +
                    helper2(index + 1, j, array, dp);

            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;

    }

}
