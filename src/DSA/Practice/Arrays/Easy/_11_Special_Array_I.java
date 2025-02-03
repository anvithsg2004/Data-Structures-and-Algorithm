package DSA.Practice.Arrays.Easy;

public class _11_Special_Array_I {
    public boolean isArraySpecial(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return true;
        }

        int currentIndex = nums[0] % 2;

        return helper(nums, n - 1, 1, currentIndex);

    }

    public boolean helper(int[] arr, int n, int index, int previousIndex) {

        int currentIndex = arr[index] % 2;

        if (index == n) {
            if (previousIndex == currentIndex) {
                return false;
            } else {
                return true;
            }
        }

        if (previousIndex == currentIndex) {
            return false;
        }

        return helper(arr, n, index + 1, currentIndex);

    }
}
