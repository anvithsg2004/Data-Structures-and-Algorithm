package DSA.Binary_Search;

public class _10_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;

        //7 8 9 1 2 3 4 5 6
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                //Pick the LOW in the sorted and put it in the ans.
                //Here we take the low because that may be the lowest.
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                //Pick the MID the Sorted Array
                //Here we may take the mid because the midest may be the lowest.
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
