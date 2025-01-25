package DSA.Graphs._1_Learning;

import java.util.ArrayList;

public class _5_Depth_First_Search {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

        //Marking the current node as visited.
        vis[node] = true;
        ls.add(node);

        //getting neighbour nodes
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }

    }

    public static void main(String[] args) {

    }
}
