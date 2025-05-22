package DSA.Subarrays.Easy;

public class _7_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {

                if (nums[j - 1] < nums[j]) {
                    count = count + 1;
                } else {
                    break;
                }

            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;

    }
}
