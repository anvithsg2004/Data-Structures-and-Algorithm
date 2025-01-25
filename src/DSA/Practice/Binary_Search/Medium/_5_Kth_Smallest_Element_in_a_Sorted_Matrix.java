package DSA.Practice.Binary_Search.Medium;

import java.util.ArrayList;

public class _5_Kth_Smallest_Element_in_a_Sorted_Matrix {

    public int kthSmallest(int[][] matrix, int k) {

        int row = matrix.length;

        int column = matrix[0].length;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                result.add(matrix[i][j]);

            }

        }

        result.sort((a, b) -> Integer.compare(a, b));

        return result.get(k - 1);

    }

    public static void main(String[] args) {

    }
}
