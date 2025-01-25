package DSA.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_if_Path_Exists_in_Graph {

    //This is my approach
    public boolean validPath(int V, int[][] graph, int source, int destination) {
        int[][] dist = new int[V][V];

        // Initialize the solution matrix with large values and direct connections
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = (int) (1e9);
                }
            }
        }

        // Populate the graph with given edges
        for (int[] edge : graph) {
            dist[edge[0]][edge[1]] = 1;
            dist[edge[1]][edge[0]] = 1;
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Check if there is a path from source to destination
        return dist[source][destination] != (int) (1e9);
    }

        //ChatGPT Approach
        public boolean validPath_2(int V, int[][] edges, int source, int destination) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (node == destination) {
                    return true;
                }
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            return false;
        }


    public static void main(String[] args) {

    }
}
