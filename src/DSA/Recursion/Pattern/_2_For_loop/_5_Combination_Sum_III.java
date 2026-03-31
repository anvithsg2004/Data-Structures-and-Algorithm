package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _5_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int target) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, k, target, numbers, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int startIndex, int remainingCount, int remainingSum,
                           int[] numbers, List<Integer> currentCombination,
                           List<List<Integer>> result) {

        // Valid combination
        if (remainingCount == 0 && remainingSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Invalid case
        if (remainingCount == 0 || remainingSum < 0) {
            return;
        }

        for (int i = startIndex; i < numbers.length; i++) {

            // Optimization (since numbers are sorted)
            if (numbers[i] > remainingSum) {
                break;
            }

            // Choose
            currentCombination.add(numbers[i]);

            // Explore
            backtrack(i + 1, remainingCount - 1, remainingSum - numbers[i],
                    numbers, currentCombination, result);

            // Undo
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
