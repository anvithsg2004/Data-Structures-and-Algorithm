package DSA.Stack_and_Queue;

import java.util.Stack;

public class _5_Previous_Smaller_Element {

    public int[] PreviousSmallerElement(int[] nums) {

        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(nums[i]);

        }

        return result;

    }

}
