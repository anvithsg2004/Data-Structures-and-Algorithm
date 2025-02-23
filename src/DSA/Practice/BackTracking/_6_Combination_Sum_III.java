package DSA.Practice.BackTracking;

import java.util.*;

public class _6_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> allCombinations = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target, allCombinations, k);
        return allCombinations;

    }

    public void helper(int[] candidates, int start, List<Integer> current, int target, List<List<Integer>> allCombinations, int k) {
        if (target == 0) {
            if (current.size() == k) {
                allCombinations.add(new ArrayList<>(current));
                return;
            } else {
                return;
            }
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
            helper(candidates, i + 1, current, target - candidates[i], allCombinations, k);
            current.remove(current.size() - 1); // Backtrack
        }
    }

}
