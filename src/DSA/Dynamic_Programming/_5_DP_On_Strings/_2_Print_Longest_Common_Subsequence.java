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

        int length = dp[n][m];

        int i = n;
        int j = m;

        int index = length - 1;

        String str = "";
        for (int k = 0; k < length; k++) {
            str = str + "$";
        }

        StringBuilder answer = new StringBuilder(s);

        while (i > 0 && j > 0) {

            //If the character is the same.
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                answer.setCharAt(index, s.charAt(i - 1));
                index--;
                i--;
                j--;
            } else {
                //If the character is different.
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // Convert the StringBuilder to a String and add it to a List
        List<String> result = new ArrayList<>();
        result.add(answer.toString());  // Add the LCS as the only string in the list

        return result;

    }
}
