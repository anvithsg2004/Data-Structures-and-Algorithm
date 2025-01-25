package DSA.Practice.Tree.DFS;

public class Path_Sum_Target {

    public boolean path(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum || root.left == null || root.right == null) {
            return true;
        }

        return path(root.left, targetSum - root.val) || path(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

    }
}
