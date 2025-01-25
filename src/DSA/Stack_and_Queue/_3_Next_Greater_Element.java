package DSA.Stack_and_Queue;

//Monotonic Stack = This means when we follow a specific order to store the elements.

//The method is that
//1)We traverse from the back.
//2)If the stack is empty, then put -1 to the stack.
//3)If the stack top has the number greater than the current number, then put it to the array.
//4)If the stack does not have, then remove the elements which are smaller than the current number.

import java.util.*;

public class _3_Next_Greater_Element {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            //This is if the number in the array is greater than the number in the stack.
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }

            //If the stack is empty and all the number has removed.
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            //Put the number in the stack.
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;

    }

}
