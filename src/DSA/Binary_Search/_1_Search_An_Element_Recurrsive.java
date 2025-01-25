package DSA.Binary_Search;

public class _1_Search_An_Element_Recurrsive {

    public static int recursive(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        return fun(arr, low, high, target);
    }

    public static int fun(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return fun(arr, mid + 1, high, target);
        }

        return fun(arr, low, mid - 1, target);
    }

    public static void main(String[] args) {

    }
}
