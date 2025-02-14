package DSA.Dynamic_Programming._4_Subsequences;

public class _2_Partition_Equal_Subset_Sum {

    //Given an integer array nums, return true if you can partition the array into
    //two subsets such that the sum of the elements in both subsets is equal or false otherwise.

    //Recursion
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum = totalSum + num;
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        int target = totalSum / 2;

        return helper(n - 1, target, nums);
    }

    public boolean helper(int index, int target, int[] arr) {

        if (index == 0) {
            return arr[index] == target;
        }

        if (target == 0) {
            return true;
        }

        boolean notTaken = helper(index - 1, target, arr);

        boolean taken = false;

        if (arr[index] <= target) {
            taken = helper(index - 1, target - arr[index], arr);
        }

        return taken || notTaken;

    }

    //Memoization
    public boolean canPartition2(int[] nums) {

        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum = totalSum + num;
        }

        if (totalSum % 2 == 1) {
            return false;
        }

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return helper2(n - 1, target, nums, dp);
    }

    public static boolean helper2(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean notTaken = helper2(index - 1, target, arr, dp);

        boolean taken = false;

        if (arr[index] <= target) {
            taken = helper2(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = taken || notTaken;
    }
}
