package DSA.Array;

import java.util.Arrays;

public class _32_Merge_two_sorted_arrays_without_extra_space {

    //Optimal Code
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {

            if (nums1[left] > nums2[right]) {

                int temp = nums1[left];
                nums1[left] = nums1[right];
                nums2[right] = temp;
                left--;
                right++;

            } else {

                break;

            }

        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(nums1);
        Arrays.sort(nums2);

    }
}
