package DSA.Recursion.Combination_Sum;

import java.util.List;

public class Combination_Sum_1 {

    public void findCombinations(int[] arr, int index, int targetSum, List<Integer> current, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(current);
            return;
        }

        if (targetSum < 0 || index == arr.length) {
            return;
        }

        // Include the current element (can be reused)
        current.add(arr[index]);
        //Try with the same index.
        //Because of this example
        //Input: candidates = [2,3,5], target = 8
        //Output: [[2,2,2,2],[2,3,3],[3,5]]

        //Example 2 :
        //Input: candidates = [2,3,6,7], target = 7
        //Output: [[2,2,3],[7]]
        //Explanation:
        //2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        //7 is a candidate, and 7 = 7.
        //These are the only two combinations.
        findCombinations(arr, index, targetSum - arr[index], current, result);

        // Exclude the current element (move to the next element)
        current.remove(current.size() - 1);
        findCombinations(arr, index + 1, targetSum, current, result);
    }

    public static void main(String[] args) {

    }
}
