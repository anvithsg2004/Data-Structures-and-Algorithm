package DSA.Stack_and_Queue.Conversion;

import java.util.Stack;

public class _3_PrefixToPostfix {

    // Check if character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();

        // Scan from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (c == ' ') continue; // skip spaces

            if (isOperator(c)) {
                // Pop two operands
                String op1 = stack.pop();
                String op2 = stack.pop();

                // Form postfix string: operand1 operand2 operator
                String temp = op1 + op2 + c;
                stack.push(temp);
            } else {
                // Operand → push
                stack.push(c + "");
            }
        }

        return stack.peek();
    }

}
