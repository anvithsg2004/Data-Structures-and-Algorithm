package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.*;

public class _4_Union_by_Rank {

    int[] parent;
    int[] rank;

    public _4_Union_by_Rank(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

    }

    public int find(int node) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);

    }

    public void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

    }

}
