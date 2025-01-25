package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _2_Binary_Search {

    public static int binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target < arr[mid]) {
            return binarySearch(arr, target, mid + 1, end);
        }

        return binarySearch(arr, target, start, mid - 1);
    }

    public static void main(String[] args) {

    }
}
