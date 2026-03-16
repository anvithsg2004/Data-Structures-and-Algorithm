package DSA.Graphs.Cycle;

import java.util.*;

public class Directed_Graph {
    public boolean isCyclic(int V, int[][] edges) {

        int n = V;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);

        }

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            count++;

            for (Integer neighbour : adj.get(node)) {

                inDegree[neighbour]--;

                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }

            }

        }

        return count != n;

    }
}
