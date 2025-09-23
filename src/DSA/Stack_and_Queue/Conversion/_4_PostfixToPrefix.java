package DSA.Stack_and_Queue.Conversion;

import java.util.Stack;

public class _4_PostfixToPrefix {

    // Check if character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        // Scan from left to right
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == ' ') continue; // skip spaces

            if (isOperator(c)) {
                // Pop two operands
                String op2 = stack.pop();
                String op1 = stack.pop();

                // Form prefix: operator + operand1 + operand2
                String temp = c + op1 + op2;
                stack.push(temp);
            } else {
                // Operand → push
                stack.push(c + "");
            }
        }

        return stack.peek();
    }

}
