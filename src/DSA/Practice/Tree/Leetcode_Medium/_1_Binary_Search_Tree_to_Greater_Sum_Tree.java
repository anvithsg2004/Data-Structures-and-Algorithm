package DSA.Practice.Tree.Leetcode_Medium;

public class _1_Binary_Search_Tree_to_Greater_Sum_Tree {

    //Just the basic inorder traversal and with a small and heavy plot twist.
    //But instead of left→root→right
    //Change it to right→root→left

    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1];
        reverseInorder(root, sum);
        return root;
    }

    public void reverseInorder(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right, sum);
        sum[0] = sum[0] + root.val;
        root.val = sum[0];
        reverseInorder(root.left, sum);
    }
}
