package DSA.Dynamic_Programming._4_Subsequences;

import java.util.Arrays;

public class _4_Count_Subsets_with_Sum_K {
    //Here There is a twist:=
    //This is for numbers starting from 0.
    public int helper3(int index, int target, int[] arr) {

        if (index == 0) {
            //Here it returns 2 because we can take zero or
            //not take zero.
            if (target == 0 && arr[0] == 0) {
                return 2;
            }

            if (target == 0 || arr[0] == target) {
                return 1;
            }
        }

        if (target == 0) {
            return 1;
        }

        int notPick = helper3(index - 1, target, arr);

        int pick = 0;

        if (arr[index] <= target) {
            pick = helper3(index - 1, target - arr[index], arr);
        }

        return pick + notPick;

    }

    //This is for numbers starting from 1.
    //Recursion
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        return helper(n - 1, target, nums);
    }

    public int helper(int index, int target, int[] arr) {
        // Base Case 1: If target is achieved
        if (target == 0)
            return 1;

        // Base Case 2: If no elements left
        if (index == 0)
            return arr[0] == target ? 1 : 0;

        // Exclude the current element and move to the next
        int notTaken = helper(index - 1, target, arr);

        // Include the current element if it's not greater than the target
        int taken = 0;
        if (arr[index] <= target)
            taken = helper(index - 1, target - arr[index], arr);

        // Total ways by excluding and including the current element
        return notTaken + taken;
    }

    //Memoization
    public int perfectSum2(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper2(n - 1, target, nums, dp);
    }

    public int helper2(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            return arr[index] == target ? 1 : 0;
        }

        if (target == 0) {
            return 1;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTaken = helper2(index - 1, target, arr, dp);

        int taken = 0;

        if (arr[index] <= target) {
            taken = helper2(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = taken + notTaken;
    }
}
