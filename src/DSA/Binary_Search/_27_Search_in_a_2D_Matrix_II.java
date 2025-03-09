package DSA.Binary_Search;

import java.util.ArrayList;

public class _27_Search_in_a_2D_Matrix_II {

    //In this the individual rows and columns are sorted.
    //Better Solution
    //Take individual row and apply Binary Search as it is sorted individually.
    public static boolean binarySearch(ArrayList<Integer> nums, int target) {
        int n = nums.size(); //size of the array
        int low = 0, high = n - 1;

        // Perform the steps:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) == target) return true;
            else if (target > nums.get(mid)) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        for (int i = 0; i < n; i++) {
            boolean flag = binarySearch(matrix.get(i), target);
            if (flag == true) return true;
        }
        return false;
    }

    //Optimal Solution
    public static boolean searchElement2(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int row = 0, col = m - 1;

        //traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) row++;
            else col--;
        }
        return false;
    }
}
