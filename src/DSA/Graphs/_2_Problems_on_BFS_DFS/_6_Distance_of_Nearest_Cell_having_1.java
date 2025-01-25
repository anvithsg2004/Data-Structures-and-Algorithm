package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair3 {
    int row;
    int col;
    int distance;

    public Pair3(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class _6_Distance_of_Nearest_Cell_having_1 {
    //In LeetCode, it is 0/1 Matrix
    //Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        Queue<Pair3> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new Pair3(i, j, 0));
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int row = queue.peek().row;
            int column = queue.peek().col;
            int distanceTo1 = queue.peek().distance;

            queue.remove();
            distance[row][column] = distanceTo1;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = column + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    queue.add(new Pair3(nrow, ncol, distanceTo1 + 1));
                }
            }

        }

        return distance;

    }

    public static void main(String[] args) {

    }
}
