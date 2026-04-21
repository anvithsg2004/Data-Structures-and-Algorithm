package DSA.Sliding_Window;

import java.util.*;

public class _14_prefix_sum_hashmap {
    public int longestSubarrayWithSumK(int[] arr, int k) {

        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            prefixSum = prefixSum + arr[i];

            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            map.putIfAbsent(prefixSum, i);

        }

        return maxLen;

    }
}
