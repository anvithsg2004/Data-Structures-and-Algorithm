package DSA.Practice.Arrays.Medium;

public class _1_Number_of_Ways_to_Split_Array {

    public int waysToSplitArray(int[] nums) {

        int n = nums.length;

        long[] prefixSum = new long[n];
        long[] reversePrefixSum = new long[n];

        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = (long) nums[i] + prefixSum[i - 1];
        }

        reversePrefixSum[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            reversePrefixSum[i] = (long) nums[i] + reversePrefixSum[i + 1];
        }

        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (prefixSum[i] >= reversePrefixSum[i + 1]) {
                count++;
            }
        }

        return count;

    }

}
