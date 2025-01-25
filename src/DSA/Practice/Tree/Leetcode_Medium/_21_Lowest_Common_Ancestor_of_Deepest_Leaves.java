package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Same for the Smallest Subtree with all the Deepest Nodes

public class _21_Lowest_Common_Ancestor_of_Deepest_Leaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Get the deepest leaves using level order traversal
        List<List<Integer>> result = fun(root);

        // Get the last level of leaves
        List<Integer> deepestLeaves = result.get(result.size() - 1);

        // Find the LCA of the deepest leaves
        TreeNode lca = null;

        for (int val : deepestLeaves) {
            TreeNode currentNode = findNode(root, val);
            if (lca == null) {
                lca = currentNode; // Initialize LCA with the first node
            } else {
                lca = lowestCommonAncestor(root, lca, currentNode); // Update LCA
            }
        }

        return lca; // Return the LCA of the deepest leaves
    }

    public static List<List<Integer>> fun(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    // Helper method to find a node by its value
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = findNode(root.left, val);
        if (left != null) {
            return left;
        }

        return findNode(root.right, val);
    }
}
