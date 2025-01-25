package DSA.Recursion.Subsequences;

import java.util.List;

public class _3_sum_equal_to_K {

    public void printSubsequences(int[] arr, int index, List<Integer> current, int sum, int targetSum) {
        if (index == arr.length) {
            if (sum == targetSum) {
                System.out.println(current);
            }
            return;
        }

        // Recursive case: two choices for every element

        // Include the current element in the subsequence
        current.add(arr[index]);
        sum = sum + arr[index]; // Add the current element to the sum
        printSubsequences(arr, index + 1, current, sum, targetSum);

        // Backtrack to exclude the current element
        current.remove(arr[index]);
        sum = sum - arr[index]; // Subtract the current element from the sum
        printSubsequences(arr, index + 1, current, sum, targetSum);

    }

    public static void main(String[] args) {

    }
}
