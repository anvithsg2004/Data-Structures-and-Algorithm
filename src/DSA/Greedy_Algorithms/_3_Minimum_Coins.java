package DSA.Greedy_Algorithms;

//Some Problem is here.

public class _3_Minimum_Coins {
    public int minCoins(int[] coins, int sum) {
        int n = coins.length;

        if (sum == 0) {
            return 0;
        }

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (sum >= coins[i]) {
                sum = sum - coins[i];
                count++;
            }

            if (sum == 0) {
                break;
            }
        }

        return count;
    }
}
