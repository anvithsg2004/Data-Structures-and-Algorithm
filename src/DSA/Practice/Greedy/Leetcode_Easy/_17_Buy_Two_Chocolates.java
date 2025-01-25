package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _17_Buy_Two_Chocolates {

    //OG Solution
    public int buyChoco2(int[] prices, int money) {
        Arrays.sort(prices);
        //if (prices.length >= 2) {
        int totalCost = prices[0] + prices[1];
        if (totalCost <= money) {
            return money - totalCost;
        }
        // }
        return money;
    }

    //My Solution
    public static int buyChoco(int[] prices, int money) {

        Arrays.sort(prices);

        int n = prices.length;

        int duplicateMoney = money;

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count == 2) {
                return duplicateMoney;
            }

            if (prices[i] <= duplicateMoney) {
                count++;
                duplicateMoney = duplicateMoney - prices[i];
            } else {
                break;
            }
        }

        if (count == 2) {
            return duplicateMoney;
        } else {
            return money;
        }

        //If fewer than 2 chocolates were bought, it calculates the remaining money as follows:
        //money - duplicateMoney gives the amount of money spent.
        //money - (money - duplicateMoney) simplifies back to duplicateMoney.
        //return count == 2 ? duplicateMoney : money - (money - duplicateMoney);
        //return money;
    }

    public static void main(String[] args) {
        //int[] prices = {25, 24, 108};
        int[] prices = {25, 24};
        System.out.println(buyChoco(prices, 92));
    }
}
