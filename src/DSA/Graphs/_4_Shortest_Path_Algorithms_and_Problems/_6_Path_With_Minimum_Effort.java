package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.PriorityQueue;

class Tuple2 {
    int row;
    int col;
    int distance;

    public Tuple2(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class _6_Path_With_Minimum_Effort {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;

        //Priority Queue is a must.
        //Be careful.
        //LeetCode does not accept this thing.
        PriorityQueue<Tuple2> queue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        queue.add(new Tuple2(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            Tuple2 current = queue.poll();
            int row = current.row;
            int col = current.col;
            int diff = current.distance;

            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if (row == n - 1 && col == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newc >= 0 && newc < m && newr < n) {

                    int newDist = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);

                    if (newDist < dist[newr][newc]) {
                        dist[newr][newc] = newDist;
                        queue.add(new Tuple2(newr, newc, newDist));
                    }
                }
            }

        }

        return 0;

    }

    public static void main(String[] args) {

    }
}
