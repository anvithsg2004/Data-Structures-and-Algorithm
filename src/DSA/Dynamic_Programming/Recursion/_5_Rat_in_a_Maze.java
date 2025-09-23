package DSA.Dynamic_Programming.Recursion;

import java.util.*;

public class _5_Rat_in_a_Maze {
    public ArrayList<String> ratInMaze(int[][] maze) {

        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        solve(0, 0, visited, paths, n, "", maze);

        return paths;
    }

    public void solve(int row, int col, boolean[][] visited, ArrayList<String> paths, int n, String path, int[][] maze) {

        if (n - 1 == row && n - 1 == col) {
            paths.add(path);
            return;
        }

        visited[row][col] = true;

// Move Down
        if (row + 1 < n && maze[row + 1][col] == 1 && !visited[row + 1][col])
            solve(row + 1, col, visited, paths, n, path + "D", maze);

// Move Left
        if (col - 1 >= 0 && maze[row][col - 1] == 1 && !visited[row][col - 1])
            solve(row, col - 1, visited, paths, n, path + "L", maze);

// Move Right
        if (col + 1 < n && maze[row][col + 1] == 1 && !visited[row][col + 1])
            solve(row, col + 1, visited, paths, n, path + "R", maze);

// Move Up
        if (row - 1 >= 0 && maze[row - 1][col] == 1 && !visited[row - 1][col])
            solve(row - 1, col, visited, paths, n, path + "U", maze);

        visited[row][col] = false;

    }
}
