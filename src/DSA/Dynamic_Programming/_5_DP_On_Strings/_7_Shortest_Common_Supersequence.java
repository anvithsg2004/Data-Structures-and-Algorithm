package DSA.Dynamic_Programming._5_DP_On_Strings;

public class _7_Shortest_Common_Supersequence {
    public String shortestSupersequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                index--;
                i--;
                j--;
                //If in two which is greater, move to the greater and add the lower string to the String.
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                //If in two which is greater, move to the greater and add the lower string to the String.
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        //Adding Remaining Characters - Only one of the below two while loops will run

        while (i > 0) {
            ans.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(s2.charAt(j - 1));
            j--;
        }

        String ans2 = new StringBuilder(ans.toString()).reverse().toString();

        return ans2;
    }
}
