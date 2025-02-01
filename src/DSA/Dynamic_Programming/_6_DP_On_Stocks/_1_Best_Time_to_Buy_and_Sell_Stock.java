package DSA.Dynamic_Programming._6_DP_On_Stocks;

public class _1_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int mini = prices[0];

        for (int i = 1; i < n; i++) {
            //Calculate the profit for the last minimum.
            int currentProfit = prices[i] - mini;
            //Get the maximum profit.
            maxProfit = Math.max(currentProfit, maxProfit);
            //If the current is the minimum, then add make it as the minimum.
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}
