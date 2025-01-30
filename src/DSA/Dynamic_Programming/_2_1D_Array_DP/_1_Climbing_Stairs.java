package DSA.Dynamic_Programming._2_1D_Array_DP;

//How to Solve DP Questions
//1. Try to represent any problems in terms of index
//2. Do all possible stuff on that index, according to the problem statement
//3. Sum of all stuffs → count all the ways , min(of all stuffs) -> Find min

public class _1_Climbing_Stairs {

    //Recursion Way
    public int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int left = climbStairs(n - 1);

        int right = climbStairs(n - 2);

        return left + right;

    }

    //Memoization
    public int climbStairs(int n, int[] memo) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);

    }

    //Tabulation
    public int climbStairs2(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[3];

    }
}
