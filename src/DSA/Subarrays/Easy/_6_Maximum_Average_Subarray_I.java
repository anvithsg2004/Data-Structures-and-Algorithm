package DSA.Subarrays.Easy;

public class _6_Maximum_Average_Subarray_I {
    public static double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        if (n < k) {
            return 0;
        }

        if (n == 1) {
            return nums[0]; // directly return the only element
        }

        int start = 0;
        int end;

        double sum = 0;
        double result = Double.NEGATIVE_INFINITY;

        for (end = 0; end < n; end++) {

            sum = sum + nums[end];

            if (end - start + 1 > k) {
                sum = sum - nums[start];
                start++;
            }

            if (end - start + 1 == k) { // Only calculate when window size == k
                result = Math.max(result, sum / k);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));

    }
}
