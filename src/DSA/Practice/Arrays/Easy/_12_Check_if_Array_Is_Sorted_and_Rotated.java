package DSA.Practice.Arrays.Easy;

public class _12_Check_if_Array_Is_Sorted_and_Rotated {
    public boolean check(int[] nums) {
        int k = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                k++;
            }
        }

        // Check wrap-around case
        //Since the array is rotated, the last number should be smaller than the first number.
        if (nums[n - 1] > nums[0]) {
            k++;
        }

        return k <= 1;
    }
}
