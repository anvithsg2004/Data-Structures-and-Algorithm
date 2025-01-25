package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _13_Make_Array_Zero_by_Subtracting_Equal_Amounts {
    public static int minimumOperations(int[] nums) {

        int n = nums.length;

        int countNonZero = 0;

        for (int num : nums) {

            if (num != 0) {
                countNonZero++;
            }

        }

        if (countNonZero == 0) {
            return 0;
        }

        int left = 0;

        int count = 0;

        while (left < n) {

            if (nums[left] == 0) {
                left++;
                continue;
            } else {
                count++;
                int sub = nums[left];

                for (int i = left; i < n; i++) {
                    if (nums[i] != 0) {
                        nums[i] = nums[i] - sub;
                    }
                }
            }

            left++;
        }

        System.out.println(Arrays.toString(nums));

        return count;

    }
}
