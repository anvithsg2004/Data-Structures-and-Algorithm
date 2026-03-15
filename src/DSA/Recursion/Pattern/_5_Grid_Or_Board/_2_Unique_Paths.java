package DSA.Recursion.Pattern._5_Grid_Or_Board;

public class _2_Unique_Paths {
    public int uniquePaths(int m, int n) {

        return help(0, 0, m, n);

    }

    public int help(int row, int col, int m, int n) {

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }

        int right = help(row + 1, col, m, n);
        int down = help(row, col + 1, m, n);

        return right + down;

    }
}
