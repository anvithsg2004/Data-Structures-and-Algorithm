package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

class Pair2 {
    int i;
    int j;

    public Pair2(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class _4_Detect_Cycle_BFS {
    public boolean isCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Build undirected graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Check all components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsHasCycle(i, visited, adj)) return true;
            }
        }
        return false;
    }

    private boolean bfsHasCycle(int src, boolean[] visited, List<List<Integer>> adj) {
        Queue<Pair2> queue = new LinkedList<>();
        queue.add(new Pair2(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()) {
            Pair2 pair = queue.poll();
            int node = pair.i;
            int parent = pair.j;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair2(neighbor, node));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
