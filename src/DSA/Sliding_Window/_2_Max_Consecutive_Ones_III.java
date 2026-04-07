package DSA.Sliding_Window;

public class _2_Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {

        int n = nums.length;

        int i = 0;
        int j = 0;

        int zeros = 0;

        int maxLength = 0;

        while (j < n) {

            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;

        }

        return maxLength;

    }
}
