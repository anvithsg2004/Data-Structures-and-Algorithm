package DSA.Array.SubArray;

import java.util.HashMap;
import java.util.Map;

public class _1_Longest_subarray_with_given_sum_K_positives {
    public static int getLongestSubarray(int[] a, long k) {

        //Learn this which will be a benefit for both positive and negative integer array.

        int n = a.length;

        //This will store the prefix sum of all the elements of the array.
        Map<Long, Integer> preSumMap = new HashMap<>();

        //To calculate the sum of the array elements.
        long sum = 0;
        //Longest sum subarray.
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till current element.
            sum = sum + a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e., x-k:
            long rem = sum - k;

            //Check if the remaining wanted sum is there in the prefix map or not.
            //If it is there, then take the length of the prefix sum.
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                //Update in the 'maxLen'.
                maxLen = Math.max(maxLen, len);
            }

            //Put the sum in the map with the current index.
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        //Return the 'maxLen'
        return maxLen;

    }
}
