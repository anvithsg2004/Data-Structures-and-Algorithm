package DSA.LeetCode.Arrays;

public class Minimum_Swaps_to_Group_All_1s_Together_II {

    public static int minSwaps(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        //Copy array to Another
        int[] nums2 = nums.clone();

        int[] nums3 = new int[nums.length + nums2.length];

        System.arraycopy(nums, 0, nums3, 0, nums.length);
        System.arraycopy(nums2, 0, nums3, nums.length, nums2.length);

        int low = 0;
        int high = count - 1;
        int ones = 0;
        int max = Integer.MIN_VALUE;

        // Calculate initial number of ones in the first window
        for (int i = low; i <= high; i++) {
            if (nums3[i] == 1) {
                ones++;
            }
        }
        max = ones;

        // Sliding window
        while (high < nums3.length - 1) {
            if (nums3[low] == 1) {
                ones--;
            }
            low++;
            high++;
            if (nums3[high] == 1) {
                ones++;
            }
            max = Math.max(ones, max);
        }

        int swap = count - max;
        return swap;
    }

    public static void main(String[] args) {

    }
}
