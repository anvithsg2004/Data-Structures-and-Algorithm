package DSA.Recursion.Kunal_Kushwaha.Subset_Subsequence;

import java.util.Arrays;

public class _3_Array_Subsets {

    public static void subArray(int[] processed, int[] unProcessed) {

        if (unProcessed.length == 0) {
            System.out.println(Arrays.toString(processed));
            return;
        }

        // First element of the unProcessed array
        int ch = unProcessed[0];

        // Remaining elements of the unProcessed array
        int[] remaining = Arrays.copyOfRange(unProcessed, 1, unProcessed.length);

        // Do not take the current element(Do not Pick)
        subArray(processed, remaining);

        // Take the current element(Pick)
        int[] newProcessed = Arrays.copyOf(processed, processed.length + 1);
        newProcessed[newProcessed.length - 1] = ch;
        subArray(newProcessed, remaining);

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        subArray(new int[0], array);
    }
}
