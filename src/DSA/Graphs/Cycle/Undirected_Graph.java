package DSA.Graphs.Cycle;

import java.util.ArrayList;

public class Undirected_Graph {
    public boolean isCycle(int V, int[][] edges) {

        int n = V;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[node] = true;

        for (Integer neighbour : adj.get(node)) {

            if (visited[neighbour] == false) {

                if (dfs(neighbour, node, adj, visited)) {
                    return true;
                }

            } else if (neighbour != parent) {
                return true;
            }

        }

        return false;

    }
}
