package DSA.LeetCode.Trees;

public class Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (root.left == subRoot.left && root.right == subRoot.right) {
            return true;
        }

        isSubtree(root.left, subRoot);
        isSubtree(root.right, subRoot);

        return false;
    }

    public static void main(String[] args) {

    }
}
