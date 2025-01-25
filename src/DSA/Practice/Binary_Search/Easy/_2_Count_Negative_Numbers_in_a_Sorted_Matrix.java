package DSA.Practice.Binary_Search.Easy;

public class _2_Count_Negative_Numbers_in_a_Sorted_Matrix {

    public int countNegatives(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {

            int low = 0;
            int high = col;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (grid[i][mid] < 0) {
                    high = mid;  // Move the high pointer to mid (the first negative element)
                } else {
                    low = mid + 1;  // Move the low pointer to mid + 1 (skip positive values)
                }
            }

            // After finding the first negative element in the row,
            // all elements from `low` to `col - 1` are negative.
            count = count + col - low;

        }

        return count;

    }

    public static void main(String[] args) {

    }
}
