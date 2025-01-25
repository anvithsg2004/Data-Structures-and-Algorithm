package DSA.Dynamic_Programming._4_Subsequences;

public class _1_Subset_sum_equal_to_target {

    //Recursion
    public static Boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        return helper(n - 1, target, arr);
    }

    public static boolean helper(int index, int target, int[] arr) {

        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        boolean notTaken = helper(index - 1, target, arr);

        boolean taken = false;

        if (arr[index] <= target) {
            taken = helper(index - 1, target - arr[index], arr);
        }

        return taken || notTaken;
    }

    //Memoization
    public static Boolean isSubsetSum2(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return helper2(n - 1, target, arr, dp);
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
