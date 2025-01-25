package DSA.Recursion.Subsequences;

import java.util.List;

public class _4_sum_equal_to_K {

    public boolean printSubsequence(int[] arr, int index, List<Integer> current, int sum, int targetSum) {
        if (index == arr.length) {
            if (sum == targetSum) {
                System.out.println(current);
                return true; // Indicate that a valid subsequence is found
            }
            return false;
        }

        // Include the current element
        current.add(arr[index]);
        sum = sum + arr[index];
        if (printSubsequence(arr, index + 1, current, sum, targetSum)) {
            return true; // Stop recursion if a valid subsequence is found
        }

        // Backtrack: exclude the current element
        current.remove(arr[index]);
        sum = sum - arr[index];
        if (printSubsequence(arr, index + 1, current, sum, targetSum)) {
            return true; // Stop recursion if a valid subsequence is found
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
