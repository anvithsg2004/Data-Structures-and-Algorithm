package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

//Important Points :-
//1) Helps you to detect negative Cycle.
//2) Handles both positive and negative edge weights.
//3) Applicable only for Directed Graphs but can be convertible it to apply for Undirected Graph also.
//Example :- (1) -5-> (2) to (1) -5-><-5- (2)

//Algorithm :-
//1) Relax all the edges N - 1 Sequentially.
//Here the relaxation means updating the distance array with the new shorter distance.
//Why N - 1?
//Because For every iteration, we will be getting the values for each number from 0 to N -1.
//2) How to detect the negative cycle?
//When I do the N - 1 iteration, I will be getting all the distances.
//Then also, If any distance value gets reduced, then there is a negative cycle.

import java.util.Arrays;

class Pair7 {
    int node;
    int weight;

    public Pair7(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _10_Bellman_Ford_Algorithm {

    public static int[] bellmanFord(int n, int[][] edges, int src) {
        // Initialize the distance array with large values (infinity)
        int[] dist = new int[n];
        // A large value to represent infinity
        Arrays.fill(dist, (int) 1e8);

        // Set the distance to the source node as 0
        dist[src] = 0;

        // Relax all edges (n - 1) times
        for (int i = 1; i <= n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // If the current path offers a shorter distance, update it
                if (dist[u] != (int) 1e8 && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }

                // Relax the edge (v -> u) because the graph is undirected
                // If (dist[v] != (int) 1e8 && dist[v] + weight < dist[u]) {
                //    dist[u] = dist[v] + weight;
                //}
            }
        }

        //Last Complete Iteration.
        // Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // If we can still relax an edge, there's a negative cycle
            if (dist[u] != (int) 1e8 && dist[u] + weight < dist[v]) {
                return new int[]{-1}; // Return an empty array to indicate an error
            }

            //This is for Undirected Graph
            // If we can still relax an edge, there's a negative cycle
            // If ((dist[u] != (int) 1e8 && dist[u] + weight < dist[v]) ||
            //        (dist[v] != (int) 1e8 && dist[v] + weight < dist[u])) {
            //    return new int[]{-1}; // Return {-1} to indicate a negative cycle
            //}
        }

        // Return the shortest distances from the source node
        return dist;
    }

    public static void main(String[] args) {

    }
}
