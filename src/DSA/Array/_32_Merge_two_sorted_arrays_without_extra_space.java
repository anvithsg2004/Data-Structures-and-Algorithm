package DSA.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _32_Merge_two_sorted_arrays_without_extra_space {

    // Optimal Code
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Last element in initialized part of nums1
        int j = n - 1;         // Last element in nums2
        int k = m + n - 1;     // Last index of nums1 (total space)

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k = k - 1;
                i = i - 1;
            } else {
                nums1[k] = nums2[j];
                k = k - 1;
                j = j - 1;
            }
        }

        // If nums2 is not exhausted
        while (j >= 0) {
            nums1[k] = nums2[j];
            k = k - 1;
            j = j - 1;
        }
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
