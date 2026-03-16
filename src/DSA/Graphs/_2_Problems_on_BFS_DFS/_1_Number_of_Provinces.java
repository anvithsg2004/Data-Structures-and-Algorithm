package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _1_Number_of_Provinces {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    adj.get(i).add(j);
                    adj.get(j).add(i);

                }

            }
        }

        int count = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }

        }

        return count;

    }

    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;

        for (Integer neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }

        }

    }
}
