package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems.Algorithms;

import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {

        this.node = node;
        this.distance = distance;

    }
}

public class _2_Dijkstra {

    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {

        int n = V;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.distance;

            for (Pair p : adj.get(node)) {

                int neighbourNode = p.node;
                int neighbourDistance = p.distance;

                if (distance + neighbourDistance < dist[node]) {

                    dist[neighbourNode] = distance + neighbourDistance;
                    pq.add(new Pair(neighbourNode, dist[neighbourNode]));

                }

            }

        }

        return dist;

    }

}
