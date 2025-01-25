package DSA.Stack_and_Queue;

import java.util.Stack;

//Refer this link: https://chatgpt.com/share/678d2c88-f410-800c-92ff-8c72a4c67acb

public class _7_Sum_of_Subarray_Minimum {

    // Sum of Subarray Minimums using PSE and NSE
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;

        //Here in the stack we are storing the indies.
        int[] PSE = PreviousSmallerElement(arr);
        int[] NSE = NextSmallerElement(arr);

        long result = 0;

        for (int i = 0; i < n; i++) {
            long countLeft = i - PSE[i];
            long countRight = NSE[i] - i;
            result = (result + (arr[i] * countLeft * countRight)) % mod;
        }

        return (int) result;
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
