package DSA.Stack_and_Queue.Conversion;

import java.util.*;

public class _2_PrefixToInfix {

    // Check if character is operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();

        // Read from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (c == ' ') continue; // ignore spaces

            if (isOperator(c)) {
                // Pop two operands
                String op1 = stack.pop();
                String op2 = stack.pop();

                // Form new string with parentheses
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            } else {
                // Operand → push as string
                stack.push(c + "");
            }
        }

        return stack.peek(); // final infix expression
    }

}
