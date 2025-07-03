package DSA.Graphs._2_Problems_on_BFS_DFS;

public class _7_Surrounded_Regions {

    public static void dfs(int row, int col, boolean[][] visited, char[][] mat, int[] drow, int[] dclo) {
        visited[row][col] = true;
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = col + dclo[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == false && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visited, mat, drow, dclo);
            }

        }

    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // All elements are already false
        boolean[][] visited = new boolean[n][m];

        //Traverse through first Column and last Column.
        for (int i = 0; i < n; i++) {

            //First Row
            if (visited[i][0] == false && board[i][0] == 'O') {
                dfs(i, 0, visited, board, drow, dcol);
            }

            //Last Row
            if (visited[i][m - 1] == false && board[i][m - 1] == 'O') {
                dfs(i, m - 1, visited, board, drow, dcol);
            }

        }

        //Traverse through the first row and last row.
        for (int i = 0; i < m; i++) {

            //First Row
            if (visited[0][i] == false && board[0][i] == 'O') {
                dfs(0, i, visited, board, drow, dcol);
            }

            //Last Row
            if (visited[n - 1][i] == false && board[n - 1][i] == 'O') {
                dfs(n - 1, i, visited, board, drow, dcol);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
}
