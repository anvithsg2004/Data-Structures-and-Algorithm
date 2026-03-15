package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _3_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        helper(0, 0, result, new ArrayList<>(), candidates, target);

        return result;

    }

    public void helper(int start, int sum, List<List<Integer>> result, List<Integer> current, int[] candidates, int target) {

        if (target == sum) {
            result.add(new ArrayList<>(current));
        }

        if (sum > target) {
            return;
        }

        if (start == candidates.length) {
            return;
        }

        for (int index = start; index < candidates.length; index++) {

            // Choose
            current.add(candidates[index]);

            // Explore
            helper(index, sum + candidates[index], result, current, candidates, target);

            // Undo
            current.remove(current.size() - 1);

        }

    }

}
