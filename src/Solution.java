import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inOrder(root);

        //Case 1: Non-Adjacent Nodes Swapped
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }//Case 2: Adjacent Nodes Swapped
        else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }

    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null || (root.val < prev.val)) {

            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }

        }

        prev = root;

        inOrder(root.right);

    }
}
