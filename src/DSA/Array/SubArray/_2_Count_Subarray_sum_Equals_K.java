package DSA.Array.SubArray;

import java.util.HashMap;
import java.util.Map;

public class _2_Count_Subarray_sum_Equals_K {

    public int subarraySum(int[] a, int k) {
        int n = a.length;

        Map<Integer, Integer> preSumMap = new HashMap<>();

        int count = 0;
        int sum = 0;

        // Initialize preSumMap with sum 0 having one occurrence
        preSumMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            // Calculate the prefix sum till index i
            sum += a[i];

            // Check if there exists a prefix sum that we can subtract to get sum k
            int rem = sum - k;

            // If rem exists in preSumMap, it means there's a subarray that sums to k
            count += preSumMap.getOrDefault(rem, 0);

            // Update the prefix sum count in the map
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
