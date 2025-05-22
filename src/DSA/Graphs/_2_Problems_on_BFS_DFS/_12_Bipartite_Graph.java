package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class _12_Bipartite_Graph {

    public boolean isBipartite(int[][] graph) {
        // Convert an input adjacency list to ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        // Initialize an adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        // Initialize a color array with -1 (unvisited)
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Check each component
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        // Assign the color to the node
        color[node] = col;

        // Check neighbors
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                // Assign opposite color to the neighbor
                if (!dfs(neighbor, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                // If the neighbor has the same color, the graph is not bipartite
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _12_Bipartite_Graph obj = new _12_Bipartite_Graph();

        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println(obj.isBipartite(graph)); // Output: true
    }
}
