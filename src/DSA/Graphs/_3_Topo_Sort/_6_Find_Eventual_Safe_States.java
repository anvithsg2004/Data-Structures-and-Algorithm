package DSA.Graphs._3_Topo_Sort;

import java.util.*;

public class _6_Find_Eventual_Safe_States {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        // Create a reverse adjacency list
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        int[] inDegree = new int[v];

        // Populate reverse adjacency list and calculate in-degrees
        for (int u = 0; u < v; u++) {
            for (int neighbor : graph[u]) {
                reverseAdj.get(neighbor).add(u);
                inDegree[u]++;
            }
        }

        // Queue to store nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Kahn's algorithm to find all safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbor : reverseAdj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Sort the result
        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {

    }
}
