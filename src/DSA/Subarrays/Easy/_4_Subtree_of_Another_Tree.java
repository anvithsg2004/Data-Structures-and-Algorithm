package DSA.Subarrays.Easy;

public class _4_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }

        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
            return true;
        }

        return false;

    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
