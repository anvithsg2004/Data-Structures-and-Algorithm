package DSA.Binary_Search;

public class _7_Count_Occurrences_in_Sorted_Array {

    //Here After Getting, Go beyond the mid to get the first Index.
    //This here means go the left of the first occurring given number.
    public int firstOccur(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //So here we want the first occurrence, so reduce the high and get the first occurrence.
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    //Here After Getting, Go After the mid to get the last Index.
    public int lastOccur(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //So If I get the element, then increase the lope so that I get the last element.
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public int[] firstAndLast(int[] arr, int n, int x) {
        int first = firstOccur(arr, n, x);
        int last = lastOccur(arr, n, x);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{first, last};
    }

    public int count(int[] arr, int n, int x) {
        int[] ans = firstAndLast(arr, n, x);
        if (ans[0] == -1) {
            return 0;
        }

        return ans[1] - ans[0] + 1;
    }

    public static void main(String[] args) {

    }
}
