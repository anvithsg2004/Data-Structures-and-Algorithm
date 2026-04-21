package neetcode150._1_Arrays_Hashing;

import java.util.*;

public class _1_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            if (hashSet.contains(nums[i])) {
                return true;
            }

            hashSet.add(nums[i]);

        }

        return false;

    }
}
