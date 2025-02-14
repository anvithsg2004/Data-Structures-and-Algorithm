package DSA.Array;

public class _23_Set_Matrix_Zeroes {

    //Brute Force Solution
    public static void setZeroes(int[][] matrix) {

        // Get the number of rows
        int rows = matrix.length;

        // Get the number of columns
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == 0) {

                    markRow(matrix, rows, columns, i);
                    markCol(matrix, rows, columns, j);

                }

            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void markRow(int[][] matrix, int rows, int columns, int i) {

        for (int j = 0; j < columns; j++) {
            if (matrix[i][j] != 0) {

                matrix[i][j] = -1;

            }
        }

    }

    public static void markCol(int[][] matrix, int rows, int columns, int j) {

        for (int i = 0; i < rows; i++) {
            if (matrix[i][j] != 0) {

                matrix[i][j] = -1;

            }
        }

    }


    //Better Solution
    public static void setZeroes2(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        //Create this arrays to store in which index the element is zero.
        boolean[] row = new boolean[rows];
        boolean[] column = new boolean[columns];

        //Traverse the matrix and find out where is the element is zero.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {

                    //Marks the 'row' and 'col' array with true.
                    row[i] = true;

                    column[j] = true;

                }
            }
        }

        //Now If we get any row or col array as true, then mark the entire row and column as zero.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (row[i] == true || column[j] == true) {
                    matrix[i][j] = 0;
                }

            }
        }

    }
}
