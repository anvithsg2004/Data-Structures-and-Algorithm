package DSA.LeetCode.Trees;

public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == 0 || right == 0) {
            return 1 + Math.max(left, right);
        }

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
