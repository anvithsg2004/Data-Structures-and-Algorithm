package DSA.Binary_Search;

public class _19_Kth_Missing_Positive_Number {

    //Brute Force Solution
    public static int missingK(int[] vec, int n, int k) {
        //This is a good solution
        //Remember this.
        //If the element in the array is smaller that the k.
        //Then increase the k by 1.
        for (int i = 0; i < n; i++) {
            if (vec[i] <= k) {
                k++; //shifting k
            } else {
                break;
            }
        }
        return k;
    }

    //Optimised Solution
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        //index = 0 1 2 3 4
        //Array = 2 3 4 7 11
        //Missing 1 1 1 3 6
        //Missing = Array[mid] - (mid + 1)

        //By this we can figure out the range of the missing number where it is missing.

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        //At last the low and the high will be crossed.
        //high ___ low

        //Add the K to index and add 1 to it and return it.
        return k + arr[high] + 1;
    }
}
