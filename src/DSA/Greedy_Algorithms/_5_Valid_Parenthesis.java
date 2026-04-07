package DSA.Greedy_Algorithms;

public class _5_Valid_Parenthesis {
    public boolean checkValidString(String s) {

        int n = s.length();

        if (s.length() == 1 && s.charAt(0) == '*') {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        return helper(s, 0, 0);

    }

    public boolean helper(String s, int index, int count) {

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

        if (s.charAt(index) == '(') {
            return helper(s, index + 1, count + 1);
        }

        if (s.charAt(index) == ')') {
            return helper(s, index + 1, count - 1);
        }

        return helper(s, index + 1, count + 1) ||
                helper(s, index + 1, count - 1) ||
                helper(s, index + 1, count);

    }

}
