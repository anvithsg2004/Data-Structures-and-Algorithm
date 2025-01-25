package DSA.Practice.Graphs.Medium;

import java.util.ArrayList;
import java.util.List;

public class _1_Pacific_Atlantic_Water_Flow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        // Visited matrices for Pacific and Atlantic oceans
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // List to store the result coordinates
        List<List<Integer>> coordinates = new ArrayList<>();

        for (int i = 0; i < n; i++) {  // Left edge and Right edge
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);      // Left edge for Pacific
            dfs(heights, atlantic, Integer.MIN_VALUE, i, m - 1); // Right edge for Atlantic
        }

        for (int j = 0; j < m; j++) {  // Top edge and Bottom edge
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);      // Top edge for Pacific
            dfs(heights, atlantic, Integer.MIN_VALUE, n - 1, j); // Bottom edge for Atlantic
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    coordinates.add(point);
                }
            }
        }

        return coordinates;

    }


    private void dfs(int[][] heights, boolean[][] visited, int prevHeight, int row, int col) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || visited[row][col] == true || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        // Directions for moving up, right, down, and left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Explore in all 4 directions
        for (int i = 0; i < 4; i++) {
            dfs(heights, visited, heights[row][col], row + drow[i], col + dcol[i]);
        }
    }

}
