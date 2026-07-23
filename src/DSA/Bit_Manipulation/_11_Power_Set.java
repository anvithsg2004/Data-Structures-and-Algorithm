package DSA.Bit_Manipulation;

//2^n is equals to left shift of 1 of the number given.
//2^n == (1 << n)

import java.util.*;

public class _11_Power_Set {
    public static List<List<Integer>> generatePowerSet(int[] nums) {

        //Intuition = The code creates all possible subsets of an array by using binary numbers,
        // where each bit decides whether to include an element or not.

        List<List<Integer>> allSubset = new ArrayList<>();

        int n = nums.length;

        int totalNumberOfSet = (1 << n); // 2^n subsets

        for (int num = 0; num < totalNumberOfSet; num++) {
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                if ((num & (1 << i)) != 0) {
                    currList.add(nums[i]);
                }
            }
            allSubset.add(currList);
        }

        return allSubset;

    }
}
