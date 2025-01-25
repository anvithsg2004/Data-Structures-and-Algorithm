package DSA.Practice.Tree.BFS;

public class Cousins_in_Binary_Tree {

    public boolean isCousins(TreeNode root, int x, int y) {
        //First find the nodes.
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
                //First -> It should be at the same level or the depth.
                //Second -> It should be from the same Grand Father.
                //          It should be from the different father.
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    //Find the level or the depth of the node which I have found out.
    //Same method that I have used for the find the target node.
    int level(TreeNode root, TreeNode x, int lev) {
        if (root == null) {
            return 0;
        }

        if (root == x) {
            return lev;
        }

        int l = level(root.left, x, lev + 1);
        if (l != 0) {
            return l;
        }

        return level(root.right, x, lev + 1);
    }

    boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null) {
            return false;
        }

        return (
                (root.left == x && root.right == y) || (root.left == y && root.right == x) || (isSibling(root.left, x, y)) || (isSibling(root.right, x, y))
        );
    }

    //Method to find the node.
    TreeNode findNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }

        if (root.val == x) {
            return root;
        }

        TreeNode n = findNode(root.left, x);
        if (n != null) {
            return n;
        }

        return findNode(root.right, x);
    }

    public static void main(String[] args) {

    }
}
