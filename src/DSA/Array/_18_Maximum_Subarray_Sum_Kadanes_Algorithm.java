package DSA.Array;

public class _18_Maximum_Subarray_Sum_Kadanes_Algorithm {

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxi = nums[0];

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            //Choose the best subArray sum.
            maxi = Math.max(sum, maxi);

            //If the sum is lesser than zero, it is of no use.
            if (sum < 0) {
                sum = 0;
            }

        }

        return maxi;

    }

    public static void main(String[] args) {

    }
}
