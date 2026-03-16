package DSA.Graphs._2_Problems_on_BFS_DFS;

public class _7_Surrounded_Regions {

    public void solve(char[][] board) {

        int rowLength = board.length;
        int colLength = board[0].length;

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        boolean[][] borderConnectedElements = new boolean[rowLength][colLength];

        int n = board.length;
        int m = board[0].length;

        // Top row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                borderConnectedElements[0][j] = true;
            }
        }

        // Right column
        for (int i = 1; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                borderConnectedElements[i][m - 1] = true;
            }
        }

        // Bottom row
        for (int j = m - 2; j >= 0; j--) {
            if (board[n - 1][j] == 'O') {
                borderConnectedElements[n - 1][j] = true;
            }
        }

        // Left column
        for (int i = n - 2; i > 0; i--) {
            if (board[i][0] == 'O') {
                borderConnectedElements[i][0] = true;
            }
        }

        int row;
        int col;

        // Top
        row = 0;
        col = 0;
        for (int i = col; i < colLength; i++) {
            if (board[row][i] == 'O') {
                dfs(row, i, board, borderConnectedElements, rowDir, colDir);
            }
        }

        // Bottom
        row = rowLength - 1;
        col = 0;
        for (int i = col; i < colLength; i++) {
            if (board[row][i] == 'O') {
                dfs(row, i, board, borderConnectedElements, rowDir, colDir);
            }
        }

        // Left
        row = 0;
        col = 0;
        for (int i = row; i < rowLength; i++) {
            if (board[i][col] == 'O') {
                dfs(i, col, board, borderConnectedElements, rowDir, colDir);
            }
        }

        // Right
        row = 0;
        col = colLength - 1;

        for (int i = row; i < rowLength; i++) {
            if (board[i][col] == 'O') {
                dfs(i, col, board, borderConnectedElements, rowDir, colDir);
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                if (borderConnectedElements[i][j] == false) {
                    board[i][j] = 'X';
                }

            }
        }

    }

    public void dfs(int row, int col, char[][] board, boolean[][] borderConnectedElements, int[] rowDir, int[] colDir) {

        borderConnectedElements[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int newRol = row + rowDir[i];
            int newCol = col + colDir[i];

            if (newRol >= 0 && newRol < board.length && newCol >= 0 && newCol < board[0].length &&
                    borderConnectedElements[newRol][newCol] == false && board[newRol][newCol] == 'O') {
                dfs(newRol, newCol, board, borderConnectedElements, rowDir, colDir);
            }

        }

    }
}
