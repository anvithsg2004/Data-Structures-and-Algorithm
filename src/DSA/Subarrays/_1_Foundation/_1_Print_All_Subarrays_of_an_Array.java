package DSA.Subarrays._1_Foundation;

public class _1_Print_All_Subarrays_of_an_Array {

    public static void AllSubArray(int[] arr) {

        int n = arr.length;

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {

                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }

            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        AllSubArray(arr);
    }
}
