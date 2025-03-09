package DSA.Dynamic_Programming._7_DP_On_LIS;

import java.util.Arrays;

public class _6_Longest_Bitonic_Subsequence {
    public static int LongestBitonicSequence(int n, int[] nums) {

        //We need to find the Longest Bitonic Subsequence (LBS) in an array.
        //A bitonic subsequence is a sequence that:
        //1) First increases
        //2) Then decreases

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        //This is for the DP1 Array
        //Here is the simple trick and a twist.
        //nums[i] > nums[previousIndex]
        for (int i = 0; i < n; i++) {
            for (int previousIndex = 0; previousIndex < i; previousIndex++) {
                if (nums[i] > nums[previousIndex]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[previousIndex]);
                }
            }
        }

        //Now reverse it and do the same.
        //Here just the reverse of that.
        //nums[i] < nums[previousIndex]
        for (int i = n - 1; i >= 0; i--) {
            for (int previousIndex = n - 1; previousIndex > i; previousIndex--) {
                if (nums[previousIndex] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[previousIndex]);
                }
            }
        }

        int maxi = -1;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;

    }
}
