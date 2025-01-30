package DSA.Practice.Graphs.Medium;

import java.util.ArrayList;
import java.util.List;

class unionByRank {
    public List<Integer> rank = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();

    public unionByRank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public boolean union(int u, int v) {
        int ultimateU = findParent(u);
        int ultimateV = findParent(v);

        if (ultimateU != ultimateV) {

            if (rank.get(ultimateU) < rank.get(ultimateV)) {
                parent.set(ultimateU, ultimateV);
            } else if (rank.get(ultimateU) > rank.get(ultimateV)) {
                parent.set(ultimateV, ultimateU);
            } else {
                parent.set(ultimateV, ultimateU);
                int rankU = rank.get(ultimateU);
                rank.set(ultimateU, rankU + 1);
            }

            return true;
        }

        return false;
    }
}

public class _3_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        unionByRank unionByRank = new unionByRank(size);

        for (int[] edge : edges) {
            if (!unionByRank.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[]{};
    }
}
