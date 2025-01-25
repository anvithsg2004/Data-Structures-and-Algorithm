package DSA.Recursion.Subsequences;

public class _5_count_equal_to_sum_k {

    public int countSubsequences(int[] arr, int index, int sum, int targetSum) {

        // Base case: if the current index is at the end of the array
        if (index == arr.length) {
            // Return 1 if the sum equals the target, else 0
            if (sum == targetSum) {
                return 1;
            } else {
                return 0;
            }
        }

        // Recursive case: two choices for every element
        // Include the current element
        sum = sum + arr[index];
        int include = countSubsequences(arr, index, sum, targetSum);

        // Exclude the current element
        sum = sum - arr[index];
        int exclude = countSubsequences(arr, index, sum, targetSum);

        // Return the total count
        return include + exclude;

    }

    public static void main(String[] args) {

    }
}
