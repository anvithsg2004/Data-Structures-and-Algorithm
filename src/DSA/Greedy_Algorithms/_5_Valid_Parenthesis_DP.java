package DSA.Greedy_Algorithms;

public class _5_Valid_Parenthesis_DP {
    public boolean checkValidString(String s) {

        int n = s.length();

        Boolean[][] dp = new Boolean[n][n + 1];

        return helper(s, 0, 0, dp);
    }

    public boolean helper(String s, int index, int count, Boolean[][] dp) {

        if (count < 0) {
            return false;
        }

        if (index == s.length()) {
            if (count == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (dp[index][count] != null) {
            return dp[index][count];
        }

        boolean result;

        char ch = s.charAt(index);

        if (ch == '(') {
            result = helper(s, index + 1, count + 1, dp);
        } else if (ch == ')') {
            result = helper(s, index + 1, count - 1, dp);
        } else {
            result = helper(s, index + 1, count + 1, dp) ||
                    helper(s, index + 1, count - 1, dp) ||
                    helper(s, index + 1, count, dp);
        }

        return dp[index][count] = result;

    }

}
