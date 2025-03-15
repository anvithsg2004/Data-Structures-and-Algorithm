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

        //Approach: Start from the Top-Right Corner
        //Start at (0, m-1) → (first row, last column)
        //If matrix[row][col] == target, return true
        //If matrix[row][col] > target, move left
        //If matrix[row][col] < target, move down

        //Why Does This Work?
        //Moving left (col--) removes large numbers.
        //Moving down (row++) removes small numbers.
        //We eliminate one row or one column at a time, making the solution fast.

        //traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) row++;
            else col--;
        }
        return false;
    }
}
