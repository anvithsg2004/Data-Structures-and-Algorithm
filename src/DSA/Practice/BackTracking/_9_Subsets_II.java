package DSA.Practice.BackTracking;

import java.util.*;

public class _9_Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), answer);

        return answer;

    }

    public void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> allCombinations) {
        allCombinations.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            helper(nums, i + 1, current, allCombinations);
            current.remove(current.size() - 1); // Backtrack
        }
    }

}
