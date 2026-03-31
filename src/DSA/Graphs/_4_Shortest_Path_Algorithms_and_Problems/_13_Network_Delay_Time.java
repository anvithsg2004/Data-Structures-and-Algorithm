package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _13_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int weight = time[2];

            adj.get(u).add(new int[]{v, weight});

        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{k, 0});
        dist[k] = 0;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            for (int[] neighbour : adj.get(node)) {

                int neighbourNode = neighbour[0];
                int neighbourWeight = neighbour[1];

                if (neighbourWeight + weight < dist[neighbourNode]) {

                    dist[neighbourNode] = neighbourWeight + weight;
                    pq.add(new int[]{neighbourNode, neighbourWeight + weight});

                }

            }

        }

        // 🔥 Find answer
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // unreachable node
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;

    }
}
