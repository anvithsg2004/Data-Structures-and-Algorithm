package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair5 {
    int row;
    int col;

    public Pair5(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class _11_Number_of_Islands {

    public void dfs(int row, int col, boolean[][] visited, char[][] grid, int[] drow, int[] dcol) {

        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == false && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, visited, grid, drow, dcol);
            }

        }

    }

    public int numIslands(char[][] grid) {

        //All 8 directions.
        //int[] drow = {-1, -1, -1, 0, 1, 1, 1, 0}; // Row direction
        //int[] dcol = {-1, 0, 1, 1, 1, 0, -1, -1}; // Column direction

        // Only 4 directions: up, down, left, right
        int[] drow = {-1, 1, 0, 0}; // Row direction
        int[] dcol = {0, 0, -1, 1}; // Column direction

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, visited, grid, drow, dcol);
                }
            }
        }

        return count;

    }

    // Function to find the number of islands.
    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        // Only 4 directions: up, down, left, right
        int[] drow = {-1, 1, 0, 0}; // Row direction
        int[] dcol = {0, 0, -1, 1}; // Column direction

        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // if not visited and is a land
                if (vis[row][col] == false && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid, drow, dcol);
                }
            }
        }
        return cnt;
    }

    public void bfs(int ro, int co, boolean[][] visited, char[][] grid, int[] drow, int[] dcol) {
        visited[ro][co] = true;

        Queue<Pair5> queue = new LinkedList<>();
        queue.add(new Pair5(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                    visited[nrow][ncol] = true;
                    queue.add(new Pair5(nrow, ncol));
                }
            }
        }
    }
}
