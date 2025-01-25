package DSA.Binary_Search;

public class _8_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        //Take this array and do a dry run.
        //7 8 9 1 2 3 4 5 6
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
