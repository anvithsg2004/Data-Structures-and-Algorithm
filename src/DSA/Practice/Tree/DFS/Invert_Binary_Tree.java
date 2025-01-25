package DSA.Practice.Tree.DFS;
//POST ORDER
//LEFT RIGHT ROOT

public class Invert_Binary_Tree {

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

    }
}
