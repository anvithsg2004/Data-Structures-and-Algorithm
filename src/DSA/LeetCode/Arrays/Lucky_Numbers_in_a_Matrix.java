package DSA.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lucky_Numbers_in_a_Matrix {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] row_mini = new int[row];
        Arrays.fill(row_mini, Integer.MAX_VALUE);
        int[] col_max = new int[col];
        Arrays.fill(col_max, Integer.MIN_VALUE);

        for (int row_ind = 0; row_ind < row; row_ind++) {
            for (int col_ind = 0; col_ind < col; col_ind++) {
                int ele = matrix[row_ind][col_ind];
                row_mini[row_ind] = Math.min(row_mini[row_ind], ele);
                col_max[col_ind] = Math.max(col_max[col_ind], ele);
            }
        }

        for (int row_ind = 0; row_ind < row; row_ind++) {
            for (int col_ind = 0; col_ind < col; col_ind++) {
                int ele = matrix[row_ind][col_ind];
                if (ele == row_mini[row_ind] && ele == col_max[col_ind]) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(ele);
                    return ls;
                }
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {

    }
}
