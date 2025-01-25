package DSA.LeetCode.Trees;

public class Minimum_Depth_of_Binary_Tree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return 1 + Math.max(left, right);
        }

        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {

    }
}
