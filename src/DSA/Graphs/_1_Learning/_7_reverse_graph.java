package DSA.Graphs._1_Learning;

import java.util.ArrayList;

public class _7_reverse_graph {

    public ArrayList<ArrayList<Integer>> reverseEdges(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a new adjacency list for the reversed graph
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reversedAdj.add(new ArrayList<>());
        }

        // Reverse edges
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                reversedAdj.get(v).add(u); // Reverse edge from u -> v to v -> u
            }
        }

        return reversedAdj;
    }

    public static void main(String[] args) {

    }
}
