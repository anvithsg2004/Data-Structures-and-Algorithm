package DSA.Practice.Arrays.Medium;

public class _14_Maximum_Absolute_Sum_of_Any_Subarray {

    //Brute Force Solution
    public static int maxAbsoluteSum(int[] nums) {

        int n = nums.length;

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                maxi = Math.max(maxi, Math.abs(sum));
            }
        }

        return maxi;

    }

    //Optimal Solution
    public static int maxAbsoluteSum2(int[] nums) {

        int n = nums.length;

        int[][] memoization = new int[n][n];

        int maxi = Integer.MIN_VALUE;

        return maxi;

    }

}
