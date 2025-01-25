package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Increasing_Order_Search_Tree {

    static Queue<Integer> q = new LinkedList<>();

    public static void inOreder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOreder(root.left);
        q.add(root.val);
        inOreder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inOreder(root);
        TreeNode resNode = null;
        TreeNode res = null;

        while (!q.isEmpty()) {
            if (resNode == null) {
                resNode = new TreeNode(q.remove());
                resNode.left = resNode.right = null;
                res = resNode;
            }

            if (!q.isEmpty()) {
                resNode.right = new TreeNode(q.remove());
                resNode = resNode.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
