package DSA.Dynamic_Programming._1_Introduction;

import java.util.Arrays;

//TC :- o(n)
//SC :- o(n) = Recursion Stack Space + o(n) = Arrays

public class _1_Intro_Memorization {

    public static int dp_mem(int n, int[] dp) {

        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = dp_mem(n - 1, dp) + dp_mem(n - 2, dp);

    }

    public static void main(String[] args) {

        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(dp_mem(n, dp));

    }
}
