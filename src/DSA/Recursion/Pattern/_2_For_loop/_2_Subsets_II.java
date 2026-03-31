package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _2_Subsets_II {

    public List<List<Integer>> getSubsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Important for handling duplicates

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int startIndex, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {

        result.add(new ArrayList<>(currentSubset));

        for (int i = startIndex; i < nums.length; i++) {

            // Skip duplicates
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            currentSubset.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, currentSubset, result);

            // Undo (backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
