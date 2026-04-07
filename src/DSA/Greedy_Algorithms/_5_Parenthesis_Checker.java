package DSA.Greedy_Algorithms;

import java.util.*;

public class _5_Parenthesis_Checker {
    public boolean isBalanced(String s) {

        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }

            }

        }

        return stack.isEmpty();

    }
}
