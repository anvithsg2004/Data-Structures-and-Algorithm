package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair2 {
    int node;
    int parent;

    public Pair2(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class _4_Detect_Cycle_BFS {

    public static boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[src] = true;
        Queue<Pair2> queue = new LinkedList<>();
        queue.add(new Pair2(src, -1));

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int parent = queue.peek().parent;
            queue.remove();

            for (int adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    queue.add(new Pair2(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
