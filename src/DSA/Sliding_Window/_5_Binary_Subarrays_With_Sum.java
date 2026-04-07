package DSA.Sliding_Window;

public class _5_Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return help(nums, goal) - help(nums, goal - 1);
    }

    public int help(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int n = nums.length;

        int i = 0;
        int j = 0;

        int count = 0;

        int sum = 0;

        while (j < n) {

            sum = sum + nums[j];

            while (sum > goal) {
                sum = sum - nums[i];
                i++;
            }

            count = count + (j - i + 1);
            j++;

        }

        return count;

    }
}
