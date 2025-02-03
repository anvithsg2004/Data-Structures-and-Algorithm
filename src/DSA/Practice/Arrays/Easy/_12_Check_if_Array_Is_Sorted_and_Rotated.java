package DSA.Practice.Arrays.Easy;

public class _12_Check_if_Array_Is_Sorted_and_Rotated {

    public boolean check(int[] nums) {
        int k = 0;

        int n = nums.length;

        for (int i = 1; i < n; i++) {

            int diff = nums[i] - nums[i - 1];

//            if (diff < 0 || ) {
//                k++;
//            }

        }

        if (k >= 2) {
            return false;
        }

        return true;
    }

//    public boolean check(int[] nums) {
//
//        int n = nums.length;
//
//        for (int i = 0; i < n - 1; i++) {
//
//            if (nums[i] <= nums[i + 1] && i + 1 == n - 1) {
//                return true;
//            }
//
//            if (nums[i] > nums[i + 1]) {
//                return checkIfSorted(nums, i + 1, n - 1);
//            }
//
//        }
//
//        return false;
//
//    }
//
//    public boolean checkIfSorted(int[] arr, int start, int end) {
//
//        for (int i = start; i < end - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                return false;
//            }
//        }
//
//        return true;
//
//    }
}
