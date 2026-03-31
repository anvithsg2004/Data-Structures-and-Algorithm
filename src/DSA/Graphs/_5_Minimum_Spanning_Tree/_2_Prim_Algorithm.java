package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.*;

class Pair {
    int node, weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _2_Prim_Algorithm {
    public static int primMST(int V, ArrayList<ArrayList<Pair>> adj) {

        int n = V;

        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.add(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            sum = sum + weight;

            for (Pair p : adj.get(node)) {

                int neighbourNode = p.node;
                int neighbourWeight = p.weight;

                if (visited[neighbourNode] == false) {
                    pq.add(new Pair(neighbourNode, neighbourWeight));
                }

            }

        }

        return sum;

    }
}
