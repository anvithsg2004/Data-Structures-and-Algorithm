package DSA.Dynamic_Programming._5_DP_On_Strings;

import java.util.Arrays;

public class _8_Distinct_Subsequences {

    //Recurrence
    public int numDistinct(String s, String t) {
        // Get the lengths of the strings `s` and `t`
        int n = s.length();
        int m = t.length();

        // Call the helper method to calculate the number of distinct subsequences
        return helper(s, t, n - 1, m - 1); // Start from the end of both strings
    }

    public int helper(String s, String t, int length1, int length2) {
        // Base case 1: If the target string `t` is fully matched (length2 < 0)
        // Return 1 because we've found one valid subsequence
        if (length2 < 0) {
            return 1;
        }

        // Base case 2: If the source string `s` is exhausted (length1 < 0)
        // Return 0 because it's impossible to match any further
        if (length1 < 0) {
            return 0;
        }

        // Recursive case: Check if the current characters in `s` and `t` match
        if (s.charAt(length1) == t.charAt(length2)) {
            // Option 1: Use the current character from `s` (reduce both lengths)
            int leaveOne = helper(s, t, length1 - 1, length2 - 1);

            // Option 2: Skip the current character from `s` (reduce length1 only)
            int stay = helper(s, t, length1 - 1, length2);

            // Sum up both options to account for all valid subsequences
            return leaveOne + stay;
        } else {
            // If characters do not match, skip the current character in `s`
            // Reduce only `length1` and continue the search
            return helper(s, t, length1 - 1, length2);
        }
    }

    //Memoization
    public int numDistinct2(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(s, t, n - 1, m - 1, dp);

    }

    public int helper2(String s, String t, int length1, int length2, int[][] dp) {

        if (length2 < 0) {
            return 1;
        }

        if (length1 < 0) {
            return 0;
        }

        if (dp[length1][length2] != -1) {
            return dp[length1][length2];
        }

        if (s.charAt(length1) == t.charAt(length2)) {
            int leaveOne = helper2(s, t, length1 - 1, length2 - 1, dp);
            int stay = helper2(s, t, length1 - 1, length2, dp);

            return dp[length1][length2] = leaveOne + stay;
        } else {
            return dp[length1][length2] = helper2(s, t, length1 - 1, length2, dp);
        }

    }


    //Tabulation
    public int numDistinct3(String s, String t) {
        // Get the lengths of the strings `s` and `t`
        int n = s.length();
        int m = t.length();

        // Create a DP table with dimensions (n+1) x (m+1)
        // dp[i][j] will store the number of distinct subsequences of t[0...j-1] in s[0...i-1]
        int[][] dp = new int[n + 1][m + 1];

        // Base case: If `t` is empty, there is exactly 1 subsequence of `s` that matches `t` (the empty subsequence)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // No need to initialize dp[0][j] because it's implicitly zero in Java arrays.
        // This corresponds to: If `s` is empty and `t` is non-empty, there are 0 subsequences.
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill the DP table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // If characters match, we have two options:
                // 1. Include the current character in the subsequence (dp[i-1][j-1])
                // 2. Exclude the current character (dp[i-1][j])
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can only exclude the current character in `s`
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The answer is stored in dp[n][m], which represents the number of subsequences of `t` in `s`
        return dp[n][m];
    }
}
