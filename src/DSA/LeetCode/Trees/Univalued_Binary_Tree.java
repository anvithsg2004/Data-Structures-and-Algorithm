package DSA.LeetCode.Trees;

public class Univalued_Binary_Tree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.val != root.left.val) {
            return false;
        }

        if (root.right != null && root.val != root.right.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {

    }
}
