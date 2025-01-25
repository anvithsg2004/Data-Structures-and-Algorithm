package DSA.Practice.Tree.Leetcode_Easy;

public class _1_Range_Sum_of_BST {

    int sum;

    //Just calculating the sum of the root values which are in the range of the given values.

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }

    //Doing the Pre-Order Traversal

    public void helper(TreeNode root, int low, int high) {
        //Root
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        //Left Node
        helper(root.left, low, high);
        //Right Node
        helper(root.right, low, high);
    }

    public static void main(String[] args) {

    }
}
