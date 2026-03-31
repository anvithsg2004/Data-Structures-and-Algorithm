package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _8_Number_of_Ways_to_Arrive_at_Destination {

    public int countPaths(int n, int[][] roads) {

        int MOD = (int) 1e9 + 7;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] count = new int[n];

        dist[0] = 0;
        count[0] = 1;

        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();
            int node = (int) curr[0];
            long dis = curr[1];

            for (int[] nei : adj.get(node)) {

                int next = nei[0];
                long newDist = dis + nei[1];

                if (newDist < dist[next]) {

                    dist[next] = newDist;
                    count[next] = count[node];
                    pq.add(new long[]{next, newDist});

                } else if (newDist == dist[next]) {
                    count[next] = (count[node] + count[next]) % MOD;
                }
            }

        }

        return count[n - 1];

    }
}
