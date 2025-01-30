package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.List;

public class _5_Union_by_Size {

    // Two lists to maintain parent and size information for each node.
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor initializes the Disjoint Set for `n` nodes.
    public _5_Union_by_Size(int n) {
        for (int i = 0; i <= n; i++) {
            // Initially, every node is a single-node tree, so the size is 1.
            size.add(1);
            // Each node is its own parent at the start (self-loop).
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

    // Function to perform union of two sets based on their sizes.
    public void unionByRank(int u, int v) {
        // Find the ultimate parents of both nodes.
        int ultimateParent_u = findPar(u);
        int ultimateParent_v = findPar(v);

        // If both nodes already belong to the same set, do nothing.
        if (ultimateParent_u == ultimateParent_v) {
            return;
        }

        // Compare the sizes of the sets:
        // Attach the smaller set under the larger set to minimize tree height.
        if (size.get(ultimateParent_u) < size.get(ultimateParent_v)) {
            // If the size of `u`'s set is smaller, attach it to `v`'s set.
            parent.set(ultimateParent_u, ultimateParent_v);

            // Update the size of the set represented by `v`'s ultimate parent.
            size.set(ultimateParent_v, size.get(ultimateParent_v) + size.get(ultimateParent_u));
        } else {
            // If the size of `v`'s set is smaller, attach it to `u`'s set.
            parent.set(ultimateParent_v, ultimateParent_u);

            // Update the size of the set represented by `u`'s ultimate parent.
            size.set(ultimateParent_u, size.get(ultimateParent_u) + size.get(ultimateParent_v));
        }
    }
}
