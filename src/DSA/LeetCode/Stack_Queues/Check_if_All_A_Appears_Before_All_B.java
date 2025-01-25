package DSA.LeetCode.Stack_Queues;

import java.util.Stack;

public class Check_if_All_A_Appears_Before_All_B {

    public boolean checkString(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    return false;
                }
                stack.push(c);
            } else if (c == 'b') {
                stack.push(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
