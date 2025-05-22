package DSA.Dynamic_Programming._7_DP_On_LIS;

import java.util.Arrays;

public class _1_Longest_Increasing_Subsequence {

    //Recursion
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return helper(nums, n, 0, -1);
    }

    public int helper(int[] arr, int n, int index, int prevIndex) {

        if (index == n) {
            return 0;
        }

        int notTake = helper(arr, n, index + 1, prevIndex);

        int take = 0;

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + helper(arr, n, index + 1, index);
        }

        return Math.max(take, notTake);

    }


    //Memoization
    public int lengthOfLIS2(int[] nums) {

        int n = nums.length;

        //This is because the total size of the array is n - 1.
        //For the previous index is n + 1 because it starts from -1 to n - 1.
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper2(nums, n, 0, -1, dp);

    }

    public int helper2(int[] arr, int n, int index, int prevIndex, int[][] dp) {

        if (index == n) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notTake = helper2(arr, n, index + 1, prevIndex, dp);

        int take = 0;

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + helper2(arr, n, index + 1, index, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(notTake, take);

    }


    //Tabulation
    public static int lengthOfLIS3(int[] nums) {
        int n = nums.length;

        //At index i, we have two choices:
        //1. Not Take arr[i] → move to i+1, prevIndex stays same
        //2. Take arr[i] if possible → move to i+1, and update prevIndex = i
        int[][] dp = new int[n + 1][n + 1];

        //dp[index][prev_index + 1] stores the answer to "what is the maximum subsequence length
        //if we are at index and previous selected index is prev_index".

        for (int index = n - 1; index >= 0; index--) {
            for (int prev_index = index - 1; prev_index >= -1; prev_index--) {
                int notTake = dp[index + 1][prev_index + 1];
                int take = 0;
                if (prev_index == -1 || nums[index] > nums[prev_index]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][prev_index + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS3(nums));
    }
}
