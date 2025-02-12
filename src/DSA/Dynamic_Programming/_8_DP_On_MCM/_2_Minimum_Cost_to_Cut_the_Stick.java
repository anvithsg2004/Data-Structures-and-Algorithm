package DSA.Dynamic_Programming._8_DP_On_MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2_Minimum_Cost_to_Cut_the_Stick {

    //Recursion
    public static int minCost(int n, int[] cuts) {
        int c = cuts.length;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        for (int i = 0; i < c; i++) {
            array.add(i + 1, cuts[i]);
        }
        array.add(n);

        Collections.sort(array);

        return helper(1, c, array);
    }

    public static int helper(int i, int j, ArrayList<Integer> cuts) {

        //Here this means there is only one matrix dimension, and if we have only one, it has no combination. So zero.
        if (i > j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int index = i; index <= j; index++) {
            int answer = cuts.get(j + 1) - cuts.get(i - 1) +
                    helper(i, index - 1, cuts) +
                    helper(index + 1, j, cuts);

            mini = Math.min(mini, answer);
        }

        return mini;

    }

    //Memoization
    public static int minCost2(int n, int[] cuts) {
        int c = cuts.length;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        for (int i = 0; i < c; i++) {
            array.add(i + 1, cuts[i]);
        }
        array.add(n);

        int[][] dp = new int[c + 2][c + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Collections.sort(array);

        return helper2(1, c, array, dp);
    }

    public static int helper2(int i, int j, ArrayList<Integer> cuts, int[][] dp) {

        //Here this means there is only one matrix dimension, and if we have only one, it has no combination. So zero.
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int index = i; index <= j; index++) {
            int answer = cuts.get(j + 1) - cuts.get(i - 1) +
                    helper2(i, index - 1, cuts, dp) +
                    helper2(index + 1, j, cuts, dp);

            mini = Math.min(mini, answer);
        }

        return dp[i][j] = mini;

    }
}
