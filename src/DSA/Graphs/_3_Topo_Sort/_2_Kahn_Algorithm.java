package DSA.Graphs._3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _2_Kahn_Algorithm {

    //It is just BFS version of Topo Sort

    //Algorithm :-
    //1) Maintain an In degree Array
    //2) Remove the index which has 0 value and reduce the other to which they have connected.
    //3) As I take out, put it in a Queue and at last remove and return it.
    //4) That's the answer(Topo Sort)

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        int n = V;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int node = queue.poll();
                result.add(node);

                for (Integer neighbour : adj.get(node)) {

                    inDegree[neighbour]--;

                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }

                }

            }

        }

        return result;

    }
}
