package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.Arrays;

public class _5_Minimum_insertions_to_make_string_palindrome {
    public int minInsertions(String s) {
        int n = s.length();
        String reversed = new StringBuilder(s).reverse().toString();
        int k = longestCommonSubsequence3(s, reversed);

        return n - k;
    }

    public int longestCommonSubsequence3(String text1, String text2) {

        // Get the lengths of the two strings
        int n = text1.length();
        int m = text2.length();

        // Create a 2D array to store the lengths of LCS for substrings of text1 and text2
        // dp[i][j] will represent the LCS length of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize all values in the dp array to -1 (optional, not used here after reinitialization)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base case: If either string is empty, the LCS length is 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // LCS of text1[0..i-1] and an empty string is 0
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0; // LCS of an empty string and text2[0..j-1] is 0
        }

        // Fill the dp table using a bottom-up approach
        for (int i = 1; i <= n; i++) { // Loop through all characters of text1
            for (int j = 1; j <= m; j++) { // Loop through all characters of text2
                // If the characters match, include this character in LCS
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If they don't match, take the maximum LCS by excluding one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value at dp[n][m] gives the LCS length for the entire strings text1 and text2
        return dp[n][m];

    }
}
