package DSA.Recursion.Pattern._1_Subset_Pattern;

import java.util.*;

public class _2_Print_all_subsequences {
    public static void printSubsequences(int index, int[] nums, ArrayList<Integer> current) {

        if (index == nums.length) {
            System.out.println(current);
            return;
        }

        // Pick
        current.add(nums[index]);
        printSubsequences(index + 1, nums, current);

        // Not Pick
        current.remove(current.size() - 1);
        printSubsequences(index + 1, nums, current);

    }
}
