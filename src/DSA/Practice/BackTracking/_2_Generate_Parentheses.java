package DSA.Practice.BackTracking;

import java.util.*;

public class _2_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        String ans = "(";

        helper(n - 1, n, result, ans);

        return result;

    }

    public void helper(int open, int close, List<String> result, String ans) {

        if (open < 0 || close < 0) {
            return;
        }

        if (open == 0 && close == 0) {
            if (ans.charAt(0) == ')' || ans.charAt(ans.length() - 1) == '(') {
                return;
            }

            boolean flag = false;

            int count = 0;

            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == '(') {
                    count++;
                } else if (ans.charAt(i) == ')') {
                    count--;
                }
                if (count < 0) {
                    flag = true;
                    break;
                }
            }

            if (flag == true) {
                return;
            }

            result.add(ans);
            return;
        }

        ans = ans + "(";
        helper(open - 1, close, result, ans);

        ans = ans.substring(0, ans.length() - 1);

        ans = ans + ")";
        helper(open, close - 1, result, ans);
    }
}
