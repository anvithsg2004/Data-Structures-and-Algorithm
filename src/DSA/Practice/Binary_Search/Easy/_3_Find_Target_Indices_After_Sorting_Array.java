package DSA.Practice.Binary_Search.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _3_Find_Target_Indices_After_Sorting_Array {

    public List<Integer> targetIndices(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        int low = LB(nums, target, n);

        int high = UB(nums, target, n);

        List<Integer> result = new ArrayList<>();

        for (int i = low; i <= high; i++) {

            result.add(nums[i]);

        }

        return result;

    }

    public static int UB(int[] arr, int target, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        //Return arr[i] > target
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int LB(int[] arr, int target, int n) {
        int low = 0;
        int high = n - 1;
        //If nothing is gotten, return the last hypothetical Index.
        //Remember this throughout the binary Search.
        int ans = n;

        //Return arr[i] >= target
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
