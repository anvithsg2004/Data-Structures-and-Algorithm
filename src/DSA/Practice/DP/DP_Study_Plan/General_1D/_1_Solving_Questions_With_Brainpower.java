package DSA.Practice.DP.DP_Study_Plan.General_1D;

import java.util.Arrays;

public class _1_Solving_Questions_With_Brainpower {

    //Recursion
    public long mostPoints(int[][] questions) {

        int n = questions.length;

        return helper(0, questions, n - 1);

    }

    public int helper(int index, int[][] values, int n) {

        if (index > n) {
            return 0;
        }

        int pick = values[index][0] + helper(index + values[index][1] + 1, values, n);

        int notPick = helper(index + 1, values, n);

        return Math.max(pick, notPick);

    }


    //Memoization
    public long mostPoints2(int[][] questions) {

        int n = questions.length;

        long[] dp = new long[n];
        Arrays.fill(dp, -1);


        return helper2(0, questions, n - 1, dp);

    }

    public long helper2(int index, int[][] values, int n, long[] dp) {

        if (index > n) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        long pick = values[index][0] + helper2(index + values[index][1] + 1, values, n, dp);

        long notPick = helper2(index + 1, values, n, dp);

        return dp[index] = Math.max(pick, notPick);

    }

}
