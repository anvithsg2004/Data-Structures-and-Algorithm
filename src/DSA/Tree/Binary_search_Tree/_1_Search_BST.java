package DSA.Tree.Binary_search_Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class _1_Search_BST {

    public boolean searchBST(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }

    }

    public boolean search2(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == key) {
                return true;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return false;
    }

    public boolean search3(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.val == key) {
            return true;
        }

        return search3(root.left, key) || search3(root.right, key);
    }

    public boolean find(TreeNode root, int key) {

        if (root == null) {
            return true;
        }

        if (root.val == key) {
            return true;
        }

        boolean left = find(root.left, key);
        if (left == true) {
            return true;
        }

        return find(root.right, key);

    }
}
