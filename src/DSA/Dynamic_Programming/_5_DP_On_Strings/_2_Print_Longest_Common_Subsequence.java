package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_Print_Longest_Common_Subsequence {
    public List<String> all_longest_common_subsequences(String s, String t) {

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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Now reconstruct the LCS from dp table
        int i = n;
        int j = m;

        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                lcs.append(s.charAt(i - 1)); // matched char goes to LCS
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // move up
            } else {
                j--; // move left
            }
        }

        lcs.reverse(); // Because we were adding characters from the end

        List<String> result = new ArrayList<>();
        result.add(lcs.toString()); // Add the final LCS to result list

        return result;

    }
}
