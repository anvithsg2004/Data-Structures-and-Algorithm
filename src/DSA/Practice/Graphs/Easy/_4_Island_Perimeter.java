package DSA.Practice.Graphs.Easy;

public class _4_Island_Perimeter {

    public static int islandPerimeter(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] perimeter = new int[1]; // To store the perimeter count

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Start DFS only for unvisited land cells
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, perimeter, visited, i, j, drow, dcol);
                }
            }
        }

        return perimeter[0];
    }

    public static void dfs(int[][] grid, int[] perimeter, boolean[][] visited, int row, int col, int[] drow, int[] dcol) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            // Check boundary and water cells
            if (nrow < 0 || nrow >= grid.length || ncol < 0 || ncol >= grid[0].length || grid[nrow][ncol] == 0) {
                perimeter[0]++;
            } else if (!visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                // Recurse for unvisited land cells
                dfs(grid, perimeter, visited, nrow, ncol, drow, dcol);
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(grid));

    }
}
