package DSA.Practice.Tree.DFS;

public class Least_Common_Ancester {

    public TreeNode fun(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = fun(root.left, p, q);
        TreeNode right = fun(root.right, p, q);

        return left == null ? right : left;
    }

    public static void main(String[] args) {

    }
}
