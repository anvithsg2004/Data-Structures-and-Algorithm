package Top_150;

//💬 Problem Summary:
//Given an array nums and integer k, return true if two equal elements exist such that the distance between their indices ≤ k.

//🧠 Idea:
//We want to check if the same number repeats within k indices.
//✅ Approach: HashMap (Value → Index)
//Store the last seen index of each number.
//If we see a duplicate, check the difference in indices.

import java.util.HashMap;
import java.util.Map;

public class _19_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);  // Update latest index
        }
        return false;
    }
}
