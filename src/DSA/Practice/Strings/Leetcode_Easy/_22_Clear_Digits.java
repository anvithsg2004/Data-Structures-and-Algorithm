package DSA.Practice.Strings.Leetcode_Easy;

import java.util.Stack;

public class _22_Clear_Digits {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                count++;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        if (count == 0) {
            return s;
        } else {
            return result.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String s = "cbf";
        System.out.println(clearDigits(s));
    }
}
