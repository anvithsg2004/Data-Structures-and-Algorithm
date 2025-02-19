package DSA.Practice.BackTracking;

import java.util.*;

public class _3_Combination_Sum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> allCombinations = new ArrayList<>();
        helper(allCombinations, new ArrayList<>(), 0, candidates, target, 0);

        return allCombinations;

    }

    public static void helper(List<List<Integer>> allCombinations, ArrayList<Integer> currentSum, int sum, int[] candidates, int target, int index) {

        if (index == candidates.length) {
            return;
        }

        if (target == sum) {
            allCombinations.add(new ArrayList<>(currentSum)); // ✅ Correct way to add a copy
            return;
        }

        //Pick
        if (sum + candidates[index] <= target) {
            currentSum.add(candidates[index]);
            helper(allCombinations, currentSum, sum + candidates[index], candidates, target, index);
            currentSum.remove(currentSum.size() - 1); // ✅ Backtrack
        }

        //Not Pick
        helper(allCombinations, currentSum, sum, candidates, target, index + 1);

    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        combinationSum(candidates, target);


    }

}
