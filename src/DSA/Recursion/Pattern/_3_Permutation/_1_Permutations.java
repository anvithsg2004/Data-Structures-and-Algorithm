package DSA.Recursion.Pattern._3_Permutation;

import java.util.ArrayList;
import java.util.List;

public class _1_Permutations {
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[n];

        helper(nums, used, result, new ArrayList<>());

        return result;

    }

    public void helper(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> temp) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already Used
            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            temp.add(nums[i]);

            // Explore
            helper(nums, used, result, temp);

            // Undo
            temp.remove(temp.size() - 1);
            used[i] = false;

        }

    }
}
