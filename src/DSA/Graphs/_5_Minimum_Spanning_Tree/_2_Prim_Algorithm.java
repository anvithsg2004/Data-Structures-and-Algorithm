package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _2_Prim_Algorithm {

    public static int spanningTree(int v, int e, List<List<int[]>> adj) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair(0, 0));

        boolean[] visited = new boolean[v];

        //This is to count the sum of all the weights of the Minimum Spanning Tree.
        int sum = 0;

        while (!pq.isEmpty()) {

            int node = pq.peek().node;
            int weight = pq.peek().weight;
            pq.remove();

            if (visited[node] == true) {
                continue;
            }

            visited[node] = true;
            sum = sum + weight;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];

                if (visited[adjNode] == false) {
                    pq.add(new Pair(adjNode, edW));
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {

    }
}
