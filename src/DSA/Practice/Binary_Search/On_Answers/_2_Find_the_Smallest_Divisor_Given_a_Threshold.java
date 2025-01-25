package DSA.Practice.Binary_Search.On_Answers;

import java.util.Arrays;

public class _2_Find_the_Smallest_Divisor_Given_a_Threshold {

    public int sum(int[] nums, int divisor) {

        int sum = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            sum = sum + (nums[i] / divisor);

        }

        return sum;

    }

    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;

        int low = 1;
        int high = Arrays.stream(nums).max().orElse(0);

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = sum(nums, mid);

            if (sum > threshold) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
