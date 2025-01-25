package DSA.Binary_Search;

public class _4_Search_Insert_Position {

    //Just the Same as the Lower-Bound Code.
    public static int fun(int[] arr, int target, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
