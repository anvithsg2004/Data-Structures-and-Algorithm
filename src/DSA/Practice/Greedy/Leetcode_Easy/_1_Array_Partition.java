package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _1_Array_Partition {
    public int arrayPairSum(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }

        return sum;

    }
}
