package DSA.Practice.Tree.Leetcode_Easy;

public class _29_Subtree_of_Another_Tree {

    //Same as the previous problem like the same tree and identical tree.

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If both trees are null, subRoot is a subtree
        if (root == null && subRoot == null) {
            return true;
        }

        // If either tree is null, subRoot cannot be a subtree
        if (root == null || subRoot == null) {
            return false;
        }

        if (helper(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        return root.val == subRoot.val && helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }

    public static void main(String[] args) {

    }
}
