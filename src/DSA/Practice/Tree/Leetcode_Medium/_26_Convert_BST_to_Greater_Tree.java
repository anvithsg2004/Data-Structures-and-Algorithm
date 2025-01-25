package DSA.Practice.Tree.Leetcode_Medium;

public class _26_Convert_BST_to_Greater_Tree {

    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        help(root, sum);
        return root;
    }

    public void help(TreeNode root, int[] sum) {

        if (root == null) {
            return;
        }

        help(root.right, sum);
        sum[0] = sum[0] + root.val;
        root.val = sum[0];
        help(root.left, sum);

    }

    public static void main(String[] args) {

    }
}
