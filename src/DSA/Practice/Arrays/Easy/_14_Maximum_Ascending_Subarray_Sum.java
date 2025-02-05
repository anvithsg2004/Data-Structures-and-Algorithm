package DSA.Practice.Arrays.Easy;

public class _14_Maximum_Ascending_Subarray_Sum {
    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int r = 0;

        int maxSum = 0;
        int currentSum = 0;

        while (r < n - 1) {

            if (nums[r] < nums[r + 1]) {
                currentSum = currentSum + nums[r];
                maxSum = Math.max(maxSum, currentSum);
                r++;
            } else {
                currentSum = currentSum + nums[r];
                maxSum = Math.max(maxSum, currentSum);
                currentSum = 0;
                r++;
            }

        }

        if (nums[n - 2] < nums[n - 1]) {
            currentSum = currentSum + nums[n - 1];
        }

        return Math.max(maxSum, currentSum);
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }
}
