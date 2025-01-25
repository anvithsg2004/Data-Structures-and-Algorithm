package DSA.Sliding_Window;

public class _6_Count_Number_of_Nice_Subarrays {

    //It is the same as the before problem like just do the modulo with 2 and store it in an array.
    //Do the same as the before code.

    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k - 1);
    }

    public int fun(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r <= nums.length) {
            sum = sum + (nums[r] % 2);

            while (sum > k) {
                sum = sum - (nums[l] % 2);
                l = l + 1;
            }

            count = count + (r - l + 1);
            r = r + 1;
        }

        return count;
    }
}
