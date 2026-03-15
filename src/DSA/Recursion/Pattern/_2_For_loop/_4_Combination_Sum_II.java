package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _4_Combination_Sum_II {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        helper(0, 0, result, new ArrayList<>(), candidates, target);

        return result;

    }

    public static void helper(int start, int sum, List<List<Integer>> result, List<Integer> current, int[] candidates, int target) {

        if (target == sum) {
            result.add(new ArrayList<>(current));
        }

        if (sum > target) {
            return;
        }

        if (start >= candidates.length) {
            return;
        }

        for (int index = start; index < candidates.length; index++) {

            // Choose
            current.add(candidates[index]);

            // Explore
            helper(index + 1, sum + candidates[index], result, current, candidates, target);

            // Undo
            current.remove(current.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 7;
        combinationSum2(candidates, target);

    }

}
