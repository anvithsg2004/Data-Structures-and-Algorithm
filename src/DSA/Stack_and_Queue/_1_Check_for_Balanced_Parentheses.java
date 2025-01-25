package DSA.Stack_and_Queue;

import java.util.Stack;

public class _1_Check_for_Balanced_Parentheses {

    //Here we encounter many cases.
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char it : s.toCharArray()) {

            //If you get any opening brackets, push into the stack.
            if (it == '(' || it == '[' || it == '{') {
                stack.push(it);
            } else {
                //If you get the stack is empty, then there is a partner for the closing brackets.
                if (stack.isEmpty()) {
                    return false;
                }
                //If you get any closing bracket, check it with the top element of the stack.
                //And continue.
                char ch = stack.pop();
                if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{')) {
                    continue;
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

}
