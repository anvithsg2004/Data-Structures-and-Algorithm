package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.HashSet;

public class _11_Making_a_Large_Island {

    public boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        _5_Union_by_Size ds = new _5_Union_by_Size(n * n);

        // Step 1 - Check if the grid is fully filled with 1's
        boolean allOnes = true;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    allOnes = false;
                    break;
                }
            }
            if (!allOnes) break;
        }
        if (allOnes) {
            return n * n;  // If the grid is already fully filled with 1's, return n*n.
        }

        // Step 2 - Perform union of 1's connected horizontally or vertically.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                for (int i = 0; i < 4; i++) {
                    int newR = row + dr[i];
                    int newC = col + dc[i];
                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int nodeNo = (row * n) + col;
                        int adjNodeNo = (newR * n) + newC;
                        ds.unionByRank(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Step 3 - You have calculated the rank of the uncollimated Parent.
        int maxi = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                HashSet<Integer> component = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int newR = row + dr[i];
                    int newC = col + dc[i];
                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        component.add(ds.findPar((newR * n) + newC));
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : component) {
                    sizeTotal = sizeTotal + ds.size.get(parents);
                }
                maxi = Math.max(maxi, sizeTotal + 1);
            }
        }

        return maxi;
    }
}
