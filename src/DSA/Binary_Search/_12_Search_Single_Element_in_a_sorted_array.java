package DSA.Binary_Search;

public class _12_Search_Single_Element_in_a_sorted_array {

    //We can do it in simple by taking the XOR for all the elements.

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

            //If the mid is not equal to the previous and the next element.
            //Then return the mid.
            if ((nums[mid] != nums[mid + 1]) && (nums[mid] != nums[mid - 1])) {
                return nums[mid];
            }

                //ODD
                //If this comes the odd then we take the previous and check.
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    ||
                //EVEN
                //If this comes even then we take the current and next one and compare.
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                //Then we move the low.
                low = mid + 1;
            } else {
                //Or else then we take the high down.
                high = mid - 1;
            }
        }

        return -1;
    }
}
