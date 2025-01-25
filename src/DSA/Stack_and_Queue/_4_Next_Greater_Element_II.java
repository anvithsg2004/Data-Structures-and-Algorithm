package DSA.Stack_and_Queue;

import java.util.Stack;

public class _4_Next_Greater_Element_II {

    //Best Solution
    public int[] nextGreaterElements2(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        //In this the given array is circular, so multiply the array with 2.

        Stack<Integer> stack = new Stack<>();

        for (int i = (2 * n) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if (i < n) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[i % n]);
        }

        return result;
    }

    //Brute Force Solution
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n - 1; j++) {
                int index = j % n;

                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                }
            }
        }

        return result;
    }

}
