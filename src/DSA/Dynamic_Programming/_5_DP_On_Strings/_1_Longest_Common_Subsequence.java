package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.Arrays;

public class _1_Longest_Common_Subsequence {

    //Recursion
    public int longestCommonSubsequence(String text1, String text2) {
        int index1 = text1.length();
        int index2 = text2.length();

        return helper(text1, text2, index1 - 1, index2 - 1);
    }

    public int helper(String text1, String text2, int index1, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + helper(text1, text2, index1 - 1, index2 - 1);
        } else {
            return Math.max(helper(text1, text2, index1 - 1, index2), helper(text1, text2, index1, index2 - 1));
        }
    }


    //memoization
    public int longestCommonSubsequence2(String text1, String text2) {
        int index1 = text1.length();
        int index2 = text2.length();

        int[][] dp = new int[index1][index2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(text1, text2, index1 - 1, index2 - 1, dp);
    }

    public int helper2(String text1, String text2, int index1, int index2, int[][] dp) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + helper2(text1, text2, index1 - 1, index2 - 1, dp);
        } else {
            return dp[index1][index2] = Math.max(helper2(text1, text2, index1 - 1, index2, dp), helper2(text1, text2, index1, index2 - 1, dp));
        }

    }

    //Tabulation
    public int longestCommonSubsequence3(String text1, String text2) {

        //Remember that DAA(Sreebha Ma'am) thought this in class.
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
