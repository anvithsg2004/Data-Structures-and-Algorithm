package DSA.Tree.Binary_Tree;

public class _5_Identical_Or_Not {

    public static boolean identical(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }

        return (p.val == q.val) && identical(p.left, q.left) && identical(p.right, q.right);
    }
}
