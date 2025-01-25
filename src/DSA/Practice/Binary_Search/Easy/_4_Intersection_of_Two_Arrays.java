package DSA.Practice.Binary_Search.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _4_Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Sort nums1 to enable binary search
        Arrays.sort(nums1);

        // Step 2: Use a set to store the result to avoid duplicates
        Set<Integer> resultSet = new HashSet<>();

        // Step 3: For each element in nums2, use binary search to check if it exists in nums1
        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                resultSet.add(num);
            }
        }

        // Step 4: Convert the result set to an array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    // Binary search function
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
