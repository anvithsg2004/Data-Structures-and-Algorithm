package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _5_Shortest_Distance_Binary_Maze {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        // 8-directional movement
        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] values = queue.poll();
            int row = values[0];
            int col = values[1];
            int distance = values[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }

            for (int i = 0; i < 8; i++) {

                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                if (isValid(newRow, newCol, drow, dcol, grid, visited)) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, distance + 1});

                }


            }

        }

        return -1;

    }

    public boolean isValid(int row, int col, int[] dRow, int[] dCol, int[][] grid, boolean[][] visited) {

        int rowLength = grid.length;
        int colLength = grid[0].length;

        return row >= 0 && row < rowLength && col >= 0 && col < colLength && visited[row][col] == false && grid[row][col] == 0;
    }
}
