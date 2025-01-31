package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.List;

//Formula to find out the Node ID (row, col) = (row * m) + col

public class _10_Number_of_island_II {

    public boolean isValid(int adjR, int adjC, int n, int m) {
        return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        _4_Union_by_Rank ds = new _4_Union_by_Rank(n * m);
        boolean[][] visited = new boolean[n][m];
        int countComponents = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (visited[row][col] == true) {
                ans.add(countComponents);
                continue;
            }
            visited[row][col] = true;
            countComponents++;
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjR = row + dr[ind];
                int adjC = col + dc[ind];

                if (isValid(adjR, adjC, n, m)) {
                    // If the neighbor is visited, then merge
                    if (visited[adjR][adjC] == true) {
                        int nodeID = (row * m) + col;
                        int adjNodeNo = (adjR * m) + adjC;
                        if (ds.findPar(nodeID) != ds.findPar(adjNodeNo)) {
                            ds.unionByRank(nodeID, adjNodeNo);
                            countComponents--;
                        }
                    }
                }
            }
            ans.add(countComponents);
        }
        return ans;
    }
}
