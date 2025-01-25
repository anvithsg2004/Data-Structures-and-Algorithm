package DSA.Practice.Tree.Leetcode_Easy;

public class _24_Symmetric_Tree {

    //This is just as the same tree problem.


    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    public static void main(String[] args) {

    }
}
