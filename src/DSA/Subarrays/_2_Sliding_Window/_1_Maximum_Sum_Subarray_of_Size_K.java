package DSA.Subarrays._2_Sliding_Window;

public class _1_Maximum_Sum_Subarray_of_Size_K {

    public static int MaxSum(int[] arr, int k) {

        int n = arr.length;

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int start = k; start < n; start++) {

            windowSum = windowSum + arr[start];
            windowSum = windowSum - arr[start - k];

            maxSum = Math.max(maxSum, windowSum);

        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(MaxSum(arr, k));
    }
}
