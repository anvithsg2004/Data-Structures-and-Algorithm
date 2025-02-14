package DSA.Binary_Search;

public class _11_Find_out_how_many_times_the_array_has_been_rotated {

    public int findKRotation(int[] nums, int n) {
        // code here
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        //Here this the like the same and similar previous problem.

        //There we take the minimum of the low or the mid.

        //Here we take the index of the low and mid and return it.

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                if (nums[low] < ans) {
                    ans = nums[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (nums[mid] < ans) {
                    index = mid;
                    ans = nums[mid];
                }
                high = mid - 1;
            }
        }

        return index;
    }
}
