package neetcode150._3_Sliding_Window;

public class _1_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            minPrice = Math.min(minPrice, prices[i]);
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);

        }

        return maxProfit;

    }
}
