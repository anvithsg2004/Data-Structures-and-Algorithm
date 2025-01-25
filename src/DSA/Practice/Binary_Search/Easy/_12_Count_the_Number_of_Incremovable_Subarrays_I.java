package DSA.Practice.Binary_Search.Easy;

public class _12_Count_the_Number_of_Incremovable_Subarrays_I {

    public int incremovableSubarrayCount(int[] nums) {

        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (check(nums, i, j)) {

                    count++;

                }

            }

        }

        return count;

    }

    public boolean check(int[] nums, int low, int high) {

        for (int i = 0; i < low - 1; i++) {

            if (nums[i] >= nums[i + 1]) {
                return false;
            }

        }

        if (low > 0 && high < nums.length - 1 && nums[low - 1] >= nums[high + 1]) {

            return false;

        }

        for (int i = high + 1; i < nums.length - 1; i++) {

            if (nums[i] >= nums[i + 1]) {

                return false;

            }

        }

        return true;

    }


    //Learn this code.

    public int incremovableSubarrayCount2(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Find the longest valid subarray starting at each index `i`
            count += countIncremovableFrom(i, nums);
        }

        return count;
    }

    private int countIncremovableFrom(int start, int[] nums) {
        int n = nums.length;
        int left = start;
        int right = n - 1;

        // Perform binary search to find the longest valid subarray
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isIncremovable(nums, start, mid)) {
                left = mid + 1;  // Expand rightward
            } else {
                right = mid;  // Restrict the range
            }
        }

        return left - start;
    }

    private boolean isIncremovable(int[] nums, int low, int high) {
        // Check elements before and after subarray [low, high]
        for (int i = 0; i < low - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        if (low > 0 && high < nums.length - 1 && nums[low - 1] > nums[high + 1]) {
            return false;
        }
        for (int i = high + 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
