package DSA.Practice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates
        List<List<Integer>> allCombinations = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target, allCombinations);
        return allCombinations;
    }

    public void helper(int[] candidates, int start, List<Integer> current, int target, List<List<Integer>> allCombinations) {
        if (target == 0) {
            allCombinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // If current candidate exceeds the remaining target, break as array is sorted
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            helper(candidates, i + 1, current, target - candidates[i], allCombinations);
            current.remove(current.size() - 1); // Backtrack
        }
    }

}
