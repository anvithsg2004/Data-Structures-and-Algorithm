package DSA.Graphs._2_Problems_on_BFS_DFS;

public class _8_Number_of_Enclaves {

    public void dfs(int row, int col, int[] drow, int[] dcol, boolean[][] visited, int[][] grid) {

        visited[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == false && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, drow, dcol, visited, grid);
            }
        }

    }

    public int numEnclaves(int[][] grid) {

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int noOf1 = 0;

        //Traverse through first Column and last Column.
        for (int i = 0; i < n; i++) {

            //First Row
            if (visited[i][0] == false && grid[i][0] == 1) {
                dfs(i, 0, drow, dcol, visited, grid);
            }

            //Last Row
            if (visited[i][m - 1] == false && grid[i][m - 1] == 1) {
                dfs(i, m - 1, drow, dcol, visited, grid);
            }

        }

        //Traverse through the first row and last row.
        for (int i = 0; i < m; i++) {

            //First Row
            if (visited[0][i] == false && grid[0][i] == 1) {
                dfs(0, i, drow, dcol, visited, grid);
            }

            //Last Row
            if (visited[n - 1][i] == false && grid[n - 1][i] == 1) {
                dfs(n - 1, i, drow, dcol, visited, grid);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    noOf1++;
                }
            }
        }

        return noOf1;

    }

    public static void main(String[] args) {

    }
}
