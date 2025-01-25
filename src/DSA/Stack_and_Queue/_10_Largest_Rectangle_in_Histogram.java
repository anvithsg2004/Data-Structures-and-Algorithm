package DSA.Stack_and_Queue;

import java.util.Stack;

public class _10_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nse = NextSmallerElement(heights);
        int[] pse = PreviousSmallerElement(heights);

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxi = Math.max(maxi, area);
        }

        return maxi;

    }

    // Function to find Previous Smaller Element (PSE) indices
    public int[] PreviousSmallerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1; // No previous smaller element
            } else {
                result[i] = stack.peek(); // Index of the previous smaller element
            }

            stack.push(i); // Push the current index
        }

        return result;
    }

    // Function to find the Next Smaller Element (NSE) indices
    public int[] NextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = n; // No next smaller element
            } else {
                result[i] = stack.peek(); // Index of the next smaller element
            }

            stack.push(i); // Push the current index
        }

        return result;
    }
}
