package DSA.Practice.Binary_Search.Medium;

public class _9_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        int low = 0;

        int minLen = Integer.MAX_VALUE;

        int sum = 0;

        for (int high = 0; high < n; high++) {

            sum = sum + nums[high];

            while (sum >= target) {

                minLen = Math.min(minLen, high - low + 1);

                sum = sum - nums[low];

                low++;

            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static void main(String[] args) {

    }
}
