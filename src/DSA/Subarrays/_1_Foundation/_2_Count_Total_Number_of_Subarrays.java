package DSA.Subarrays._1_Foundation;

public class _2_Count_Total_Number_of_Subarrays {

    public static int countSubArray(int[] arr) {

        int n = arr.length;

        int count = 0;

        for (int start = 0; start < n; start++) {

            for (int end = start; end < n; end++) {

                count++;

            }

        }

        return count;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(countSubArray(arr));
    }
}
