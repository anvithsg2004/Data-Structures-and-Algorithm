package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.ArrayList;

public class _5_Detect_Cycle_DFS {

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, visited, adj) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = 1;

        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, visited, adj)) {
                    return true;
                }
            } else if (adjacentNode != parent) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
