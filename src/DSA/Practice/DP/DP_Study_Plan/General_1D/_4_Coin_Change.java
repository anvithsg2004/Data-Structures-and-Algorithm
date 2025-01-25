package DSA.Practice.DP.DP_Study_Plan.General_1D;

public class _4_Coin_Change {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        return helper(0, coins, amount);

    }

    public int helper(int index, int[] coins, int target) {

        if (index == 0) {
            if (target == coins[index]) {
                return 1;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        int notPick = helper(index + 1, coins, target);

        int pick = 0;

        if (coins[index] <= target) {
            pick = pick + helper(index + 1, coins, target - coins[index]);
        }

        return Math.max(notPick, pick);

    }
}
