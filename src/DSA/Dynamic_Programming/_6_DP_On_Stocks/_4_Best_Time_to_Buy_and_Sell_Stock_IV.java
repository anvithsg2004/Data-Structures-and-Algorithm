package DSA.Dynamic_Programming._6_DP_On_Stocks;

import java.util.Arrays;

public class _4_Best_Time_to_Buy_and_Sell_Stock_IV {

    //Recursion
    public int maxProfit(int k, int[] prices) {
        return helper(prices, 0, 0, 0, k); // Start at index 0 with the option to buy.
    }

    public int helper(int[] prices, int index, int buyOrNot, int transactions, int k) {
        // Base case: If all days are processed or transactions reach the limit
        if (index == prices.length || transactions == k) {
            return 0;
        }

        int profit = 0;

        if (buyOrNot == 0) { // We can buy the stock
            profit = Math.max(
                    helper(prices, index + 1, 0, transactions, k), // Skip buying
                    -prices[index] + helper(prices, index + 1, 1, transactions, k) // Buy the stock
            );
        } else { // We can sell the stock
            profit = Math.max(
                    helper(prices, index + 1, 1, transactions, k), // Skip selling
                    prices[index] + helper(prices, index + 1, 0, transactions + 1, k) // Sell the stock
            );
        }

        return profit;
    }


    //Memoization
    public int maxProfit2(int k, int[] prices) {

        int n = prices.length;

        // Memoization table: dp[index][buyOrNot][transactions]
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return helper2(0, 0, 0, k, prices, dp);
    }

    public int helper2(int index, int buyOrNot, int transactions, int k, int[] prices, int[][][] dp) {

        if (index == prices.length || transactions == k) {
            return 0;
        }

        if (dp[index][buyOrNot][transactions] != -1) {
            return dp[index][buyOrNot][transactions];
        }

        int profit = 0;

        if (buyOrNot == 0) {
            profit = Math.max(helper2(index + 1, 0, transactions, k, prices, dp),
                    -prices[index] + helper2(index + 1, 1, transactions, k, prices, dp));
        }

        if (buyOrNot == 1) {
            profit = Math.max(helper2(index + 1, 1, transactions, k, prices, dp),
                    prices[index] + helper2(index + 1, 0, transactions + 1, k, prices, dp));
        }

        return dp[index][buyOrNot][transactions] = profit;

    }
}
