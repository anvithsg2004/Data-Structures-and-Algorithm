package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _19_Lowest_Common_Ancestor_in_Binary_Tree {

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


    //Brute Force Approach
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) { // Rename here
        ArrayList<Integer> first = new ArrayList<>();
        int tar = p.val;
        findRootToNode(root, tar, first);

        ArrayList<Integer> second = new ArrayList<>();
        int tar2 = q.val;
        findRootToNode(root, tar2, second);

        TreeNode lca = root; // Start with the root as the lowest common ancestor
        int minSize = Math.min(first.size(), second.size()); // Get the minimum size of both paths

        for (int i = 0; i < minSize; i++) {
            if (first.get(i).equals(second.get(i))) {
                lca = new TreeNode(first.get(i)); // Update the LCA to the current node
            } else {
                break; // Break the loop as soon as the nodes diverge
            }
        }

        return lca; // Return the found LCA node
    }

    public void help(TreeNode root, ArrayList<Integer> currPaths, ArrayList<ArrayList<Integer>> gotPath, int target) {

        if (root == null) {
            return;
        }

        currPaths.add(root.val);

        if (root.val == target) {
            gotPath.add(currPaths);
            return;
        }

        currPaths.remove(currPaths.size() - 1);

    }

    public boolean findRootToNode(TreeNode root, int target, ArrayList<Integer> arrayList) {
        if (root == null) {
            return false;
        }

        // Add current node to the path
        arrayList.add(root.val);

        // Check if current node is the target
        if (root.val == target) {
            return true;
        }

        // Recur for left and right subtrees
        if (findRootToNode(root.left, target, arrayList) || findRootToNode(root.right, target, arrayList)) {
            return true;
        }

        // If target not found, remove the current node from the path
        arrayList.remove(arrayList.size() - 1);
        return false;
    }

    public static void main(String[] args) {

    }
}
