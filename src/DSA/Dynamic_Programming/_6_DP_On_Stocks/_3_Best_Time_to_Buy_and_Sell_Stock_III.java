package DSA.Dynamic_Programming._6_DP_On_Stocks;

import java.util.Arrays;

public class _3_Best_Time_to_Buy_and_Sell_Stock_III {

    //Recursion
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return helper(prices, 0, 0, 0); // Start at index 0 with the option to buy.
    }

    public int helper(int[] prices, int index, int buyOrNot, int time) {
        if (index == prices.length || time == 2) {
            return 0; // Base case: No more days to process.
        }

        int profit = 0;

        if (buyOrNot == 0 && time < 3) { // We can buy the stock
            profit = Math.max(
                    helper(prices, index + 1, 0, time), // Skip buying
                    -prices[index] + helper(prices, index + 1, 1, time) // Buy the stock
            );
        }

        if (buyOrNot == 1 && time < 3) { // We cannot buy (we already hold a stock)
            profit = Math.max(
                    helper(prices, index + 1, 1, time), // Skip selling (hold the stock)
                    prices[index] + helper(prices, index + 1, 0, time + 1) // Sell the stock
            );
        }

        return profit;
    }


    //Memoization
    public int maxProfit2(int[] prices) {
        int n = prices.length;

        // Memoization table: dp[index][buyOrNot][time]
        int[][][] dp = new int[n][2][3];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return helper2(0, 0, 0, prices, dp);
    }

    public int helper2(int index, int buyOrNot, int time, int[] prices, int[][][] dp) {
        // Base case: if we've processed all days or completed two transactions
        if (index == prices.length || time == 2) {
            return 0;
        }

        // Check if a result is already computed
        if (dp[index][buyOrNot][time] != -1) {
            return dp[index][buyOrNot][time];
        }

        int profit = 0;

        if (buyOrNot == 0) { // We can buy
            profit = Math.max(
                    helper2(index + 1, 0, time, prices, dp), // Skip buying
                    -prices[index] + helper2(index + 1, 1, time, prices, dp) // Buy stock
            );
        } else { // We can sell
            profit = Math.max(
                    helper2(index + 1, 1, time, prices, dp), // Skip selling
                    prices[index] + helper2(index + 1, 0, time + 1, prices, dp) // Sell stock
            );
        }

        return dp[index][buyOrNot][time] = profit; // Memoize result
    }
}
