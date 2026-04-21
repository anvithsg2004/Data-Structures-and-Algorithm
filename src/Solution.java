import java.util.*;

public class Solution {

    public int[][] colorGrid(int rows, int cols, int[][] sources) {

        // Step 1: Initialize queue (acts like BFS list)
        List<int[]> queue = new ArrayList<>();

        for (int[] src : sources) {
            int r = src[0];
            int c = src[1];
            int color = src[2];
            queue.add(new int[]{r, c, color});
        }

        // Step 2: Sort by color DESC (higher color spreads first)
        queue.sort((a, b) -> Integer.compare(b[2], a[2]));

        // Step 3: Initialize result grid
        int[][] grid = new int[rows][cols];

        // Fill initial sources
        for (int[] cell : queue) {
            int r = cell[0];
            int c = cell[1];
            int color = cell[2];
            grid[r][c] = color;
        }

        // Directions: down, up, right, left
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Step 4: BFS expansion
        for (int index = 0; index < queue.size(); index++) {

            int[] current = queue.get(index);
            int r = current[0];
            int c = current[1];
            int color = current[2];

            for (int d = 0; d < 4; d++) {
                int newRow = r + dx[d];
                int newCol = c + dy[d];

                // Check bounds + unvisited
                if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 0) {

                    grid[newRow][newCol] = color;

                    // Add to queue for further expansion
                    queue.add(new int[]{newRow, newCol, color});
                }
            }
        }

        return grid;
    }
}
