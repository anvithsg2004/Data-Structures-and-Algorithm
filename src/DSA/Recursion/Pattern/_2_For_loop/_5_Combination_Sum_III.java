package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _5_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> result = new ArrayList<>();

        helper(0, k, n, nums, result, new ArrayList<>());

        return result;

    }

    public void helper(int start, int k, int sum, int[] nums, List<List<Integer>> result, List<Integer> current) {

        if (k == 0) {
            if (sum == 0) {
                result.add(new ArrayList<>(current));
            }
        }

        if (start >= nums.length) {
            return;
        }

        for (int index = start; index < nums.length; index++) {

            if (nums[index] > sum) {
                continue;
            }

            // Choose
            current.add(nums[index]);

            // Explore
            helper(index + 1, k - 1, sum - nums[index], nums, result, current);

            // Undo
            current.remove(current.size() - 1);

        }

    }
}
