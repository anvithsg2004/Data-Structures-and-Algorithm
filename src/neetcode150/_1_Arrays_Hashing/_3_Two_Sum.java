package neetcode150._1_Arrays_Hashing;

import java.util.*;

public class _3_Two_Sum {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int remaining = target - nums[i];

            if (hashMap.containsKey(remaining)) {
                return new int[]{hashMap.get(remaining), i};
            }

            hashMap.put(nums[i], i);

        }

        return new int[]{-1, -1};

    }
}
