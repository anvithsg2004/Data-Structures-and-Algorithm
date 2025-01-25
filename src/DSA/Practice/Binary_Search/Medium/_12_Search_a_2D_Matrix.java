package DSA.Practice.Binary_Search.Medium;

public class _12_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowR = matrix.length;
        int colR = matrix[0].length;

        int low = 0;
        int high = rowR * colR - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / colR;
            int col = mid % colR;

            if (matrix[row][col] == target) {

                return true;

            } else if (matrix[row][col] < target) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        return false;

    }

    public static void main(String[] args) {

    }
}
