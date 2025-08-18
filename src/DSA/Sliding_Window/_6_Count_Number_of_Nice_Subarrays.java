package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _6_Count_Number_of_Nice_Subarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Step 1: transform nums into 0/1 based on odd/even
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }

        // Step 2: apply subarray sum = k template
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            int rem = currentSum - k;
            count += map.getOrDefault(rem, 0);

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
