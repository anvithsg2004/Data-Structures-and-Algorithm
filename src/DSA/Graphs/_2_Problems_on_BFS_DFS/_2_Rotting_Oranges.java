package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _2_Rotting_Oranges {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[rows][cols];

        int freshOranges = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        int minutes = 0;

        while (!queue.isEmpty() && freshOranges > 0) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int[] coordinates = queue.poll();
                int row = coordinates[0];
                int col = coordinates[1];

                for (int i = 0; i < 4; i++) {

                    int newRow = row + rowDir[i];
                    int newCol = col + colDir[i];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {

                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                        freshOranges--;
                    }
                }
            }

            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
