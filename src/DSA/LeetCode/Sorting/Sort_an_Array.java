package DSA.LeetCode.Sorting;

import java.util.ArrayList;

public class Sort_an_Array {

    public int[] sortArray(int[] nums) {
        int[] arr = new int[nums.length];
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        merge(arr,nums, low, high);

        return arr;
    }

    public void merge(int[] arr,int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = (low + high) / 2;

        merge(arr, nums, low, high);
        merge(arr, nums, mid + 1, high);
        mergeSort(arr, nums, low, mid, high);
    }

    public void mergeSort(int[] arr,int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; low < high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {

    }
}
