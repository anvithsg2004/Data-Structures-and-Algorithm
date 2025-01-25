package LeetCode_Contest_Questions;

import java.util.ArrayList;
import java.util.List;

public class _2_Zigzag_Grid_Traversal_With_Skip {
    public List<Integer> zigzagTraversal(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] convertedFrom2DTo1D = new int[n * m];

        boolean isEven = true;

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (isEven) {

                for (int j = 0; j < m; j++) {
                    convertedFrom2DTo1D[index] = grid[i][j];
                    index++;
                }

            } else {

                for (int j = m - 1; j >= 0; j--) {
                    convertedFrom2DTo1D[index] = grid[i][j];
                    index++;
                }

            }

            isEven = !isEven;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < (n * m); i = i + 2) {
            result.add(convertedFrom2DTo1D[i]);
        }

        return result;

    }
}
