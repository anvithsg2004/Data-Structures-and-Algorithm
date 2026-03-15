package DSA.Recursion.Pattern._1_Subset_Pattern;

public class _4_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return helper(0, 0, nums, sum / 2);

    }

    public boolean helper(int sum, int index, int[] nums, int target) {

        if (sum == target) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        boolean pick = helper(sum + nums[index], index + 1, nums, target);

        boolean notPick = helper(sum, index + 1, nums, target);

        return pick || notPick;

    }
}
