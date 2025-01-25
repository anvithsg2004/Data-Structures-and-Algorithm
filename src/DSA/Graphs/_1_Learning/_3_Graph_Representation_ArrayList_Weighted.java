package DSA.Graphs._1_Learning;

import java.util.ArrayList;

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _3_Graph_Representation_ArrayList_Weighted {
    public static void main(String[] args) {

        int n = 3; // Number of nodes
        int m = 3; // Number of edges

        // Adjacency list to store weighted graph
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges with weight.
        // Edge 1 -- 2 with weight 4
        adjList.get(1).add(new Pair(2, 4));
        adjList.get(2).add(new Pair(1, 4));

        // Edge 2 -- 3 with weight 6
        adjList.get(2).add(new Pair(3, 6));
        adjList.get(3).add(new Pair(2, 6));

        // Edge 1 -- 3 with weight 5
        adjList.get(1).add(new Pair(3, 5));
        adjList.get(3).add(new Pair(1, 5));

    }
}
