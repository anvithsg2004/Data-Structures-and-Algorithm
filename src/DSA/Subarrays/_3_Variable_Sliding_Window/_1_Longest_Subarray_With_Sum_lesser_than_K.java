package DSA.Subarrays._3_Variable_Sliding_Window;

public class _1_Longest_Subarray_With_Sum_lesser_than_K {
    public static int longestSubarray(int[] arr, int k) {

        int n = arr.length;

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            sum = sum + arr[right];

            while (sum > k) {
                sum = sum - arr[right];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}
