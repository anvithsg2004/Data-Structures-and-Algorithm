package DSA.Binary_Search;

public class _2_Lower_Bound {

    //First or the smallest index in a sorted array
    //where the value at that index is greater than or equal to a given key.
    public static int fun(int[] arr, int target, int n) {
        int low = 0;
        int high = n - 1;
        //If nothing is gotten, return the last hypothetical Index.
        //Remember this throughout the binary Search.
        int ans = n;

        //Return arr[i] >= target
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
