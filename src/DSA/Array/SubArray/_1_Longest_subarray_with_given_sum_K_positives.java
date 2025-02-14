package DSA.Array.SubArray;

import java.util.HashMap;
import java.util.Map;

public class _1_Longest_subarray_with_given_sum_K_positives {

    //Optimal Solution
    //Only Positive.
    public static int getLongestSubarray2(int[] a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from a left
            // until a sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if a sum = k, update the maxLen i.e., answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward the right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    //Better Solution for both Positive and Negative
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
            sum += a[i];

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

    //Better Solution
    public int lenOfLongestSubarr(int[] a, int k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            long s = 0; // Sum variable
            for (int j = i; j < n; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                s += a[j];

                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
