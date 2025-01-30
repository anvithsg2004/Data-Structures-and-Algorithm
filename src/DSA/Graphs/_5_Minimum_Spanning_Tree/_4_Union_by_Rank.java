package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.List;

public class _4_Union_by_Rank {

    // Two lists to maintain parent and rank information for each node.
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    // Constructor initializes the Disjoint Set for `n` nodes.
    public _4_Union_by_Rank(int n) {
        for (int i = 0; i <= n; i++) {
            // Initially, every node has rank 0 (as it's a single node tree).
            rank.add(0);
            // Every node is its own parent at the start (self-loop).
            parent.add(i);
        }
    }

    // Function to find the ultimate parent of a node (with path compression).
    public int findPar(int node) {
        // If the node is its own parent, it is the ultimate parent.
        if (node == parent.get(node)) {
            return node;
        }

        // Recursively find the ultimate parent and perform path compression
        // (update the parent of the current node to point directly to the ultimate parent).
        int ultimateParent = findPar(parent.get(node));
        parent.set(node, ultimateParent); // Path compression step.
        return parent.get(node); // Return the updated ultimate parent.
    }

    // Function to perform union of two sets based on their ranks.
    public void unionByRank(int u, int v) {
        // Find the ultimate parents of both nodes.
        int ultimateParent_u = findPar(u);
        int ultimateParent_v = findPar(v);

        // If both nodes already belong to the same set, do nothing.
        if (ultimateParent_u == ultimateParent_v) {
            return;
        }

        // Compare the ranks of the ultimate parents:
        // Attach the tree with smaller rank under the tree with larger rank.
        if (rank.get(ultimateParent_u) < rank.get(ultimateParent_v)) {
            // If `u`'s tree rank is smaller, attach it under `v`'s tree.
            parent.set(ultimateParent_u, ultimateParent_v);
        } else if (rank.get(ultimateParent_v) < rank.get(ultimateParent_u)) {
            // If `v`'s tree rank is smaller, attach it under `u`'s tree.
            parent.set(ultimateParent_v, ultimateParent_u);
        } else {
            // If both trees have the same rank, attach one under the other
            // (e.g., attach `v`'s tree under `u`) and increase the rank of the new root.
            // ultimateParent_v a child of ultimateParent_u
            parent.set(ultimateParent_v, ultimateParent_u);
            int rankU = rank.get(ultimateParent_u);
            rank.set(ultimateParent_u, rankU + 1); // Increment rank as we increased the tree height.
        }
    }
}
