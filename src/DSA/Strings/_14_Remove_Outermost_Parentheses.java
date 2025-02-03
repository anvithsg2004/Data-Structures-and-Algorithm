package DSA.Strings;

import java.util.Stack;

public class _14_Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {

        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
                bracket.push('(');
            } else {
                bracket.pop();
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
            }

        }

        return sb.toString();

    }
}
