package DSA.Binary_Search;

import java.util.ArrayList;

public class _26_Search_in_a_sorted_2D_matrix {

    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int rowR = matrix.size();
        int colR = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = rowR * colR - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / colR, col = mid % colR;
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
