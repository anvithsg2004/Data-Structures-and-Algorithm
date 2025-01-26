package LeetCode_Contest_Questions;

import java.util.Arrays;

public class _4_Count_Partitions_with_Even_Sum_Difference {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int prefixSum = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum = prefixSum + nums[i];
            prefix[i] = prefixSum;
        }
        System.out.println(Arrays.toString(prefix));

        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum = suffixSum + nums[i];
            suffix[i] = suffixSum;
        }
        System.out.println(Arrays.toString(suffix));

        int noOfEven = 0;

        for (int i = 0; i < n - 1; i++) {
            int difference = prefix[i] - suffix[i + 1];
            if (difference % 2 == 0) {
                noOfEven++;
            }
        }

        return noOfEven;
    }
}
