package DSA.Practice.Tree.Leetcode_Easy;

public class _4_Evaluate_Boolean_Binary_Tree {

    //In this, the leaf nodes cannot be null.

    public boolean evaluateTree(TreeNode root) {

        //Post_Order Traversal

        //For the leaf nodes
        //Means the Left or Right
        if (root.val == 0) {
            return false;
        }

        if (root.val == 1) {
            return true;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        //This is for the Root Node
        if (root.val == 2) {
            return left || right;
        }

        if (root.val == 3) {
            return left && right;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
