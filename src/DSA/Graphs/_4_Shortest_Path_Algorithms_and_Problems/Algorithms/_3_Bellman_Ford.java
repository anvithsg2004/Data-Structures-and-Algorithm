package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems.Algorithms;

import java.util.Arrays;

public class _3_Bellman_Ford {

    public int[] bellmanFord(int V, int[][] edges, int src) {

        int n = V;

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e8);

        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < n - 1; i++) {

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }

}
