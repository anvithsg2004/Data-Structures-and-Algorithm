package DSA.Tree.Binary_Tree;

public class _1_Height_Of_Tree {

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
