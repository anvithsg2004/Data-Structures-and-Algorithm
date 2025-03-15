package DSA.Array.SubArray;

public class _6_Kadane_Algorithm {
    public static int maxSubArraySum(int[] nums) {
        // Initialize maxSum with the first element (handles all-negative cases)
        int maxSum = nums[0];

        // Current sum starts at 0 and accumulates subarray sums
        int currentSum = 0;

        // Loop through each number in the array
        for (int num : nums) {
            // Add the current number to the running sum
            currentSum = currentSum + num;

            // Update maxSum if currentSum is greater than maxSum
            maxSum = Math.max(maxSum, currentSum);

            // If currentSum becomes negative, reset it to 0
            // This is because a negative sum will only decrease future sums
            if (currentSum < 0) currentSum = 0;
        }

        // Return the maximum subarray sum found
        return maxSum;
    }
}
