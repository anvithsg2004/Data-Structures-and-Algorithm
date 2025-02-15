package DSA.Dynamic_Programming._7_DP_On_LIS;

//This is a Tabulation algorithm to find the length of the longest increasing subsequence.

import java.util.Arrays;

public class _2_Find_the_length_of_the_longest_increasing_subsequence {

    public int helper(int[] arr) {

        int n = arr.length;

        int[] dp = new int[n];

        //Here in the DP we will fill 1 as the initial length as 1
        // because, as in the array, every element is smaller to the next then the length is 1.
        Arrays.fill(dp, 1);

        //In the first loop, this will stand ahead of the previous index.
        //The previous index will start from starting after every loop.
        for (int i = 0; i <= n - 1; i++) {
            for (int previousIndex = 0; previousIndex <= i - 1; previousIndex++) {
                if (arr[previousIndex] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[previousIndex]);
                }
            }
        }

        int ans = -1;

        for (int i = 0; i <= n - 1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;

    }

}
