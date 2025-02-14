package DSA.Binary_Search;

import java.util.ArrayList;

public class _20_Find_Peak_Element {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of array

        //Here the answer is the index to return.

        // Edge cases:
        //If the length is 1 then we have to return the 0 as the index because there is only one index.
        if (n == 1) return 0;
        //Front
        //If the first index is greater than the next element then return 0.
        if (arr.get(0) > arr.get(1)) return 0;
        //Last
        //If the last is the greater than the last but one then return the last index.
        if (arr.get(n - 1) > arr.get(n - 2)) return n - 1;

        //Now start from the first to last but one as we have finished before.
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the peak:
            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1)) return mid;

            // If we are in the left:
            if (arr.get(mid) > arr.get(mid - 1)) low = mid + 1;

                // If we are in the right:
                // Or, arr[mid] is a common point:
            else high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }
}
