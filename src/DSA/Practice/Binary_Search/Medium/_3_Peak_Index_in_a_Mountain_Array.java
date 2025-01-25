package DSA.Practice.Binary_Search.Medium;

public class _3_Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;

        if (arr[0] > arr[1]) {
            return 0;
        }

        if (arr[n - 2] < arr[n - 1]) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {

                return mid;

            } else if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]) {

                low = mid + 1;

            } else if (arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid]) {

                high = mid - 1;

            }

        }

        return low;

    }

    public static void main(String[] args) {

    }
}
