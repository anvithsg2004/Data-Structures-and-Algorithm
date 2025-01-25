package DSA.Practice.DP.Easy;

public class _2_Count_number_of_hops {

    //Recursion
    public static int countWays(int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    //Memoization
    public int countWays2(int n) {
        // Handle base cases
        if (n == 0) {
            return 1;  // One way to stay at the ground
        }
        if (n == 1) {
            return 1;  // One way to reach the first step
        }
        if (n == 2) {
            return 2;  // Two ways to reach the second step
        }

        // DP array to store the number of ways to reach each step
        int[] dp = new int[n + 1];

        // Base cases initialization
        dp[0] = 1;  // One way to stay at the ground
        dp[1] = 1;  // One way to reach the first step
        dp[2] = 2;  // Two ways to reach the second step

        // Fill the dp array for steps 3 to n
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];  // Ways to reach step i
        }

        return dp[n];  // Return the number of ways to reach the nth step
    }
}
