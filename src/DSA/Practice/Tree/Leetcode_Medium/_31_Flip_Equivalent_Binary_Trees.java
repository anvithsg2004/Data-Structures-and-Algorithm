package DSA.Practice.Tree.Leetcode_Medium;

public class _31_Flip_Equivalent_Binary_Trees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: both trees are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // If one tree is null and the other is not, they are not flip equivalent
        if (root1 == null || root2 == null) {
            return false;
        }

        // If the root values are not equal, they are not flip equivalent
        if (root1.val != root2.val) {
            return false;
        }

        // Check two cases:
        // 1. No flip: left subtree of root1 matches left subtree of root2, and right subtree of root1 matches right subtree of root2
        // 2. Flip: left subtree of root1 matches right subtree of root2, and right subtree of root1 matches left subtree of root2
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
