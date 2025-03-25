package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.Arrays;

public class _6_Delete_Operation_for_Two_Strings {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return n + m - (2 * helper(word1, word2, n, m, dp));

    }

    public int helper(String s1, String s2, int length1, int length2, int[][] dp) {

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= length2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }
}
