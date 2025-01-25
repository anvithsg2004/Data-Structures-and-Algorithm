package DSA.Dynamic_Programming._6_DP_On_Stocks;

public class _1_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int mini = prices[0];

        for (int i = 1; i < n; i++) {
            int currentProfit = prices[i] - mini;
            maxProfit = Math.max(currentProfit, maxProfit);
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}
