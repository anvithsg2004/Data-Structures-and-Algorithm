package DSA.Subarrays._4_Prefix_Sum;

public class _2_Pivot_Index {
    public static int pivotIndex(int[] nums) {

        int n = nums.length;

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + nums[i];
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum = leftSum + nums[i];

        }

        return -1;

    }
}
