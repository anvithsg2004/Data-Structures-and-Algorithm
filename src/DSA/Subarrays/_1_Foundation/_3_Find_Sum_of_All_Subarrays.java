package DSA.Subarrays._1_Foundation;

public class _3_Find_Sum_of_All_Subarrays {

    // (i+1) the subarray can start anywhere from
    // (n-i) The subarray can end anywhere from
    // total subarrays = start choices × end choices
    // contribution = arr[i] * (i + 1) * (n - i)

    public static int totalSum(int[] arr) {

        int n = arr.length;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {

            int contribution = arr[i] * (i + 1) * (n - i);
            totalSum = totalSum + contribution;

        }

        return totalSum;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(totalSum(arr));
    }
}
