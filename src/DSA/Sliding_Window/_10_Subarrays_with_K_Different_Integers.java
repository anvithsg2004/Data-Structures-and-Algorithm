package DSA.Sliding_Window;

import java.util.HashMap;

public class _10_Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (right = 0; right < n; right++) {
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(nums[left], mpp.get(nums[left] - 1));

                if (mpp.get(nums[left]) == 0) {
                    mpp.remove(nums[left]);
                }

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
