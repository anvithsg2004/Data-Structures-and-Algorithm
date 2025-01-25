package DSA.Bit_Manipulation;

//2^n is equals to left shift of 1 of the number given.
//2^n == (1 << n)

import java.util.ArrayList;
import java.util.List;

public class _11_Power_Set {
    public static List<List<Integer>> generatePowerSet(int[] nums) {

        List<List<Integer>> allSubset = new ArrayList<>();

        int n = nums.length;

        int totalNumberOfSet = (1 << n); // 2^n subsets

        for (int i = 0; i < totalNumberOfSet; i++) {

            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Check if the j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }

            }

            allSubset.add(subset);

        }

        return allSubset;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(generatePowerSet(arr));
    }
}
