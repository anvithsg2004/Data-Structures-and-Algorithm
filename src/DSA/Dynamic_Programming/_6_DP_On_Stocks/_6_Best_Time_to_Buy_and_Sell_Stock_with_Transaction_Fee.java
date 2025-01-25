package DSA.Dynamic_Programming._6_DP_On_Stocks;

import java.util.Arrays;

public class _6_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    //Recursion
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return helper(prices, 0, 0, fee); // Start at index 0 with the option to buy.
    }

    public int helper(int[] prices, int index, int buyOrNot, int fee) {
        if (index == prices.length) {
            return 0; // Base case: No more days to process.
        }

        int profit = 0;

        if (buyOrNot == 0) { // We can buy the stock
            profit = Math.max(
                    helper(prices, index + 1, 0, fee), // Skip buying
                    -prices[index] + helper(prices, index + 1, 1, fee) // Buy the stock
            );
        } else { // We cannot buy (we already hold a stock)
            profit = Math.max(
                    helper(prices, index + 1, 1, fee), // Skip selling (hold the stock)
                    prices[index] - fee + helper(prices, index + 1, 0, fee) // Sell the stock
            );
        }

        return profit;
    }

    //Memoization
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;

        // Memoization table: dp[index][buyOrNot][transactions]
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(prices, 0, 0, dp, fee);
    }

    public int helper2(int[] prices, int index, int buyOrnOt, int[][] dp, int fee) {

        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buyOrnOt] != -1) {
            return dp[index][buyOrnOt];
        }

        int profit = 0;

        if (buyOrnOt == 0) {
            profit = Math.max(helper2(prices, index + 1, 0, dp, fee),
                    -prices[index] + helper2(prices, index + 1, 1, dp, fee));
        }

        if (buyOrnOt == 1) {
            profit = Math.max(helper2(prices, index + 1, 1, dp, fee),
                    prices[index] - fee + helper2(prices, index + 1, 0, dp, fee));
        }

        return dp[index][buyOrnOt] = profit;

    }
}
