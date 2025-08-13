package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair6 {
    int node;
    long weight;

    public Pair6(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _8_Number_of_Ways_to_Arrive_at_Destination {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair6>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new Pair6(v, time));
            adj.get(v).add(new Pair6(u, time));
        }

        PriorityQueue<Pair6> priorityQueue = new PriorityQueue<>(
                (p1, p2) -> Long.compare(p1.weight, p2.weight)
        );
        priorityQueue.add(new Pair6(0, 0));

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        int mod = (int) (1e9 + 7);

        while (!priorityQueue.isEmpty()) {

            int node = priorityQueue.peek().node;
            long dis = priorityQueue.peek().weight;
            priorityQueue.remove();

            if (dis > dist[node]) {
                continue;
            }

            for (Pair6 it : adj.get(node)) {
                int adjNode = it.node;
                long edW = it.weight;

                //This is when If I get a new short distance
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    priorityQueue.add(new Pair6(adjNode, dis + edW));
                    ways[adjNode] = ways[node];
                } else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }

        }

        return ways[n - 1] % mod;

    }
}
