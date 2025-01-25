package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

//In this problem, we use two Arrays.
//One is Parent and distance.
//Parent stores from which node you have come to this index.
//Distance stores how much distance traveled from the source to here.
//For example, this is the parent array and distance array.
//(1) -2-> (2)
//parent :-   _(1) 1(2) _(3) _(4) _(5)
//distance :-  0   2    __   __   __

//Here means is that distance is 2 to reach node 2 and came from node 1.

import java.util.*;

class Pair3 {
    int node;
    int distance;

    public Pair3(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class _4_Shortest_Path_Dijkstras_Algorithm {

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {

        ArrayList<ArrayList<Pair3>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to an adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair3(v, w));
            adj.get(v).add(new Pair3(u, w));

        }

        // Initialize priority queue with correct node and comparator
        PriorityQueue<Pair3> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair3(1, 0)); // node=1, distance=0
        int[] parent = new int[n + 1];
        int[] distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            distance[i] = (int) 1e9;
            parent[i] = i;
        }

        distance[1] = 0;

        while (!pq.isEmpty()) {
            Pair3 it = pq.peek();
            int node = it.node;
            int dist = it.distance;
            pq.remove();

            for (Pair3 iter : adj.get(node)) {

                int adjNode = iter.node;
                int edW = iter.distance;

                if (dist + edW < distance[adjNode]) {
                    distance[adjNode] = dist + edW;
                    pq.add(new Pair3(adjNode, distance[adjNode]));  // ✅ Correct parameter order
                    parent[adjNode] = node;
                }

            }

        }

        List<Integer> path = new ArrayList<>();

        //If you cannot reach the destination, then return -1.
        if (distance[n] == (int) 1e9) {
            return path;
        }

        //Now we will start from the n.
        //This means we come from the back as we traverse from the back and add it to the path List.

        int node = n;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {

    }
}
