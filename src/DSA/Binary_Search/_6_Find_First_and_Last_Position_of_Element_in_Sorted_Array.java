package DSA.Binary_Search;

public class _6_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int a = lowerBound(nums, target);


        //For Example, {1,2,3,4,8,8,8,9,10}
        //LB :- 4
        //UB :- 7

        //So return LB, UB - 1

        if (a == nums.length || nums[a] != target) {
            return new int[]{-1, -1};
        }

        int b = upperBound(nums, target);

        return new int[]{a, b - 1};
    }
}
