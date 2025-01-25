package DSA.Array;

public class _24_Rotate_Matrix_Image_by_90_Degrees {

    //Optimal Solution
    public void rotate2(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        //First transpose
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < columns; j++) {

                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //Second reverse
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns / 2; j++) {

                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows - 1 - j];
                matrix[i][rows - 1 - j] = temp;

            }
        }

    }



    //Brute Force
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                //I can take any either rows or columns because the matrix is square matrix.
                //There is a pattern if we write the matrix rotate by 90.
                result[j][rows - 1 - i] = matrix[i][j];

            }
        }

    }

    public static void main(String[] args) {

    }
}
