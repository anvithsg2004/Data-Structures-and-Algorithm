package DSA.Practice.Binary_Search.Medium;

public class _13_Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }

        }

        return false;

    }

    public static void main(String[] args) {

    }
}
