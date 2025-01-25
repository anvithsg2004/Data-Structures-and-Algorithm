package DSA.LeetCode.Trees;

public class Evaluate_Boolean_Binary_Tree {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.val == 0) {
            return false;
        } else if (root.val == 1) {
            return true;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        } else if (root.val == 3) {
            return left && right;
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
