package DSA.Stack_and_Queue;

import java.util.Stack;

public class _12_Remove_K_Digits {
    public String removeKdigits(String num, int k) {

        int n = num.length();

        if (k >= n) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char currentChar = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > currentChar) {
                stack.pop();
                k = k - 1;
            }
            stack.push(currentChar);
        }

        while (k > 0) {
            stack.pop();
            k = k - 1;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Reverse the result to get the correct order
        result.reverse();

        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0') {
            startIndex++;
        }

        // If all characters are removed, return "0"
        if (startIndex == result.length()) {
            return "0";
        }

        // Return the substring without leading zeros
        return result.substring(startIndex);

    }
}
