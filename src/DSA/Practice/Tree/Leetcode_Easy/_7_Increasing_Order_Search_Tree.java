package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _7_Increasing_Order_Search_Tree {

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> newNode = new ArrayList<>();
        inorder(root, newNode);
        TreeNode newTree = new TreeNode(newNode.get(0));
        TreeNode nextNode = newTree;
        for (int i = 1; i < newNode.size(); i++) {
            nextNode.left = null;
            nextNode.right = new TreeNode(newNode.get(i));
            nextNode = nextNode.right;
        }
        return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> newNode) {
        if (root == null) {
            return;
        }

        inorder(root.left, newNode);
        newNode.add(root.val);
        inorder(root.right, newNode);
    }

    public static void main(String[] args) {

    }
}
