package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple {
    int u;
    int v;
    int distance;

    public Tuple(int u, int v, int distance) {
        this.u = u;
        this.v = v;
        this.distance = distance;
    }
}

public class _5_Shortest_Distance_Binary_Maze {

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Tuple> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        // Validate the source and destination based on standard convention
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) {
            return -1;
        }

        // Handle the 1x1 grid case
        if (n == 1 && m == 1) {
            return 1;
        }

        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        distance[0][0] = 1;
        queue.add(new Tuple(0, 0, 1));

        // 8-directional movement
        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int row = current.u;
            int column = current.v;
            int dist = current.distance;

            for (int i = 0; i < 8; i++) { // Iterate through all 8 directions
                int newr = row + drow[i];
                int newc = column + dcol[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 0 && dist + 1 < distance[newr][newc]) {
                    distance[newr][newc] = dist + 1;
                    if (newr == n - 1 && newc == m - 1) {
                        return dist + 1;
                    }
                    queue.add(new Tuple(newr, newc, dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
