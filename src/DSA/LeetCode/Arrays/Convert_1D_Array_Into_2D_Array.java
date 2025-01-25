package DSA.LeetCode.Arrays;

public class Convert_1D_Array_Into_2D_Array {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] matrix = new int[m][n];

        if ((m * n) != original.length) {
            return new int[0][0];
        }

        for (int i = 0; i < original.length; i++) {
            matrix[i / n][i % n] = original[i];
        }

        return matrix;
    }

    public static void main(String[] args) {

    }
}
