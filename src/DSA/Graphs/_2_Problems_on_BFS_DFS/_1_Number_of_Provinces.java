package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.ArrayList;

public class _1_Number_of_Provinces {

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;

        for (Integer it : adj.get(node)) {
            if (visited[it] == false) {
                dfs(it, visited, adj);
            }
        }

    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length; // Number of vertices
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize an adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Convert adjacency matrix to an adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) { // Exclude self-loops
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;

    }
}
