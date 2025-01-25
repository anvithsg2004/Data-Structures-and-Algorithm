package DSA.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Minimum_Increment_to_Make_Array_Unique {


    //Leetcode Optimized
    public int minIncrementForUniqueOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0, prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                count += prev - nums[i] + 1;
                prev++;
            } else {
                prev = nums[i];
            }
        }

        return count;
    }

    public int minIncrementForUnique(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Integer[] integerArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integerArray[i] = nums[i]; // Autoboxing
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Collections.addAll(arrayList, integerArray);

        Collections.sort(arrayList);
        int count = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    arrayList.set(j, arrayList.get(j) + 1);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}


