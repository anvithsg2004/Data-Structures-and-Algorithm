package DSA.Practice.Binary_Search.On_Answers;

public class _1_Allocate_Minimum_Pages {

    public static int isPossible(int[] arr, int totalBookSum, int k) {

        int n = arr.length;

        int sum = 0;
        int students = 1;
        int pagesSum = 0;

        for (int i = 0; i < n; i++) {
            if (pagesSum + arr[i] <= totalBookSum) {
                pagesSum = pagesSum + arr[i];
            } else {
                students++;
                pagesSum = arr[i];
            }
        }

        return students;

    }

    public static int findPages(int[] arr, int k) {

        int n = arr.length;

        if (n < k) {
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high = high + arr[i];
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int students = isPossible(arr, mid, k);

            if (students > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low;

    }

    public static void main(String[] args) {

        int[] arr = {12, 34, 67, 90};
        System.out.println(findPages(arr, 2));

    }
}
