package DSA.Tree.Binary_Tree;

public class _2_Balanced_Or_Not {

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    public static boolean balanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) <= 1 && balanced(root.left) && balanced(root.right)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
