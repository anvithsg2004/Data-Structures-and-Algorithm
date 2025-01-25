package DSA.Graphs._1_Learning;

import java.util.ArrayList;
import java.util.List;

class EdgeListToAdjList {
    public static List<List<Integer>> convertToAdjList(int[][] edges, int n) {
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

        return adjList;
    }
}

class WeightedEdgeListToAdjList {
    public static List<List<int[]>> convertToAdjList(int[][] edges, int n) {
        List<List<int[]>> adjList = new ArrayList<>();

        // Initialize an adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to an adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // For undirected graph
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});

            // For directed graph, use only:
            // adjList.get(u).add(new int[]{v, w});
        }

        return adjList;
    }
}

public class _8_Edge_List_to_List {
    public static void main(String[] args) {

    }
}
