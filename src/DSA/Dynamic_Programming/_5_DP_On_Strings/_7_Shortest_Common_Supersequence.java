package DSA.Dynamic_Programming._5_DP_On_Strings;

// Length of SCS = Length(s1) + Length(s2) - Length of LCS(s1, s2)

public class _7_Shortest_Common_Supersequence {
    public String shortestSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table for LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack to build the SCS
        int i = n, j = m;
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters (only one of these while loops will run)
        while (i > 0) {
            ans.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(s2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }
}
