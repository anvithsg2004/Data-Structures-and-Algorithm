package DSA.Tree.Binary_Tree;

public class _3_Diameter_Of_Tree {

    public int diameterOfBinaryTree(TreeNode root) {

        int[] diameter = new int[1];

        helper(root, diameter);

        return diameter[0];

    }

    public void helper(TreeNode root, int[] diameter) {

        if (root == null) {
            return;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter[0] = Math.max(diameter[0], left + right);

        helper(root.left, diameter);
        helper(root.right, diameter);

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
