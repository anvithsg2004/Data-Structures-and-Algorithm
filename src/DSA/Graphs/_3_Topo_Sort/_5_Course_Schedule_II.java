package DSA.Graphs._3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _5_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int n = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {

            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);

        }

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

        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Integer node = queue.poll();
                result.add(node);

                for (Integer neighbour : adj.get(node)) {

                    inDegree[neighbour]--;

                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }

                }

            }

        }

        if (result.size() != n) {
            return new int[0];
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;

    }
}
