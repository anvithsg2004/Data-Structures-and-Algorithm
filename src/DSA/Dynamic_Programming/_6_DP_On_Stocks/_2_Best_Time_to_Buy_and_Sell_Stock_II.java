package DSA.Dynamic_Programming._6_DP_On_Stocks;

import java.util.Arrays;

public class _2_Best_Time_to_Buy_and_Sell_Stock_II {

    //Recursion
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return helper(prices, 0, 0); // Start at index 0 with the option to buy.
    }

    public int helper(int[] prices, int index, int buyOrNot) {
        if (index == prices.length) {
            return 0; // Base case: No more days to process.
        }

        int profit = 0;

        if (buyOrNot == 0) { // We can buy the stock
            profit = Math.max(
                    helper(prices, index + 1, 0), // Skip buying
                    -prices[index] + helper(prices, index + 1, 1) // Buy the stock
            );
        } else { // We cannot buy (we already hold a stock)
            profit = Math.max(
                    helper(prices, index + 1, 1), // Skip selling (hold the stock)
                    prices[index] + helper(prices, index + 1, 0) // Sell the stock
            );
        }

        return profit;
    }


    //Memoization
    public int maxProfit2(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(prices, 0, 0, dp);
    }

    public int helper2(int[] prices, int index, int buyOrnOt, int[][] dp) {

        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buyOrnOt] != -1) {
            return dp[index][buyOrnOt];
        }

        int profit = 0;

        if (buyOrnOt == 0) {
            profit = Math.max(helper2(prices, index + 1, 0, dp),
                    -prices[index] + helper2(prices, index + 1, 1, dp));
        }

        if (buyOrnOt == 1) {
            profit = Math.max(helper2(prices, index + 1, 1, dp),
                    prices[index] + helper2(prices, index + 1, 0, dp));
        }

        return dp[index][buyOrnOt] = profit;

    }

}
