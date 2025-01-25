package DSA.Recursion.Kunal_Kushwaha.Subset_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class _4_Return_SubSets {

    public static ArrayList<int[]> arraySub(int[] processed, int[] unProcessed) {

        if (unProcessed.length == 0) {
            ArrayList<int[]> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        // First element of the unProcessed array
        int ch = unProcessed[0];

        // Remaining elements of the unProcessed array
        int[] remaining = Arrays.copyOfRange(unProcessed, 1, unProcessed.length);

        // Do not take the current element
        ArrayList<int[]> left = arraySub(processed, remaining);

        // Take the current element
        int[] newProcessed = Arrays.copyOf(processed, processed.length + 1);
        newProcessed[newProcessed.length - 1] = ch;
        ArrayList<int[]> right = arraySub(newProcessed, remaining);

        // Combine results
        left.addAll(right);

        return left;

    }

    public static void main(String[] args) {

    }
}
