package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _6_Distance_of_Nearest_Cell_having_1 {
    //In LeetCode, it is 0/1 Matrix
    //Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    public int[][] updateMatrix(int[][] mat) {

        int rowLen = mat.length;
        int colLen = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[rowLen][colLen];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[][] result = new int[mat.length][mat[0].length];

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int[] coordinates = queue.poll();
                int row = coordinates[0];
                int col = coordinates[1];
                int dist = coordinates[2];

                result[row][col] = dist;

                for (int i = 0; i < 4; i++) {

                    int newRow = row + rowDir[i];
                    int newCol = col + colDir[i];

                    if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen &&
                            visited[newRow][newCol] == false) {
                        queue.add(new int[]{newRow, newCol, dist + 1});
                        visited[newRow][newCol] = true;
                    }

                }

            }

        }

        return result;

    }
}
