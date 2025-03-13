package DSA.Tree.Binary_Tree;

import java.util.*;

public class _18_Minimum_time_taken_to_BURN_the_Binary_Tree_from_a_Node {

    // Mark parent nodes for each node
    public static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current); // Mark left child's parent
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current); // Mark right child's parent
                queue.offer(current.right);
            }
        }
    }

    // Method to find the target node
    public static TreeNode findTarget(TreeNode root, int tar) {
        if (root == null) {
            return null;
        }
        if (root.val == tar) {
            return root;
        }
        TreeNode left = findTarget(root.left, tar);
        if (left != null) {
            return left;
        }
        return findTarget(root.right, tar);
    }

    public static int minTime(TreeNode root, int tar) {

        // Step 1: Mark all parent nodes
        Map<TreeNode, TreeNode> parent_Tree = new HashMap<>();
        markParents(root, parent_Tree);

        // Step 2: Find the target node in the tree
        TreeNode target = findTarget(root, tar);
        if (target == null) return 0; // Target not found, return 0 time

        // Step 3: Perform BFS to burn the tree
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target); // Start from the target node
        visited.put(target, true);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false; // To check if we need to increment time

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check left child
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                    burned = true;
                }

                // Check right child
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                    burned = true;
                }

                // Check parent node
                if (parent_Tree.get(current) != null && visited.get(parent_Tree.get(current)) == null) {
                    queue.offer(parent_Tree.get(current));
                    visited.put(parent_Tree.get(current), true);
                    burned = true;
                }
            }

            // Only increment time if any new nodes were burned
            if (burned) {
                time++;
            }
        }

        return time; // Return the total time taken to burn the tree
    }
}
