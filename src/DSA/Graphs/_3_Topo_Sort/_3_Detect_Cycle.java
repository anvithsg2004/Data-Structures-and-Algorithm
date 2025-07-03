package DSA.Graphs._3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_Detect_Cycle {

    //Directed Graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        int index = 0;

        while (!queue.isEmpty()) {

            int node = queue.peek();
            queue.remove();
            topo.add(index++, node);

            for (int it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }

        }

        int topoSortLength = topo.size();
        int inDegreeLength = inDegree.length;

        //If topoSortLength == inDegreeLength, it means there is no cycle in the graph,
        // as all nodes are included in the topological sort.
        if (topoSortLength == inDegreeLength) {
            return false;
        }

        //If the lengths are not equal, it indicates a cycle, as some nodes couldn't be
        // added to the topological sort due to remaining incoming edges (cycle dependency).
        return true;
    }

    //Undirected Graph

    //0 — 1
    //|    |
    //3 — 2

    //All nodes have degree 2 (no leaves).
    //
    //So none are removed, and removedCount == 0.
    //
    //Return true — a cycle exists.

    //0 — 1 — 2

    //Node 0 and 2 are leaves (degree 1).
    //
    //Node 1 becomes a leaf after removing 0 or 2.
    //
    //All are removed => removedCount == n => return false.

    public boolean isCycle(int n, int[][] edges) {
        // Build graph as adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Compute degrees and populate graph
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
        }

        // Initialize queue with leaves (degree <= 1)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] removed = new boolean[n];
        int removedCount = 0;

        for (int i = 0; i < n; i++) {
            if (degrees[i] <= 1) {
                queue.add(i);
            }
        }

        // Process leaf removal
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (removed[u]) continue;

            removed[u] = true;
            removedCount++;

            for (int v : graph.get(u)) {
                if (!removed[v]) {
                    degrees[v]--;
                    if (degrees[v] <= 1) {
                        queue.add(v);
                    }
                }
            }
        }

        // Cycle exists if not all vertices were removed
        return removedCount < n;
    }

}
