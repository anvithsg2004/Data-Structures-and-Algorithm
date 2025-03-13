package DSA.Tree.Binary_Tree;

public class _12_Symmetric {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return symmetry(root.left, root.right);
    }

    public static boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return (left.val == right.val) && symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }
}
