package DSA.Array;

import java.util.Arrays;

public class _32_Merge_two_sorted_arrays_without_extra_space {

    // Optimal Code
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = m - 1;
        int right = 0;

        // Swap elements until nums1[left] is smaller than nums2[right]
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                // Swap nums1[left] with nums2[right]
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort nums1[] and nums2[] individually
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    // Driver Code
    public static void main(String[] args) {
        _32_Merge_two_sorted_arrays_without_extra_space obj = new _32_Merge_two_sorted_arrays_without_extra_space();

        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        obj.merge(nums1, nums1.length, nums2, nums2.length);

        System.out.println("Merged Array 1: " + Arrays.toString(nums1));
        System.out.println("Merged Array 2: " + Arrays.toString(nums2));
    }
}
