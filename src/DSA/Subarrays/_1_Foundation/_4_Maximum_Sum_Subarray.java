package DSA.Subarrays._1_Foundation;

public class _4_Maximum_Sum_Subarray {

    public static int MaxSum(int[] arr) {

        int n = arr.length;

        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < n; start++) {

            sum = 0;

            for (int end = start; end < n; end++) {

                sum = sum + arr[end];
                maxSum = Math.max(maxSum, sum);

            }

        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(MaxSum(arr));
    }
}
