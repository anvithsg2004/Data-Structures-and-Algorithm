package DSA.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class _7_Boundary_Traversal {

    public static List<Integer> printBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (!isLeaf(root)) {
            res.add(root.val);
        }

        leftBound(root, res);
        addLeaves(root, res);
        rightBound(root, res);

        return res;
    }

    public static void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
        }

        if (root.left != null) {
            addLeaves(root.left, res);
        }

        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    public static void leftBound(TreeNode root, List<Integer> res) {

        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void rightBound(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;

        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
