package DSA.Sliding_Window;

public class _2_Max_Consecutive_Ones_III {

    //Brute Force Solution
    //We can convert this question to like Longest Sub String with at most k zero's
    public int longestOnes2(int[] nums, int k) {

        int maxLen = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int zero = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zero++;
                }

                if (zero <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }

        return maxLen;

    }

    //Optimised Solution
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int zeroSum = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroSum++;
            }

            while (zeroSum > k) {
                if (nums[l] == 0) {
                    zeroSum--;
                }
                l++;
            }
            if (zeroSum <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }

        return maxLen;
    }
}
