package DSA.Subarrays._3_Variable_Sliding_Window;

import java.util.*;

public class _4_Longest_Subarray_With_At_Most_K_Distinct_Numbers {
    public static int longestSubarray(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);

                left++;

            }

            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;

    }
}
