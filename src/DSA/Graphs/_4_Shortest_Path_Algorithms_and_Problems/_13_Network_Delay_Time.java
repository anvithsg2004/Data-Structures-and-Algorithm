package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair9 {
    int v;
    int weight;

    public Pair9(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

public class _13_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize an adjacency list for n + 1 nodes (1-based indexing)
        ArrayList<ArrayList<Pair9>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new Pair9(v, wt));
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair9> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair9(k, 0));

        // Distance array to store shortest distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair9 current = pq.poll();
            int node = current.v;
            int weight = current.weight;

            // Skip if this path is not optimal
            if (weight > dist[node]) {
                continue;
            }

            // Traverse all neighbors
            for (Pair9 it : adj.get(node)) {
                int nextNode = it.v;
                int edgeWeight = it.weight;

                // Relaxation step
                if (weight + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = weight + edgeWeight;
                    pq.add(new Pair9(nextNode, dist[nextNode])); // Corrected
                }
            }
        }

        // Find the maximum time to reach any node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
