package DSA.Practice.Graphs.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair2 {
    int node;
    int distance;

    public Pair2(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}


//Both are correct
public class _3_Find_if_Path_Exists_in_Graph {

    public boolean validPath2(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Pair2>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair2(v, 1));
            adj.get(v).add(new Pair2(u, 1));

        }

        //Min Heap
        PriorityQueue<Pair2> priorityQueue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        priorityQueue.add(new Pair2(source, 0));

        int v = adj.size();

        ArrayList<Integer> dist = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            dist.add((int) 1e9);
        }

        dist.add(source, 0);

        while (!priorityQueue.isEmpty()) {

            int node = priorityQueue.peek().node;
            int distance = priorityQueue.peek().distance;
            priorityQueue.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {

                int edgeWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;

                if (distance + edgeWeight < dist.get(adjNode)) {

                    dist.set(adjNode, distance + edgeWeight);
                    priorityQueue.add(new Pair2(adjNode, dist.get(adjNode)));

                }

            }

        }

        if (dist.get(destination) != (int) 1e9) {
            return true;
        } else {
            return false;
        }

    }

    //This is a correct solution but time limit exceeds.
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int[][] matrix = new int[n][n];

        for (int[] ints : matrix) {
            Arrays.fill(ints, -1);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != (int) 1e9 && matrix[k][j] != (int) 1e9) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

        return matrix[source][destination] != -1 && matrix[destination][source] != -1;

    }

    public static void main(String[] args) {

    }
}
