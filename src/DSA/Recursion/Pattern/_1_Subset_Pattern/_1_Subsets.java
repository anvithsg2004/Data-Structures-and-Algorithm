package DSA.Recursion.Pattern._1_Subset_Pattern;

import java.util.*;

public class _1_Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        Set<List<Integer>> result = new HashSet<>();

        helper(0, nums, result, new ArrayList<>());

        return new ArrayList<>(result);

    }

    public void helper(int index, int[] nums, Set<List<Integer>> result, List<Integer> current) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pick
        current.add(nums[index]);
        helper(index + 1, nums, result, current);

        // Not Pick
        current.remove(current.size() - 1);
        helper(index + 1, nums, result, current);

    }

}
