package DSA.Binary_Search;

public class _17_Find_the_Smallest_Divisor_Given_a_Threshold {

    //Example
    //Input: nums = [1,2,5,9], threshold = 6
    //Output: 5
    //Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
    //If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

    public int sumByD(int[] arr, int mid) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int) Math.ceil((double) arr[i] / (double) mid);
        }

        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold) {
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1;
        int high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
