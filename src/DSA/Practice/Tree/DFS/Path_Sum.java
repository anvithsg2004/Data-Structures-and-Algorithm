package DSA.Practice.Tree.DFS;

public class Path_Sum {

    public static int sumPath(TreeNode root) {
        return help(root, 0);
    }

    public static int help(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = (sum * 10) + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return help(root.left, sum) + help(root.right, sum);
    }

    public static void main(String[] args) {

    }
}
