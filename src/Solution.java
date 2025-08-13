import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public boolean isCycle(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, -1));

        visited[0] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.i;
            int parent = pair.j;

            for (int adjacentNode : adj.get(node)) {

                if (visited[adjacentNode] == false) {
                    visited[adjacentNode] = true;
                    queue.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true;
                }

            }

        }

        return false;

    }
}
