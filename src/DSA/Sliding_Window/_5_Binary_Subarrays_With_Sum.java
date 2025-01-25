package DSA.Sliding_Window;

public class _5_Binary_Subarrays_With_Sum {

    //It is nothing but count the subarray sum equals k

    public int numSubarraysWithSum(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k - 1);
    }

    public int fun(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum = sum + nums[r];

            while (sum > k) {
                sum = sum - nums[l];
                l = l + 1;
            }

            count = count + (r - l + 1);
            r = r + 1;
        }

        return count;
    }
}
