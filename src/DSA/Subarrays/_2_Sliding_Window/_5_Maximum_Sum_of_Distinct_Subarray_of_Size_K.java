package DSA.Subarrays._2_Sliding_Window;

import java.util.HashSet;

public class _5_Maximum_Sum_of_Distinct_Subarray_of_Size_K {
    public static int maxDistinctSum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {

            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            if (right - left + 1 == k) {

                maxSum = Math.max(maxSum, sum);

                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
