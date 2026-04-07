package DSA.Sliding_Window;

import java.util.*;

public class _10_Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0, j = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < nums.length) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            count += (j - i + 1);   // ⭐ core logic

            j++;
        }

        return count;
    }
}
