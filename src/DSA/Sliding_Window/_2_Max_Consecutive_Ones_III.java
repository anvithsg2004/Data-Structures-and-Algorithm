package DSA.Sliding_Window;

public class _2_Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int right = 0;

        int maxi = 0;

        int countKs = 0;

        while (right < n) {

            if (nums[right] == 0) {
                countKs++;
            }

            while (countKs > k) {

                if (nums[left] == 0) {
                    countKs--;
                }

                left++;

            }

            maxi = Math.max(maxi, right - left + 1);

            right++;

        }

        return maxi;

    }
}
