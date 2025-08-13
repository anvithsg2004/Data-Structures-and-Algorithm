package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

class Pair {
    //This will store which has turned to rotten tomatoes(which means 2)
    int row;
    int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class _2_Rotting_Oranges {

    public int orangesRotting(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int minute = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean rottedThisMinute = false;

            for (int k = 0; k < size; k++) {

                Pair pair = queue.peek();
                int row = pair.row;
                int col = pair.column;
                queue.remove();

                for (int i = 0; i < 4; i++) {

                    int newRow = dx[i] + row;
                    int newCol = dy[i] + col;

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && visited[newRow][newCol] == false) {
                        queue.add(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        fresh--;
                        rottedThisMinute = true;
                    }

                }

            }

            if (rottedThisMinute) {
                minute++;
            }

        }

        if (fresh == 0) {
            return minute;
        }

        return -1;

    }
}
