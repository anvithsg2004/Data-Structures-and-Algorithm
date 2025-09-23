package DSA.Stack_and_Queue.Conversion;

import java.util.Stack;

public class _6_InfixToPrefix {

    // Check if character is operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Operator precedence
    private static int precedence(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    // Convert infix to prefix
    public static String convert(String infix) {
        StringBuilder reversed = new StringBuilder(infix).reverse();
        // Swap parentheses
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (c == '(') reversed.setCharAt(i, ')');
            else if (c == ')') reversed.setCharAt(i, '(');
        }

        // Convert reversed expression to postfix
        String postfix = infixToPostfix(reversed.toString());

        // Reverse postfix → prefix
        return new StringBuilder(postfix).reverse().toString();
    }

    // Helper: Infix to Postfix conversion
    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') continue;

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

}
