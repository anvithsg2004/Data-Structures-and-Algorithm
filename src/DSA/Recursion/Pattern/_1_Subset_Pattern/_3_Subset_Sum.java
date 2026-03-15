package DSA.Recursion.Pattern._1_Subset_Pattern;

public class _3_Subset_Sum {

    public static Boolean isSubsetSum(int[] arr, int sum) {

        int n = arr.length;

        return help(0, 0, arr, sum);

    }

    public static boolean help(int sum, int index, int[] nums, int target) {

        if (sum == target) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        // Pick
        boolean pick = help(sum + nums[index], index + 1, nums, target);

        // Not Pick
        boolean notPick = help(sum, index + 1, nums, target);

        return pick || notPick;
    }

}
