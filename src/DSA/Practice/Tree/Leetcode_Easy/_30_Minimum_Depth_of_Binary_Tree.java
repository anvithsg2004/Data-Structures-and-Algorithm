package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _30_Minimum_Depth_of_Binary_Tree {

    //Good Solution
    public int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Recursively calculate left and right depths
        int left = depth(root.left);
        int right = depth(root.right);

        // If one subtree is null, consider only the non-null subtree
        if (root.left == null || root.right == null) {
            return 1 + Math.max(left, right);
        }

        // If both subtrees are non-null, take the minimum depth
        return 1 + Math.min(left, right);

    }

    //Post-order Traversal
    public int minDepth(TreeNode root) {

        //Root
        if (root == null) {
            return 0;
        }

        // If one of the subtrees is empty, we return the depth of the non-empty subtree
        //Left
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        //Right
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        //Root
        // If both subtrees are non-empty, return the minimum depth of both sides + 1 (for the current node)
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //My Approach
    public int minDepth1(TreeNode root) {

        int depth = Integer.MAX_VALUE;

        if (root == null) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();

        fun(root, new ArrayList<>(), allPath);

        for (ArrayList<Integer> arrayList : allPath) {
            depth = Math.min(depth, arrayList.size());
        }

        return depth;

    }

    public void fun(TreeNode root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPath) {

        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currentPath));
        } else {
            fun(root.left, currentPath, allPath);
            fun(root.right, currentPath, allPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

    }
}
