package DSA.Stack_and_Queue.Conversion;

import java.util.Stack;

public class _5_PostfixToInfix {

    // Check if character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == ' ') continue; // skip spaces

            if (isOperator(c)) {
                // Pop two operands
                String op2 = stack.pop();
                String op1 = stack.pop();

                // Form new infix string with parentheses
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            } else {
                // Operand → push as string
                stack.push(c + "");
            }
        }

        return stack.peek();
    }

}
