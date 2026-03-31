package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _4_Combination_Sum_II {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates); // Important for duplicate handling

        backtrack(0, 0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    public static void backtrack(int startIndex, int currentSum, int[] candidates, int target,
                                 List<Integer> currentCombination, List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(currentCombination));
            return; // Stop further exploration
        }

        if (currentSum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            // Skip duplicates
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose
            currentCombination.add(candidates[i]);

            // Explore (move to next index → no reuse)
            backtrack(i + 1, currentSum + candidates[i], candidates, target, currentCombination, result);

            // Undo
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
