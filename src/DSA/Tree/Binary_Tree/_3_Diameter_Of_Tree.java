package DSA.Tree.Binary_Tree;

public class _3_Diameter_Of_Tree {

    static int diameter = 0;

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
