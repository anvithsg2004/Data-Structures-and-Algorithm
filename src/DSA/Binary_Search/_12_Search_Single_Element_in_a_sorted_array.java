package DSA.Binary_Search;

public class _12_Search_Single_Element_in_a_sorted_array {

    //Intuition
    //(even, odd) := The element is on the right half.
    //(odd, even) := The element is on the left half.

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        //Trim down from the last but one and  to the first.
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((nums[mid] != nums[mid + 1]) && (nums[mid] != nums[mid - 1])) {
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
