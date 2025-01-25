package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.ArrayList;

public class _13_Detect_cycle_directed_graph {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {

        int[] visited = new int[v];
        int[] pathVisited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (dfsCheck(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {

        visited[node] = 1;
        pathVisited[node] = 1;

        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                if (dfsCheck(it, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[it] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}
