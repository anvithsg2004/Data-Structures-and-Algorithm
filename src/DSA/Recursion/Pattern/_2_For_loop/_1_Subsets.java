package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _1_Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        helper(0, result, new ArrayList<>(), nums);

        return result;

    }

    public void helper(int index, List<List<Integer>> result, List<Integer> current, int[] nums) {

        result.add(new ArrayList<>(current));

        for (int start = index; start < nums.length; start++) {

            // Choose
            current.add(nums[start]);

            // Explore
            helper(start + 1, result, current, nums);

            // Undo
            current.remove(current.size() - 1);


        }

    }

}
