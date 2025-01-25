package DSA.Practice.Tree.Leetcode_Easy;

public class _26_Balanced_Binary_Tree {

    //Post-Order Traversal

    public static int height(TreeNode root) {
        //Root
        if (root == null) {
            return 0;
        }

        //Left
        int left = height(root.left);
        //Right
        int right = height(root.right);

        // If any subtree is unbalanced, propagate -1 upwards to indicate imbalance
        //Do operation by taking the left and root
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1; // Return -1 to indicate that the subtree is not balanced
        }

        //Root
        return 1 + Math.max(left, right); // Otherwise, return the height of the current node
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1; // If height returns -1, the tree is unbalanced
    }

    public static void main(String[] args) {

    }
}
