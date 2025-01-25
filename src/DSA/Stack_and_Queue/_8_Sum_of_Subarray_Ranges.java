package DSA.Stack_and_Queue;

public class _8_Sum_of_Subarray_Ranges {

    //Optimal Solution
    //public long subArrayRanges2(int[] nums) {
    //    //Here the difference between Subarray Minimum and Subarray Maximum
    //}

    //Brute Force Solution
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }
}
