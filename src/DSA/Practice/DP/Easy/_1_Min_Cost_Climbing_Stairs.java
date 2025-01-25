package DSA.Practice.DP.Easy;

import java.util.Arrays;

public class _1_Min_Cost_Climbing_Stairs {

    //Recursion
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return cost[0];
        }

        int zero = zeroIndexStart(0, cost);
        int one = oneIndexStart(1, cost);
        return Math.min(zero, one);
    }

    public static int zeroIndexStart(int index, int[] cost) {

        if (index >= cost.length) {
            return 0;
        }

        int left = cost[index] + zeroIndexStart(index + 1, cost);

        int right = cost[index] + zeroIndexStart(index + 2, cost);

        return Math.min(left, right);

    }

    public static int oneIndexStart(int index, int[] cost) {

        if (index >= cost.length) {
            return 0;
        }

        int left = cost[index] + oneIndexStart(index + 1, cost);

        int right = cost[index] + oneIndexStart(index + 2, cost);

        return Math.min(left, right);

    }

    //Memoization
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return cost[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int zero = zeroIndexStart2(0, cost, dp1);
        int one = oneIndexStart2(1, cost, dp2);

        return Math.min(zero, one);
    }

    public static int zeroIndexStart2(int index, int[] cost, int[] dp) {

        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int left = cost[index] + zeroIndexStart2(index + 1, cost, dp);

        int right = cost[index] + zeroIndexStart2(index + 2, cost, dp);

        return dp[index] = Math.min(left, right);

    }

    public static int oneIndexStart2(int index, int[] cost, int[] dp) {

        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int left = cost[index] + oneIndexStart2(index + 1, cost, dp);

        int right = cost[index] + oneIndexStart2(index + 2, cost, dp);

        return dp[index] = Math.min(left, right);

    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
