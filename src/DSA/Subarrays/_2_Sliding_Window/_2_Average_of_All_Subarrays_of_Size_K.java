package DSA.Subarrays._2_Sliding_Window;

import java.util.Arrays;

public class _2_Average_of_All_Subarrays_of_Size_K {

    public static double[] averageSubarray(int[] arr, int k) {

        int n = arr.length;
        double[] result = new double[n - k + 1];

        int windowSum = 0;

        for (int i = 0; i < k; i++)
            windowSum += arr[i];

        result[0] = windowSum / (double) k;

        for (int i = k; i < n; i++) {

            windowSum += arr[i];
            windowSum -= arr[i - k];

            result[i - k + 1] = windowSum / (double) k;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(Arrays.toString(averageSubarray(arr, k)));
    }

}
