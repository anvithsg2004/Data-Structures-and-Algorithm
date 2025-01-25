package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.Arrays;

public class _3_Longest_Common_Substring {
    public int longestCommonSubstr(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return answer;
    }
}
