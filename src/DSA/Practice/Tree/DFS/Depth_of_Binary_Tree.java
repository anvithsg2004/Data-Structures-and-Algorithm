package DSA.Practice.Tree.DFS;

public class Depth_of_Binary_Tree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;

        return depth;
    }

    public static void main(String[] args) {

    }
}
