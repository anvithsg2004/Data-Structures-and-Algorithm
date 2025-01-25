package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class _2_Shortest_Path_in_Directed_Acyclic_Graph {

    public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).node;
            if (visited[v] == false) {
                topoSort(v, adj, visited, stack);
            }
        }

        stack.add(node);
    }

    public int[] shortestPath(int n, int m, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        //We create a graph first in the form of an adjacency list.

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                topoSort(i, adj, visited, stack);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        dist[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).weight;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
