package DSA.Array.SubArray;

import java.util.HashMap;
import java.util.Map;

public class _3_Largest_Subarray_with_Zero_Sum {

    public int maxLen(int[] a) {

        int n = a.length;

        Map<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e., x-k:
            long rem = sum - 0;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {

    }
}
