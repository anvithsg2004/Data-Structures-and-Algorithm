package DSA.Recursion.Pattern._3_Permutation;

import java.util.*;

public class _2_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        boolean[] used = new boolean[n];

        List<List<Integer>> result = new ArrayList<>();

        helper(nums, used, result, new ArrayList<>());

        return result;

    }

    public void helper(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> temp) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }

            // Choose
            used[i] = true;
            temp.add(nums[i]);

            // Explore
            helper(nums, used, result, temp);

            // Undo
            used[i] = false;
            temp.remove(temp.size() - 1);

        }

    }
}
