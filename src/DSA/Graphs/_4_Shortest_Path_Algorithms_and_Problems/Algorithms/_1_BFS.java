package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems.Algorithms;

import java.util.*;

public class _1_BFS {

    public int[] shortestPath(int V, ArrayList<ArrayList<Integer>> adj, int src) {

        int n = V;

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (Integer neighbour : adj.get(node)) {

                if (distance[node] + 1 < distance[neighbour]) {

                    distance[neighbour] = distance[node] + 1;
                    queue.add(neighbour);

                }

            }

        }

        return distance;

    }

}
