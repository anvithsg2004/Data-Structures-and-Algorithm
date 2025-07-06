class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        return help(prices, 0, 0, 0);

    }

    public int help(int[] prices, int index, int buy, int limit) {

        if (index == prices.length) {
            return 0;
        }

        int profit = 0;

        // I can buy
        if (buy == 0 && limit < 3) {
            profit = Math.max(help(prices, index + 1, 0, limit), (-prices[index] + help(prices, index + 1, 1, limit)));
        } else if (buy == 1) {
            profit = Math.max(help(prices, index + 1, 1, limit), (prices[index] + help(prices, index + 1, 0, limit + 1)));
        }

        return profit;

    }
}
