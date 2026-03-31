package DSA.Graphs._2_Problems_on_BFS_DFS;

public class _8_Number_of_Enclaves {

    public int numEnclaves(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        boolean[][] borderConnectedElements = new boolean[rowLen][colLen];

        int n = grid.length;
        int m = grid[0].length;

        // Top row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                borderConnectedElements[0][j] = true;
            }
        }

        // Right column
        for (int i = 1; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                borderConnectedElements[i][m - 1] = true;
            }
        }

        // Bottom row
        for (int j = m - 2; j >= 0; j--) {
            if (grid[n - 1][j] == 1) {
                borderConnectedElements[n - 1][j] = true;
            }
        }

        // Left column
        for (int i = n - 2; i > 0; i--) {
            if (grid[i][0] == 1) {
                borderConnectedElements[i][0] = true;
            }
        }

        // Traversal

        // Top row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, rowDir, colDir, grid, borderConnectedElements);
            }
        }

        // Right column
        for (int i = 1; i < n; i++) {
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, rowDir, colDir, grid, borderConnectedElements);
            }
        }

        // Bottom row
        for (int j = m - 2; j >= 0; j--) {
            if (grid[n - 1][j] == 1) {
                dfs(n - 1, j, rowDir, colDir, grid, borderConnectedElements);
            }
        }

        // Left column
        for (int i = n - 2; i > 0; i--) {
            if (grid[i][0] == 1) {
                dfs(i, 0, rowDir, colDir, grid, borderConnectedElements);
            }
        }

        int count = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1 && borderConnectedElements[i][j] == false) {
                    count++;
                }
            }
        }

        return count;

    }

    public void dfs(int row, int col, int[] rowDir, int[] colDir, int[][] grid, boolean[][] borderConnectedElements) {

        borderConnectedElements[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && borderConnectedElements[newRow][newCol] == false) {
                dfs(newRow, newCol, rowDir, colDir, grid, borderConnectedElements);
            }

        }

    }
}
