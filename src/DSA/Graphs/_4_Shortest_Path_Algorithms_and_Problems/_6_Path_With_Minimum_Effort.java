package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _6_Path_With_Minimum_Effort {

    public int minimumEffortPath(int[][] heights) {

        int rowLen = heights.length;
        int colLen = heights[0].length;

        int[][] dist = new int[rowLen][colLen];
        for (int[] distRow : dist) {
            Arrays.fill(distRow, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int effort = current[2];

            if (row == rowLen - 1 && col == colLen - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                if (isValid(newRow, newCol, rowLen, colLen)) {

                    int edgeDiff = Math.abs(heights[row][col] - heights[newRow][newCol]);

                    int newEffort = Math.max(effort, edgeDiff);

                    if (newEffort < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newEffort;
                        pq.add(new int[]{newRow, newCol, newEffort});

                    }

                }

            }

        }

        return 0;

    }

    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}
