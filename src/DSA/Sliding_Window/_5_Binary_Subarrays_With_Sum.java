package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _5_Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currentSum = 0;

        int count = 0;

        for (int i = 0; i < n; i++) {

            currentSum = currentSum + nums[i];

            int rem = currentSum - goal;

            count = count + map.getOrDefault(rem, 0);

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        }

        return count;

    }
}
