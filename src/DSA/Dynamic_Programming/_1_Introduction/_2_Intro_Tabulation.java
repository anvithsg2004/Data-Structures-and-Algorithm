package DSA.Dynamic_Programming._1_Introduction;

import java.util.Arrays;

public class _2_Intro_Tabulation {

    public static int tabulation(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    public static void main(String[] args) {

    }
}
