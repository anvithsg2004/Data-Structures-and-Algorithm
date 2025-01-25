package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _1_Shortest_Path_Undirected_Graph_with_Unit_Weights {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize an adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to an adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // For undirected graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);

            // For directed graph, use only:
            // adjList.get(u).add(v);
        }

        //Create a distance array to maintain to distance from source.
        int[] distance = new int[n];

        //Fill it with the highest number such as infinity.
        Arrays.fill(distance, (int) 1e9);

        //Make the source node as 0 as the distance from the source node to source node is 0.
        distance[src] = 0;

        //Just BFS traversal.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {

            int node = queue.peek();
            queue.remove();

            for (int it : adjList.get(node)) {
                //Now here is the main point.
                //If the new distance is lesser than the previous distance.
                if (distance[node] + 1 < distance[it]) {
                    distance[it] = distance[node] + 1;
                    queue.add(it);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }

        return distance;

    }

    public static void main(String[] args) {

    }
}
