package DSA.Practice.Arrays.Easy;

public class _13_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int count = 0;

        //Strictly Increasing
        int inMaxLength = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
                inMaxLength = Math.max(inMaxLength, count);
            } else {
                count = 0;
            }
        }

        count = 0;

        //Strictly Decreasing
        int deMaxLength = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                count++;
                deMaxLength = Math.max(deMaxLength, count);
            } else {
                count = 0;
            }
        }

        return Math.max(inMaxLength, deMaxLength) + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 2};
        System.out.println(longestMonotonicSubarray(nums));
    }
}
