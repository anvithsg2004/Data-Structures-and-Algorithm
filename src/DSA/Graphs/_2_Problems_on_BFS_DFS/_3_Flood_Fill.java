package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _3_Flood_Fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rowLength = image.length;
        int colLength = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        int initialColor = image[sr][sc];

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        image[sr][sc] = color;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int[] coordinates = queue.poll();

                int row = coordinates[0];
                int col = coordinates[1];

                for (int i = 0; i < 4; i++) {

                    int newRow = row + rowDir[i];
                    int newCol = col + colDir[i];

                    if (newRow >= 0 && newRow < rowLength && newCol >= 0 &&
                            newCol < colLength && image[newRow][newCol] == initialColor) {

                        image[newRow][newCol] = color;
                        queue.add(new int[]{newRow, newCol});

                    }

                }

            }

        }

        return image;

    }
}
