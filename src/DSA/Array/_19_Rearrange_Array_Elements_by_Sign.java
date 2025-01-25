package DSA.Array;

import java.util.ArrayList;

public class _19_Rearrange_Array_Elements_by_Sign {

    //Optimal Solution
    public int[] rearrangeArray2(int[] nums) {

        int n = nums.length;
        int positive = 0;
        int negative = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            if (nums[i] >= 0) {

                result[positive] = nums[i];

                positive = positive + 2;

            }

            if (nums[i] < 0) {

                result[negative] = nums[i];

                negative = negative + 2;

            }

        }

        return result;

    }

    //Better Solution
    public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        //First, Separate the numbers into positive and negative
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= 0) {
                pos.add(nums[i]);
            }

            if (nums[i] < 0) {
                neg.add(nums[i]);
            }

        }

        int[] result = new int[nums.length];

        //Divide the given array length into half and pass it to the result array
        for (int i = 0; i < nums.length / 2; i++) {

            result[2 * i] = pos.get(i);
            result[(2 * i) + 1] = neg.get(i);

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
