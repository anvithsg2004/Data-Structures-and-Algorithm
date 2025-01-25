package DSA.LeetCode.Stack_Queues;

import java.util.Stack;

public class Minimum_Deletions_to_Make_String_Balanced {

    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int deletion = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (stack.peek() == 'b') {
                    stack.pop();
                    deletion++;
                }
                else {
                    stack.push(c);
                }
            } else if (c == 'b') {
                stack.push(c);
            }
        }

        return deletion;
    }

    public static void main(String[] args) {

    }
}
