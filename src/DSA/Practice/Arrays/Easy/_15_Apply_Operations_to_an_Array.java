package DSA.Practice.Arrays.Easy;

import java.util.Arrays;

public class _15_Apply_Operations_to_an_Array {
    public static int[] applyOperations(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));

        int index = 0; // Pointer to place the next non-zero element

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index = index + 1;
            }
        }

        System.out.println(Arrays.toString(nums));

        // Second pass: Fill the remaining positions with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index = index + 1;
        }

        System.out.println(Arrays.toString(nums));

        return nums;

    }

    public static void main(String[] args) {

    }

}
