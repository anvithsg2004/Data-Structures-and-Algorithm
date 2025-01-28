package DSA.Practice.Graphs.Medium;

import java.util.ArrayList;

public class _2_Maximum_Number_of_Fish_in_a_Grid {
    public int findMaxFish(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                adjList.get(i).add(j, grid[i][j]);
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[n][m];
                    maxi = Math.max(maxi, dfs(drow, dcol, adjList, visited, i, j));
                }
            }
        }

        if (maxi == Integer.MIN_VALUE) {
            return 0;
        }

        return maxi;

    }

    public int dfs(int[] drow, int[] dcol, ArrayList<ArrayList<Integer>> adjList, boolean[][] visited, int newRow, int newCol) {
        int n = adjList.size();
        int m = adjList.get(0).size();

        // Mark the current cell as visited
        visited[newRow][newCol] = true;

        // Initialize a sum with the current cell's value if it's non-zero
        int sum = 0;
        if (adjList.get(newRow).get(newCol) != 0) {
            sum += adjList.get(newRow).get(newCol);
        }

        // Traverse all four directions
        for (int i = 0; i < 4; i++) {
            int nextRow = newRow + drow[i];
            int nextCol = newCol + dcol[i];

            // Check if the next cell is within bounds, not visited, and non-zero
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && adjList.get(nextRow).get(nextCol) != 0) {
                // Recursively call DFS for the next cell and add its result to the sum
                sum += dfs(drow, dcol, adjList, visited, nextRow, nextCol);
            }
        }

        // Return the total sum of non-zero elements in the current connected component
        return sum;
    }
}
