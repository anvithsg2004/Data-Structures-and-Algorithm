package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _3_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, 0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int startIndex, int currentSum, int[] candidates, int target,
                           List<Integer> currentCombination, List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(currentCombination));
            return; // Important to stop further exploration
        }

        if (currentSum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            // Choose
            currentCombination.add(candidates[i]);

            // Explore (same index because repetition is allowed)
            backtrack(i, currentSum + candidates[i], candidates, target, currentCombination, result);

            // Undo (backtrack)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
