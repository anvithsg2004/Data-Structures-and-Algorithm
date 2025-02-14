package DSA.Array;

import java.util.ArrayList;
import java.util.List;

public class _25_Spiral_Traversal_of_a_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        //This is an important problem.
        //Remember the trick.

        //Left (Top++) -> Top(Right--) -> Right(Bottom--) -> Bottom(Left++)

        //Right → Bottom → Left → Top
        //In this the problem works.

        //Top       →       Right

        //   ^                  |
        //   |                  V

        //Left        ←      Bottom
        //First the pointers in this fashion.

        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0;
        int left = 0;
        int bottom = rows - 1;
        int right = columns - 1;

        // Define 'ans' list to store the result.
        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // For moving left to right
            for (int i = left; i <= right; i++) {

                ans.add(matrix[top][i]);

            }
            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) {

                ans.add(matrix[i][right]);

            }
            right--;

            // For moving right to left.
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {

                    ans.add(matrix[bottom][i]);

                }
                bottom--;

            }

            // For moving bottom to top.
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {

                    ans.add(matrix[i][left]);

                }
                left++;
            }

        }

        return ans;

    }
}
