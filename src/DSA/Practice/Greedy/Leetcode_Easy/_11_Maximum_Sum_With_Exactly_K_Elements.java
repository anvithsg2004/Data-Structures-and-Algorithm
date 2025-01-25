package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _11_Maximum_Sum_With_Exactly_K_Elements {

    //My Solution
    public int maximizeSum(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;

        int sum = 0;

        int[] sumsToAdd = new int[k];

        sumsToAdd[0] = nums[n - 1];

        for (int i = 1; i < k; i++) {
            sumsToAdd[i] = sumsToAdd[i - 1] + 1;
        }

        for (int i = 0; i < k; i++) {
            sum = sum + sumsToAdd[i];
        }

        return sum;

    }

    //OG Solution
    public int maximizeSum2(int[] nums, int k) {

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int answer = 0;

        while (k > 0) {
            answer = answer + maxi;
            maxi = maxi + 1;
            k--;
        }

        return answer;

    }


}
