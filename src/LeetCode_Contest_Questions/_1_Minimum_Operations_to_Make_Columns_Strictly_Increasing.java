package LeetCode_Contest_Questions;

public class _1_Minimum_Operations_to_Make_Columns_Strictly_Increasing {

    public static int minimumOperations(int[][] grid) {

        int colLength = grid.length;
        int rowLength = grid[0].length;

        int operations = 0;

        int count = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {

                operations = grid[j][i] - grid[j - 1][i];

                if (operations <= 0) {
                    operations = Math.abs(grid[j][i] - grid[j - 1][i]) + 1;

                    count = count + Math.abs(grid[j][i] - grid[j - 1][i]) + 1;

                    grid[j][i] = grid[j][i] + operations;
                }

            }
        }

        return count;
    }

}
