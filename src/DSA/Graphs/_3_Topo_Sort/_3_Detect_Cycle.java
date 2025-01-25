package DSA.Graphs._3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _3_Detect_Cycle {

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

    public static void main(String[] args) {

    }
}
