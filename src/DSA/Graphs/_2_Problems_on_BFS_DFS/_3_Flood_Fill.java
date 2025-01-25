package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair1 {
    int row;
    int column;

    public Pair1(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class _3_Flood_Fill {

    //Striver's Code
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, color, drow, dcol, initialColor);
        return ans;
    }

    public void dfs(int row, int column, int[][] ans, int[][] image, int newColor, int[] drow, int[] dcol, int initialColor) {

        ans[row][column] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = column + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor && ans[nrow][ncol] != newColor) {
                dfs(row, column, ans, image, newColor, drow, dcol, initialColor);
            }

        }

    }

    //My Code
    //BFS Method
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        //color is the target pixel to color.

        //Get the color to be changed next by the target.
        int source = image[sr][sc];

        //Change the color.
        image[sr][sc] = color;

        // If the source pixel is already the target color, no need to proceed
        if (source == color) {
            return image;
        }

        //Add the color to queue and start the from there.
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(sr, sc));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().column;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                //If the image[nrow][ncol] == source then change to the target color.
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == source) {
                    image[nrow][ncol] = color;
                    //Add that to the queue.
                    queue.add(new Pair1(nrow, ncol));
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
//        int[][] image = {
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}
//        };

        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };

        int sr = 0, sc = 0, color = 0;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Modified Image:");
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
