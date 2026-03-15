package DSA.Subarrays._4_Prefix_Sum;

public class _1_Range_Sum_Query {
    public static int[] prefixSum(int[] arr) {

        int n = arr.length;
        int[] prefix = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + arr[i];

        return prefix;
    }
}
