package DSA.Recursion.Subsequences;

import java.util.List;

public class _1_SubSequence_Array {

    public void printSubsequences(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Recursive case: two choices for every element

        // Include the current element in the subsequence
        current.add(arr[index]);
        printSubsequences(arr, index + 1, current);

        // Backtrack to exclude the current element
        current.remove(current.size() - 1);
        printSubsequences(arr, index + 1, current);
    }

    public static void main(String[] args) {

    }
}
