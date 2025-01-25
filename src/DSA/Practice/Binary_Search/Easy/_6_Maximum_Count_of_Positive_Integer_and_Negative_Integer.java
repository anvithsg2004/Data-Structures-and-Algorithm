package DSA.Practice.Binary_Search.Easy;

public class _6_Maximum_Count_of_Positive_Integer_and_Negative_Integer {

    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Find the index of the first positive number
        int firstPositiveIndex = fun(nums, n);

        // Count of positive numbers from the first positive index to the end
        int CountPos = n - firstPositiveIndex;

        // Find the index of the first zero or positive to get only the negatives
        int firstNonNegativeIndex = funNonNegative(nums, n);
        int CountNeg = firstNonNegativeIndex;

        // Return the maximum count between negatives and positives
        return Math.max(CountNeg, CountPos);
    }

    // Helper method to find the index of the first positive number
    public static int fun(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low; // Index of the first positive number
    }

    // Helper method to find the index of the first non-negative (zero or positive) number
    public static int funNonNegative(int[] arr, int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low; // Index of the first non-negative number
    }

    public static void main(String[] args) {

    }
}
