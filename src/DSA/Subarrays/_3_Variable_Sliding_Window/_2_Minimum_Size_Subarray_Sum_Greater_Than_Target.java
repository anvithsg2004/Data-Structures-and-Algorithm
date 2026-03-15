package DSA.Subarrays._3_Variable_Sliding_Window;

// Find the smallest subarray whose sum ≥ target.
public class _2_Minimum_Size_Subarray_Sum_Greater_Than_Target {

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum = sum + nums[right];

            while (sum >= target) {

                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left];
                left++;

            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
