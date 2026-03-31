package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _12_Bipartite_Graph {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int start, int currentColor, int[] color, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        color[start] = currentColor;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbour : adj.get(node)) {

                if (color[neighbour] == -1) {

                    // Assign a color
                    color[neighbour] = 1 - color[node];
                    queue.add(neighbour);

                } else if (color[neighbour] == color[node]) {

                    // Same Color
                    return false;

                }

            }

        }

        return true;
    }
}
